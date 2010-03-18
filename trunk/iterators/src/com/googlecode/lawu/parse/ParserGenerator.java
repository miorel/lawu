package com.googlecode.lawu.parse;

import static com.googlecode.lawu.util.Iterators.adapt;
import static com.googlecode.lawu.util.Iterators.iterator;
import static com.googlecode.lawu.util.Iterators.join;
import static com.googlecode.lawu.util.Iterators.lines;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.googlecode.lawu.util.Streams;

public class ParserGenerator {
	@SuppressWarnings("unchecked")
	public static void main(String[] arg) {
		List<Rule> rulesList = new ArrayList<Rule>();
		
		Map<String,Integer> strToInt = new HashMap<String,Integer>();
		List<String> intToStrList = new ArrayList<String>();
		
		String template = null;
		try {
			template = Streams.slurp(ParserGenerator.class.getResourceAsStream("parser_template.txt")).toString();
		}
		catch(IOException e) {
			System.err.println("Failed to read parser template!");
			System.exit(1);
		}
		
		StringBuilder parser = new StringBuilder();
		
		for(String rule: adapt(lines(ParserGenerator.class.getResourceAsStream("grammar.txt")))) {
			String[] arr = rule.trim().split("\\s*=\\s*");
			Rule r = new Rule(arr[0], arr[1].split("\\s+"));
			for(String sym: join(iterator(r.prod), iterator(r.sym))) {
				Integer symCode = strToInt.get(sym);
				if(symCode == null) {
					symCode = Integer.valueOf(intToStrList.size());
					intToStrList.add(sym);
					strToInt.put(sym, symCode);
				}
			}
			rulesList.add(r);
			//System.out.println("// " + r);
		}
		//System.out.println();
		
		int symCount = intToStrList.size();
		String[] intToStr = intToStrList.toArray(new String[symCount]);
		boolean[] isTerminal = new boolean[symCount];
		Arrays.fill(isTerminal, true);
		
		int ruleCount = rulesList.size();
		Rule[] rules = rulesList.toArray(new Rule[ruleCount]);
		
		for(Rule rule: rules)
			isTerminal[strToInt.get(rule.sym).intValue()] = false;
		
		StringBuilder terminals = new StringBuilder();
		for(int i = 0; i != symCount; ++i)
			if(isTerminal[i])
				terminals.append("\t\tTERMINALS.add(\"" +  intToStr[i] + "\");\n");
		//System.out.println();
		
		List<State> states = new ArrayList<State>();
		states.add(new State(new String[0]));
		
		for(int sti = 0; sti != states.size(); ++sti) {
			Set<String> noError = new HashSet<String>();
			State state = states.get(sti);
			parser.append(String.format("\t\tSTATE_%d { // %s\n\t\t\t@Override\n\t\t\tprotected Map<String,Action> getActionMap() {\n\t\t\t\tMap<String,Action> map = new HashMap<String,Action>();\n", Integer.valueOf(sti), state));
			for(String symbol: intToStr) {
				//System.out.println("// Considering " + state + "/ encountering symbol " + symbol);
				List<String> actions = new ArrayList<String>();
				for(Rule rule: rules) {
					//System.out.println("Looking at " + rule);
					State newState = new State(state, symbol);
					int matchSize = 0;
					int len = newState.prev.length;
					for(int ms = len; ms > 0; --ms) {
						if(Arrays.asList(newState.prev).subList(len - ms, len).equals(Arrays.asList(rule.prod).subList(0, Math.min(rule.prod.length, ms)))) {
							matchSize = ms;
							break;
						}
					}
					//System.out.print("Match size is " + matchSize + ". Action: ");
					if(matchSize == 0) {
						//System.out.println("ERROR");
					}
					else if(matchSize == rule.prod.length) {
						actions.add("new ReduceAction(" + matchSize + ", \"" + escape(rule.sym) + "\")");
					}
					else {
						newState = new State(Arrays.asList(newState.prev).subList(len - matchSize, len).toArray(new String[0]));
						if(!states.contains(newState))
							states.add(newState);
						actions.add("new PushAction(" + states.indexOf(newState) + ")");//System.out.println("GOTO " + newState);
					}
				}
				if(actions.isEmpty()) {
					//System.out.println("// " + "ERROR");
				}
//				else if(actions.size() > 1){
//					//System.out.println("// " + "AMBIGUOUS RESOLUTION!");
//				}
				else {
					String action = actions.get(0);
					//System.out.println("// " + actions.iterator().next());
					parser.append(String.format("\t\t\t\tmap.put(\"%s\", %s);\n", escape(symbol), action));
					noError.add(symbol);
				}
			}
			if(sti == 0)
				for(Rule rule: rules)
					if(!noError.contains(rule.sym)) {
						noError.add(rule.sym);
						parser.append(String.format("\t\t\t\tmap.put(\"%s\", new PushAction(-1));\n", escape(rule.sym)));
					}
			parser.append("\t\t\t\treturn map;\n\t\t\t}\n\t\t},\n");
		}
		//System.out.println();
		System.out.printf(template, parser, terminals);
	}
	
	private static String escape(String string) {
		return string.replaceAll("([\\\"\\\\])", "\\$1");
	}
}

class Rule {
	public final String sym;
	public final String[] prod;
	
	public Rule(String sym, String[] prod) {
		this.sym = sym;
		this.prod = prod;
	}
	
	public String toString() {
		return "Rule " + sym + " = " + Arrays.toString(prod);
	}
}

class State {
	public final String[] prev;
	
	public State(String[] prev) {
		this.prev = prev;
	}

	public State(State state, String symbol) {
		this.prev = new String[state.prev.length + 1];
		for(int i = 0; i != state.prev.length; ++i)
			this.prev[i] = state.prev[i];
		this.prev[state.prev.length] = symbol;
	}
	
	public String toString() {
		return "State " + Arrays.toString(prev);
	}
	
	public boolean equals(Object o) {
		return (o instanceof State) && Arrays.asList(prev).equals(Arrays.asList(((State) o).prev));
	}
	
	public int hashCode() {
		return toString().hashCode();
	}
}