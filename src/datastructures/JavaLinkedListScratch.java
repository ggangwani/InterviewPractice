package datastructures;

public class JavaLinkedListScratch {

	public static void main(String[] args) {

		LinkedList<Integer> lstLinkedList = new LinkedList<Integer>();
		lstLinkedList.addLast(1);
		lstLinkedList.addLast(2);
		lstLinkedList.addLast(3);
		lstLinkedList.addLast(4);
		lstLinkedList.addLast(5);
		System.out.println(lstLinkedList);
		lstLinkedList.removeLast();
		System.out.println("Removed last: " + lstLinkedList);
		lstLinkedList.removeFirst();
		System.out.println("Removed first: " + lstLinkedList);
		lstLinkedList.insertBefore(10,3);
		System.out.println("Insert before: " + lstLinkedList);
		lstLinkedList.insertAfter(20,3);
		System.out.println("Insert after: " + lstLinkedList);
		System.out.println("Size: " + lstLinkedList.size());
		
		// 50 does not exist in the list, so any insertions with be at the end
		lstLinkedList.insertAfter(30,50);
		System.out.println("Insert after invalid: " + lstLinkedList);
		lstLinkedList.insertBefore(40,50);
		System.out.println("Insert before invalid: " + lstLinkedList);

	}

}

class LinkedList<T> {

	class Node<T> {
		T data;
		Node<T> next;

		public Node(T data) {
			this.data = data;
		}
	}

	private Node<T> head;
	private Node<T> tail;

	private int size = 0;

	public void addFirst(T value) {
		Node<T> node = new Node<T>(value);
		if (isEmpty()) {
			head = node;
			tail = head;
		} else {
			node.next = head;
			head = node;
		}
		size++;
	}

	public void addLast(T value) {
		Node<T> node = new Node<T>(value);
		if (isEmpty()) {
			head = node;
			tail = head;
		} else {
			tail.next = node;
			tail = node;
		}
		size++;
	}
	
	public void insertBefore(T value, T insertionValue){
		Node<T> node = new Node<T>(value);
		Node<T> start = head;
		Node<T> prev = head;
		while(start != null && !start.data.equals(insertionValue)){
			prev = start;
			start = start.next;
		}
		Node<T> next = prev.next;
		prev.next = node;
		node.next = next;
		size++;
	}
	
	public void insertAfter(T value, T insertionValue){
		Node<T> node = new Node<T>(value);
		Node<T> start = head;
		while(start.next != null && !start.data.equals(insertionValue)){
			start = start.next;
		}
		Node<T> next = start.next;
		start.next = node;
		node.next = next;
		size++;
	}

	public T removeFirst() {
		T data = head.data;
		head = head.next;
		size--;
		return data;
	}

	public T removeLast() {
		T data = tail.data;
		Node<T> start = head;
		while(start.next != tail){
			start = start.next;
		}
		start.next = null;
		tail = start;
		size--;
		return data;
	}

	public boolean isEmpty() {
		return head == null && tail == null;
	}

	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		String text = "";
		Node<T> start = head;
		while(start != null){
			text = text + start.data + " -> ";
			start = start.next;
		}
		
		return text;
	}
}
