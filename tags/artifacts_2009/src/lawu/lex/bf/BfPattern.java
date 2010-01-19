package lawu.lex.bf;

import lawu.lex.TokenPattern;

public enum BfPattern implements TokenPattern {
	INCREMENT_POINTER('>'),
	DECREMENT_POINTER('<'),
	INCREMENT_BYTE('+'),
	DECREMENT_BYTE('-'),
	OUTPUT('.'),
	INPUT(','),
	WHILE_NOT_ZERO('['),
	CONTINUE(']'),
	COMMENT {
		@Override
		public int matchLength(CharSequence text) {
			if(text == null)
				throw new NullPointerException("");
			int ret = 0;
			for(int i = 0; i != text.length(); ++i) {
				if(COMMAND_CHARACTERS.indexOf(text.charAt(i)) >= 0)
					break;
				++ret;
			}
			return ret;
		}
	};

	private final char cmd;
	
	public final static String COMMAND_CHARACTERS;
	static {
		String tmp = ""; //$NON-NLS-1$
		for(BfPattern p: values())
			if(p != COMMENT)
				tmp += p.cmd;
		COMMAND_CHARACTERS = tmp;
	}
	
	private BfPattern(char cmd) {
		this.cmd = cmd;
	}
	
	private BfPattern() {
		this.cmd = '\0';
	}
	
	@Override
	public int matchLength(CharSequence text) {
		if(text == null) 
			throw new NullPointerException("");
		return text.length() != 0 && text.charAt(0) == this.cmd ? 1 : 0;
	}
}
