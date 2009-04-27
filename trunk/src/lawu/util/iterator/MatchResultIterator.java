/**
 * 
 */
package lawu.util.iterator;

import java.util.regex.MatchResult;

/**
 * @author Miorel-Lucian Palii
 */
public class MatchResultIterator extends AbstractUniversalIterator<String> {
	private final MatchResult match;
	private int pointer;
	
	public MatchResultIterator(MatchResult match) {
		this.match = match;
		reset();
	}
	
	@Override
	public void advance() {
		++this.pointer;
	}

	@Override
	public String current() {
		return this.match.group(this.pointer);
	}

	@Override
	public boolean isDone() {
		return this.pointer > this.match.groupCount();
	}

	@Override
	public void reset() {
		this.pointer = 1;
	}

}
