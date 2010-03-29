package com.googlecode.lawu.parse.java;

import static com.googlecode.lawu.util.Iterators.lines;
import static com.googlecode.lawu.util.Iterators.list;
import static com.googlecode.lawu.util.Iterators.map;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.googlecode.lawu.dp.Iterator;
import com.googlecode.lawu.lex.Token;
import com.googlecode.lawu.lex.java.JavaLexer;
import com.googlecode.lawu.lex.java.JavaPattern;
import com.googlecode.lawu.util.CharSequenceList;
import com.googlecode.lawu.util.CharacterMapper;
import com.googlecode.lawu.util.Mapper;
import com.googlecode.lawu.util.Pair;
import com.googlecode.lawu.util.Streams;

public class JavaParser {
	protected final static CharacterMapper<String> charMapper = new CharacterMapper<String>();
	private final static List<Pair<String,Pattern>> rules = new ArrayList<Pair<String,Pattern>>();
	
	static {
		for(String line: lines(JavaParser.class.getResourceAsStream("JavaRules.txt"))) {
			String[] rule = line.split("\\s*=\\s*", 2);
			StringBuffer sb = new StringBuffer();
			Matcher m = Pattern.compile("(\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*)|\\s+").matcher(rule[1]);
			while(m.find()) {
				String match = m.group(1);
				m.appendReplacement(sb, match == null ? "" : "\\\\Q" + charMapper.map(match).toString().replaceAll("([\\Q\\$\\E])", "\\\\$1") + "\\\\E");
			}
			m.appendTail(sb);
			rules.add(new Pair<String,Pattern>(rule[0], Pattern.compile(sb.toString(), Pattern.DOTALL)));
		}		
	}
	
	public JavaParser() {
	}

	public void parse(CharSequence text) {
		parse(new JavaLexer(text));
	}
	
	public void parse(Iterator<Token<JavaPattern>> tokens) {
		parse(list(map(
			new Mapper<Token<JavaPattern>,JavaNode>() {
				@Override
				public JavaNode map(Token<JavaPattern> token) {
					JavaNode ret = new JavaNode();
					ret.type = token.getType().toString();
					ret.value = token.getValue();
					return ret;
				}
			},
			tokens
		)));
	}
	
	private void parse(List<JavaNode> list) {
		CharSequence charSeq = new CharSequenceList<JavaNode>(new Mapper<JavaNode,Character>() {
			@Override
			public Character map(JavaNode node) {
				return charMapper.map(node.type);
			}
		}, list);
		
		while(list.size() > 1) {
			System.out.println("The list size is " + list.size());
			System.out.println(list);
			System.out.println();
			
//			DECLARATION_PACKAGE = KEYWORD_PACKAGE IDENTIFIER (SEPARATOR_PERIOD IDENTIFIER)* SEPARATOR_SEMICOLON
//			DECLARATION_IMPORT = KEYWORD_IMPORT KEYWORD_STATIC? IDENTIFIER (SEPARATOR_PERIOD IDENTIFIER)* (SEPARATOR_PERIOD OPERATOR)? SEPARATOR_SEMICOLON
			
			boolean good = false;
			int position = 0;
			
			for(Pair<String,Pattern> pair: rules) {
				Matcher m = pair.getSecond().matcher(charSeq);
				while(m.find(position)) {
					JavaNode newNode = new JavaNode();
					newNode.type = pair.getFirst();
					newNode.children.addAll(list.subList(m.start(), m.end()));
					list.set(m.start(), newNode);
					list.subList(m.start() + 1, m.end()).clear();
					position = m.start() + 1;
					good = true;
				}
			}
			
			if(!good)
				throw new RuntimeException("Parsing did not progress.");
		}		
		
		System.out.println("The list size is " + list.size());
		System.out.println(list);
		System.out.println();
	}

	public static void main(String[] arg) throws Throwable {
		StringBuilder sb = Streams.slurp(System.in);
		JavaParser parser = new JavaParser();
		parser.parse(sb);
	}
}

class JavaNode {
	public String type;
	public String value;
	
	public final List<JavaNode> children = new ArrayList<JavaNode>();
	
	public String toString() {
		return type;
	}
}