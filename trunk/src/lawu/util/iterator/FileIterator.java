package lawu.util.iterator;

import java.io.File;
import java.util.Arrays;
import java.util.Stack;

import lawu.dp.Iterator;

/**
 * @author Miorel-Lucian Palii
 */
public class FileIterator extends AbstractUniversalIterator<File> {
	private final Stack<Iterator<File>> iterators;
	private final File root;

	public FileIterator(File file) {
		this.root = file;
		this.iterators = new Stack<Iterator<File>>();
		reset();
	}

	@Override
	public void advance() {
		if(!isDone()) {
			File currentFile = current();
			this.iterators.peek().advance();
			if(currentFile.isDirectory()) {
				File[] fileArray = currentFile.listFiles();
				Arrays.sort(fileArray);
				Iterator<File> fileIter = Iterators.iterator(fileArray);
				fileIter.reset();
				this.iterators.push(fileIter);
			}
			while(!isDone() && this.iterators.peek().isDone())
				this.iterators.pop();
		}
	}

	@Override
	public File current() {
		return this.iterators.peek().current();
	}

	@Override
	public boolean isDone() {
		return this.iterators.isEmpty();
	}

	@Override
	public void reset() {
		this.iterators.clear();
		this.iterators.add(Iterators.iterator(this.root));
	}
}
