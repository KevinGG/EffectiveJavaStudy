package ds.linkedlist.nongeneric;

/**
 * With this implementation, a {@link LinkedList} would be able to add null into the list
 */
public class NullList implements LinkedList{
	private LinkedList next;
	
	@Override
	public Integer item() {
		return null;
	}

	@Override
	public LinkedList next() {
		return next;
	}

	@Override
	public LinkedList setNext(LinkedList next) {
		this.next = next;
		return this;
	}

	@Override
	public LinkedList addNext(LinkedList next) {
		this.next = next;
		return next;
	}

}
