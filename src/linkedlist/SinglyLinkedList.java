package linkedlist;

public class SinglyLinkedList {

	private Node head;

	public SinglyLinkedList() {
		head = new Node(0, null);
	}

	public void insertTail(int data) {
		Node newNode = new Node(data, null);
		Node p = head;
		while (p.next != null) {
			p = p.next;
		}
		p.next = newNode;
	}

	public void insertHead(Node newNode) {
		newNode.next = head.next;
		head.next = newNode;
	}

	public void insertHead(int data) {
		Node newNode = new Node(data, null);
		insertHead(newNode);
	}

	public void inverseLinkedList(Node endNode) {
		Node p = head.next, cur;
		head.next =null;
		while (p != null && p != endNode) {
			cur = p.next;
			insertHead(p);
			p = cur;
		}
	}

	public void printAll() {
		Node p = head.next;
		while (p != null) {
			System.out.print(p + " ");
			p = p.next;
		}
		System.out.println();
	}

	class Node {
		private int data;
		private Node next;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

		@Override
		public String toString() {
			return data + "";
		}

	}

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		int[] data= {1,2,3,4,5};
		for(int i=0;i<data.length;i++) {
			list.insertTail(data[i]);
		}
		list.printAll();
		list.inverseLinkedList(null);
		list.printAll();
	}

}
