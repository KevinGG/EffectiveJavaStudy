package simpletests.ds.linkedlist;

import ds.linkedlist.LinkedList;

public class Main {
	public static void main(String[] argv){
		LinkedList<Integer> head = new LinkedList<>(1);
		LinkedList<Integer> tmpNext = head;
		for(int i = 2; i < 9; i++){
			tmpNext = tmpNext.add(new LinkedList<>(i));
		}
		head.print();
		LinkedList<Integer> tail = tmpNext;
		
		int m = 5;
		tmpNext = head;
		
		for(int i = 0; i < m-1; i ++){
			tmpNext = tmpNext.next();
		}
		LinkedList<Integer> newTail = tmpNext;
		LinkedList<Integer> newHead = tmpNext.next();
		tail.setNext(head);
		newTail.setNext(null);
		newHead.print();
	}
	
}
