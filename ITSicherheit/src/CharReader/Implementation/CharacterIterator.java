package CharReader.Implementation;

import java.util.Iterator;

import CharReader.Interface.CharReader;

public class CharacterIterator implements Iterator<Character> {

	CharReader ds;

	private CharacterIterator(CharReader ds) {
		this.ds = ds;
	}
	
	public static CharacterIterator valueOf(CharReader ds){
		return new CharacterIterator(ds);
	}

	@Override
	public boolean hasNext() {
		return ds.hasNext();
	}

	@Override
	public Character next() {
		return ds.next();
	} 

	@Override
	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Operation is not supported");
	}

}