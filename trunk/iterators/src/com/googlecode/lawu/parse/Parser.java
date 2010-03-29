package com.googlecode.lawu.parse;

import static com.googlecode.lawu.util.Iterators.adapt;
import static com.googlecode.lawu.util.Iterators.iterator;
import static com.googlecode.lawu.util.Iterators.lines;
import static com.googlecode.lawu.util.Iterators.list;
import static com.googlecode.lawu.util.Iterators.map;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import com.googlecode.lawu.lex.Token;
import com.googlecode.lawu.lex.java.JavaLexer;
import com.googlecode.lawu.lex.java.JavaPattern;
import com.googlecode.lawu.util.Mapper;
import com.googlecode.lawu.util.Pair;
import com.googlecode.lawu.util.Streams;

public class Parser {
	private static List<Rule> rules = new ArrayList<Rule>();
	private static Set<String> symbolSet = new HashSet<String>();
	
	private static class Rule {
		public final String symbol;
		public final String[] production;
		
		public Rule(String symbol, String[] production) {
			this.symbol = symbol;
			this.production = production;
		}
		
		public String toString() {
			return "Rule " + symbol + " = " + Arrays.toString(production);
		}
	}

	private static class State {
		public final Node[] stack;
		
		public State(Node[] stack) {
			this.stack = stack;
		}

		public State(State state, Node node) {
			this.stack = new Node[state.stack.length + 1];
			for(int i = 0; i != state.stack.length; ++i)
				this.stack[i] = state.stack[i];
			this.stack[state.stack.length] = node;
		}
		
		public String toString() {
			return "State " + Arrays.toString(stack);
		}
		
		public boolean equals(Object o) {
			return (o instanceof State) && Arrays.asList(stack).equals(Arrays.asList(((State) o).stack));
		}
		
		public int hashCode() {
			return toString().hashCode();
		}
	}
	
	public static void main(String[] arg) throws IOException {
		for(String rule: adapt(lines(Parser.class.getResourceAsStream("grammar.txt")))) {
			String[] arr = rule.trim().split("\\s*=\\s*");
			Rule r = new Rule(arr[0], arr[1].split("\\s+"));
			rules.add(r);
			symbolSet.add(r.symbol);
			for(String symbol: r.production)
				symbolSet.add(symbol);
		}
		JavaLexer lexer = new JavaLexer(Streams.slurp(System.in));
		List<State> states = new ArrayList<State>();
		states.add(new State(new Node[0]));
		List<Node> parseTrees = new ArrayList<Node>();
		for(String symbol: map(new Mapper<Token<JavaPattern>,String>() {
			@Override
			public String map(Token<JavaPattern> token) {
				return token.getType().toString();
			}
		}, lexer)) {
			List<State> newStates = new ArrayList<State>();
			Stack<Pair<State,Node>> stack = new Stack<Pair<State,Node>>();
			for(State state: states)
				stack.add(new Pair<State,Node>(state, new Node(symbol)));
			while(!stack.isEmpty()) {
				Pair<State,Node> pair = stack.pop();
				State state = pair.getFirst();
				Node node = pair.getSecond();
				//System.out.println(state + " encountering symbol " + symbol);
				if(state.stack.length == 0 && node.type.equals("<syntax>"))
					parseTrees.add(node);
				for(Rule rule: rules) {
					//System.out.println("Matching " + rule);
					State newState = new State(state, node);
					for(int matchLength = Math.min(newState.stack.length, rule.production.length); matchLength > 0; --matchLength) {
						List<String> listA = Arrays.asList(rule.production).subList(0, matchLength);
						List<String> listB = list(map(new Mapper<Node,String>() {
							@Override
							public String map(Node node) {
								return node.type;
							}
						}, iterator(Arrays.asList(newState.stack).subList(newState.stack.length - matchLength, newState.stack.length))));
						if(listA.equals(listB)) {
							//System.out.println("Matched length " + matchLength);
							if(matchLength == rule.production.length) {
								//System.out.println("REDUCE");
								State interm = new State(Arrays.asList(newState.stack).subList(0, newState.stack.length - matchLength).toArray(new Node[0]));
								Node newNode = new Node(rule.symbol);
								newNode.children.addAll(Arrays.asList(newState.stack).subList(newState.stack.length - matchLength, newState.stack.length));
								stack.add(new Pair<State,Node>(interm, newNode));
							}
							else {
								//System.out.println("SHIFT");
								if(!newStates.contains(newState))
									newStates.add(newState);
							}
						}
					}
				}
			}
			states = newStates;
		}
		System.out.println(!parseTrees.isEmpty() ? "Parse succeeded!" : "Parse failed.");
		System.out.println();
		for(Node node: parseTrees) {
			System.out.println();
			node.print(System.out);
		}
	}
}