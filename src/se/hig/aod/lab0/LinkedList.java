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
		ListNode<T> newNode = new ListNode<>(t);
		newNode.next = head;
		head = newNode;
	}

	@Override
	public void insertLast(T t) {
		ListNode<T> newNode = new ListNode<>(t);

		if (head == null) {
			head = newNode;
		} else {
			ListNode<T> temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}

	@Override
	public T removeFirst() {
		if (isEmpty()) {
			throw new ListEmptyException("Listan är tom");
		}

		T first = head.data;
		head = head.next;

		return first;
	}

	@Override
	public T removeLast() {
		if (isEmpty()) {
			throw new ListEmptyException("Listan är tom");
		}

		if (head.next == null) {
			T data = head.data;
			head = null;
			return data;
		}

		ListNode<T> temp = head;
		while (temp.next.next != null) { // Letar efter den näst sista noden
			temp = temp.next; // Sparar den sista noden i temp
		}

		T data = temp.next.data; // Hämtar datan i den sista noden och sparar i data
		temp.next = null; // Tar bort den sista noden
		return data; // Returnerar data
	}

	@Override
	public T getFirst() {
		if (isEmpty()) {
			throw new ListEmptyException("Listan är tom");
		} else {
			return head.data;
		}
	}

	@Override
	public T getLast() {
		if (isEmpty()) {
			throw new ListEmptyException("Listan är tom");
		}

		ListNode<T> temp = head;

		while (temp.next != null) {
			temp = temp.next;
		}

		return temp.data;
	}

}
