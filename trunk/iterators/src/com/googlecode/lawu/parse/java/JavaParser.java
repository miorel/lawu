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
import com.googlecode.lawu.util.iterators.UniversalIterator;

public class JavaParser {
	public JavaParser() {
	}

	public void parse(CharSequence text) {
		parse(new JavaLexer(text));
	}
	
	public void parse(Iterator<Token<JavaPattern>> tokens) {
		UniversalIterator<Node> iter = map(
			new Mapper<Token<JavaPattern>,Node>() {
				@Override
				public Node map(Token<JavaPattern> token) {
					Node ret = new Node();
					JavaPattern type = token.getType();
					String value = token.getValue();
					ret.type = type.toString();
					ret.value = value;
					return ret;
				}
			},
			tokens
		);
		List<Node> nodeList = list(iter);
		
		List<String> stringList = new ArrayList<String>();
		for(Node node: nodeList)
			stringList.add(node.type);
		CharacterMapper<String> cm = new CharacterMapper<String>();
		//CharSequenceList<String> charSeq = new CharSequenceList<String>(cm, stringList);
		
		List<Pair<String,Pattern>> rules = new ArrayList<Pair<String,Pattern>>();
		for(String line: lines(JavaParser.class.getResourceAsStream("JavaRules.txt"))) {
			String[] comp = line.split("\\s*=\\s*", 2);
			System.out.println(comp[1]);
			StringBuffer sb = new StringBuffer();
			Matcher m = Pattern.compile("(\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*)|\\s+").matcher(comp[1]);
			while(m.find()) {
				String match = m.group(1);
				if(match != null)
					System.out.println("Building rule for " + comp[0] + " with element " + match);
				m.appendReplacement(sb, match == null ? "" : "\\\\Q" + cm.map(match).toString().replaceAll("[\\Q$\\\\E]", "\\\\$1") + "\\\\E");
			}
			m.appendTail(sb);
			System.out.println("Regex: " + "\\A" + sb.toString());
			rules.add(new Pair<String,Pattern>(comp[0], Pattern.compile("\\A" + sb.toString(), Pattern.DOTALL)));
		}
		
		for(int pos = 0; pos < stringList.size();) {
			CharSequenceList<String> charSeq = new CharSequenceList<String>(cm, stringList, pos, stringList.size());
			//System.out.println("Looking at position " + pos + ": " + new StringBuilder(charSeq));
			boolean good = false;
			for(Pair<String,Pattern> pair: rules) {
				Matcher m = pair.getSecond().matcher(charSeq);
				if(m.find()) {
					System.out.println("Matched " + pair.getFirst() + " from " + pos + " to " + (pos + m.end()) + ".");
					pos += m.end();
					good = true;
					break;
				}
			}
			if(!good)
				throw new RuntimeException("Parsing failed.");
		}
		
		for(Node node: nodeList)
			System.out.printf("%20s %s%n", node.type, node.value.replaceAll("\\n", "\\\\n"));
	}

	public static void main(String[] arg) throws Throwable {
		StringBuilder sb = Streams.slurp(System.in);
		JavaParser parser = new JavaParser();
		parser.parse(sb);
	}
}

class Node {
	public String type;
	public String value;
}