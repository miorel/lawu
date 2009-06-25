/**
 * 
 */
package lawu.lex;

public class Token<P extends TokenPattern> {
	private final P type;
	private final String value;
	
	public Token(P type, String value) {
		this.type = type;
		this.value = value;
	}
	
	public P getType() {
		return this.type;
	}
	
	public String getValue() {
		return this.value;
	}
}
