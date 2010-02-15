package com.googlecode.lawu.json;

import java.math.BigDecimal;

import com.googlecode.lawu.util.Pair;
import com.googlecode.lawu.util.Triple;

public class JsonParser {
	public JsonParser() {
	}
	
	public JsonValue parse(CharSequence json) {
		Pair<? extends JsonValue, Integer> parseResult;
		try {
			parseResult = readValue(json, 0);
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
		if(parseResult.getSecond().intValue() != json.length())
			throw new RuntimeException();
		return parseResult.getFirst();
	}

	private abstract class JsonListValueReader<T extends JsonValue> {
		private final char start;
		private final char separator;
		private final char end;
		
		private int len = 0;
		
		public JsonListValueReader(char start, char separator, char end) {
			this.start = start;
			this.separator = separator;
			this.end = end;
		}
		
		protected abstract T getValue();
		
		protected abstract void readElement(int position);
		
		protected void incrementLength(int amount) {
			len += amount;
		}
		
		public Pair<T, Integer> readList(CharSequence json, int position) {
			boolean started = false;
			for(;position + len < json.length();) {
				while(Character.isWhitespace(json.charAt(position + len)))
					++len;
				char c = json.charAt(position + len);
				if(started) {
					if(c == separator)
						++len;
					else if(c == end) {
						++len;
						break;
					}
					else
						throw new RuntimeException();
				}
				else {
					if(c == start) {
						++len;
						while(Character.isWhitespace(json.charAt(position + len)))
							++len;
						if(json.charAt(position + len) == end) {
							++len;
							break;
						}
						started = true;
					}
					else
						throw new RuntimeException();
				}
				readElement(position + len);
			}
			while(position + len < json.length() && Character.isWhitespace(json.charAt(position + len)))
				++len;
			return new Pair<T, Integer>(getValue(), len);
		}
	}
	
	protected Pair<JsonObject, Integer> readObject(final CharSequence json, int position) {
		final JsonObject object = new JsonObject();
		return new JsonListValueReader<JsonObject>('{', ',', '}') {
			@Override
			protected JsonObject getValue() {
				return object;
			}

			@Override
			protected void readElement(int position) {
				Triple<String, ? extends JsonValue, Integer> parseResult = readPair(json, position);
				incrementLength(parseResult.getThird().intValue());
				object.put(parseResult.getFirst(), parseResult.getSecond());
			}
		}.readList(json, position);
	}
	
	protected Pair<JsonArray, Integer> readArray(final CharSequence json, int position) {
		final JsonArray array = new JsonArray();
		return new JsonListValueReader<JsonArray>('[', ',', ']') {
			@Override
			protected JsonArray getValue() {
				return array;
			}

			@Override
			protected void readElement(int position) {
				Pair<? extends JsonValue, Integer> parseResult = readValue(json, position);
				incrementLength(parseResult.getSecond().intValue());
				array.add(parseResult.getFirst());
			}
		}.readList(json, position);
	}

	protected Triple<String, ? extends JsonValue, Integer> readPair(CharSequence json, int position) {
		int len = 0;
		while(Character.isWhitespace(json.charAt(position + len)))
			++len;
		Pair<JsonString, Integer> key = readString(json, position + len);
		len += key.getSecond().intValue();
		while(Character.isWhitespace(json.charAt(position + len)))
			++len;
		if(json.charAt(position + len) == ':')
			++len;
		else
			throw new RuntimeException();
		Pair<? extends JsonValue, Integer> value = readValue(json, position + len);
		len += value.getSecond().intValue();
		return new Triple<String, JsonValue, Integer>(key.getFirst().getValue(), value.getFirst(), Integer.valueOf(len));
	}
	
	protected Pair<JsonNumber, Integer> readNumber(CharSequence json, int position) {
		int len = 0;
		for(char c; position + len < json.length(); ++len) {
			c = Character.toLowerCase(json.charAt(position + len));
			if(c != '+' && c != '-' && c != 'e' && c != '.' && !('0' <= c && c <= '9'))
				break;
		}
		return new Pair<JsonNumber, Integer>(new JsonNumber(new BigDecimal(json.subSequence(position, position + len).toString().toLowerCase())), Integer.valueOf(len));
	}
	
	protected Pair<JsonNull, Integer> readNull(CharSequence json, int position) {
		int len = 0;
		while(Character.isWhitespace(json.charAt(position + len)))
			++len;
		if(!json.subSequence(position + len, position + len + 4).toString().toLowerCase().equals("null"))
			throw new RuntimeException();
		len += 4;
		while(position + len < json.length() && Character.isWhitespace(json.charAt(position + len)))
			++len;
		return new Pair<JsonNull, Integer>(JsonNull.getInstance(), len);
	}
	
	protected Pair<JsonBoolean, Integer> readBoolean(CharSequence json, int position) {
		int len = 0;
		while(Character.isWhitespace(json.charAt(position + len)))
			++len;
		char c = Character.toLowerCase(json.charAt(position + len));
		String anticipated = c == 't' ? "true" : "false";
		len += anticipated.length();
		String actual = json.subSequence(position, position + len).toString().trim().toLowerCase();
		if(!anticipated.equals(actual))
			throw new RuntimeException();
		while(position + len < json.length() && Character.isWhitespace(json.charAt(position + len)))
			++len;
		return new Pair<JsonBoolean, Integer>(new JsonBoolean(c == 't'), Integer.valueOf(len));
	}
	
	protected Pair<JsonString, Integer> readString(CharSequence json, int position) {
		int len = 0;
		while(Character.isWhitespace(json.charAt(position + len)))
			++len;
		if(json.charAt(position + len) == '"')
			++len;
		else
			throw new RuntimeException();
		StringBuilder sb = new StringBuilder();
		for(char c; (c = json.charAt(position + len)) != '"'; ++len) {
			if(c == '\\')
				switch(c = json.charAt(position + ++len)) {
				case '"':
				case '\\':
				case '/':
					sb.append(c);
					break;
				case 'b':
					sb.append("\b");
					break;
				case 'f':
					sb.append("\f");
					break;
				case 'n':
					sb.append("\n");
					break;
				case 'r':
					sb.append("\r");
					break;
				case 't':
					sb.append("\t");
					break;
				case 'u':
					sb.append((char) Integer.parseInt(json.subSequence(position + len + 1, position + len + 5).toString().toLowerCase(), 16));
					len += 4;
					break;
				default:
					throw new RuntimeException();
				}
			else
				sb.append(c);
		}
		++len;
		while(position + len < json.length() && Character.isWhitespace(json.charAt(position + len)))
			++len;
		return new Pair<JsonString, Integer>(new JsonString(sb), Integer.valueOf(len));
	}
	
	protected Pair<? extends JsonValue, Integer> readValue(CharSequence json, int position) {
		Pair<? extends JsonValue, Integer> ret = null;
		int index = position;
		for(char c; ret == null; ++index)
			switch(c = Character.toLowerCase(json.charAt(index))) {
			case '{':
				ret = readObject(json, position);
				break;
			case '[':
				ret = readArray(json, position);
				break;
			case '"':
				ret = readString(json, position);
				break;
			case 't':
			case 'f':
				ret = readBoolean(json, position);
				break;
			case 'n':
				ret = readNull(json, position);
				break;
			default:
				if(Character.isWhitespace(c))
					;
				else if(c == '-' || ('0' <= c && c <= '9'))
					ret = readNumber(json, position);
				else
					throw new RuntimeException();
				break;
			}
		return ret;
	}
}
