// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
import java.util.NoSuchElementException;
class PeekingIterator implements Iterator<Integer> {
    
    Iterator<Integer> iterator;
    int cache;
    boolean _hasNext = true;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
        _hasNext = iterator.hasNext();
        if (_hasNext) cache = iterator.next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (!hasNext()) throw new NoSuchElementException();
        return cache;
	}
    
    protected void _next() {
        _hasNext = iterator.hasNext();
        if (_hasNext) cache = iterator.next();
    }

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if (!hasNext()) throw new NoSuchElementException();
	    int r = cache;
        _next();
        return r;
	}

	@Override
	public boolean hasNext() {
	    return _hasNext;
	}
}