package se.hig.aod.lab0;

public class LinkedList<T> implements List<T> {

	class ListNode<T> {
		T data;
		ListNode<T> next;

		ListNode(T d) {
			data = d;
			next = null;
		}
	}

	
	ListNode<T> head;

	@Override
	public boolean isEmpty() {
		return (head == null);
		
	}

	@Override
	public void clear() {
		head = null;
		System.out.println("hej");
	}

	@Override
	public int numberOfElements() {
		ListNode<T> temp = head;
		int countElements = 0;

		while (temp != null) {
			countElements++;
			temp = temp.next;
		}

		return countElements;

	}

	@Override
	public void insertFirst(T t) {
		ListNode<T> insertF = head;
		insertF.data = t;
	}

	@Override
	public void insertLast(T t) {
		ListNode<T> newNode = new ListNode<>(t);

		if (head == null) {
			head = newNode;
		} else {
			ListNode<T> temp = head;
			while (temp != null) {
				temp = temp.next;
			}
		}
		temp.next = newNode;
	}

	@Override
	public T removeFirst() {
		T first;
		try {
			head.data = null;
		} catch (Exception e) {
			throw new ListEmptyException("Listan är tom");
		}
		return first;
	}

	@Override
	public T removeLast() {
		T last;
		try {
			
		} catch (Exception e) {
			throw new ListEmptyException("Listan är tom");
		}
		return last;
		// throw new UnsupportedOperationException("Unimplemented method 'removeLast'");
	}

	@Override
	public T getFirst() {
		T first;
		try {
		} catch (Exception e) {
			throw new ListEmptyException("Listan är tom");
		}
		return first;
		// throw new UnsupportedOperationException("Unimplemented method 'getFirst'");
	}

	@Override
	public T getLast() {
		T last;
		try {
		} catch (Exception e) {
			throw new ListEmptyException("Listan är tom");
		}
		return last;
		// throw new UnsupportedOperationException("Unimplemented method 'getLast'");
	}

}
