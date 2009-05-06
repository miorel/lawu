/**
 * 
 */
package lawu.util.iterator;

/**
 * @author Miorel-Lucian Palii
 */
public class CharacterIterator extends AbstractUniversalIterator<Character> {
	private final CharSequence sequence;
	private int pointer;

	/**
	 * @param sequence
	 */
	public CharacterIterator(CharSequence sequence) {
		this.sequence = sequence;
		reset();
	}
	
	@Override
	public void advance() {
		++this.pointer;
	}

	@Override
	public Character current() {
		return Character.valueOf(this.sequence.charAt(this.pointer));
	}

	@Override
	public boolean isDone() {
		return this.pointer >= this.sequence.length();
	}

	@Override
	public void reset() {
		this.pointer = 0;
	}
}
