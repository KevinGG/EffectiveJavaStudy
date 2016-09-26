package ds.linkedlist.nongeneric;

public class LinkedListImpl implements LinkedList{
	private Integer item;
	private LinkedList next;
	
	public LinkedListImpl(Integer item) {
		this.item = item;
		this.next = null;
	}
	
	@Override
	public Integer item() {
		return item;
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
		return this.next;
	}

}
