package ds.linkedlist;

public class LinkedList<T> {
	private T t;
	private LinkedList<T> next;
	
	public LinkedList(final T t){
		this.t = t;
		next = null;
	}
	
	public T item(){
		return t;
	}
	
	public LinkedList<T> next(){
		return next;
	}
	
	public boolean hasNext(){
		return !(next==null);
	}
	
	public LinkedList<T> setNext(final LinkedList<T> t){
		next = t;
		return this;
	}
	
	public LinkedList<T> add(final LinkedList<T> t){
		next = t;
		return next;
	}
	
	public void print(){
		System.out.print("List: ");
		LinkedList<T> tmpNext = this;
		while(tmpNext.hasNext()){
			System.out.print(tmpNext.t + " -> ");
			tmpNext = tmpNext.next;
		}
		System.out.println(tmpNext.t);
	}
	
}
