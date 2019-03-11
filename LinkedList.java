package assignment1;

public class LinkedList<T> {
	private class Node<E>{
		private E data;
		private Node<E> next;
		private Node<E> prev;
		public Node(){
			setData(null);
			setNext(null);
			setPrev(null);
		}
		public Node(E e){
			setData(e);
			setNext(null);
			setPrev(null);
		}
		public Node<E> getNext() {
			return next;
		}
		public void setNext(Node<E> next) {
			this.next = next;
		}
		public E getData() {
			return data;
		}
		public void setData(E data) {
			this.data = data;
		}
		public Node<E> getPrev() {
			return prev;
		}
		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}
	}
	
	private int size;
	private Node<T> head;
	private Node<T> tail;
	public LinkedList(){
		size = 0;
		head = new Node<T>();
		tail = new Node<T>();
		head.setNext(tail);
		tail.setPrev(head);
	}
	public void addLast(T e) {
		Node<T> temp = new Node<T>(e);
		if(size == 0)
			head.setNext(temp);
		temp.setNext(tail);
		temp.setPrev(tail.getPrev());
		tail.getPrev().setNext(temp);
		tail.setPrev(temp);
		size++;
		
	}
	public T getIndex(int x) throws IndexOutOfBoundsException{
		if(x >= size || x < 0)
			throw new IndexOutOfBoundsException("Index is out of bounds");
		Node<T> trav;
		if(x < size / 2) {
			trav = head;
			for(int i = 0; i < x; i++) 
				trav = trav.getNext();
			return trav.getNext().getData();
	}
		else {
			trav = tail;
			for(int i = size; i < x; i--) 
				trav = trav.getPrev();
			return trav.getData();
		}
		
	}
}
