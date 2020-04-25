package linkedlist;

import java.util.LinkedList;

public class SinglyLinkedList {

	private Node head;
//	private int size;

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

	private void insertAfter(Node p, Node newNode) {
		if(p == null)
			return;
		newNode.next = p.next;
		p.next = newNode;
	}

	public void insertHead(int data) {
		Node newNode = new Node(data, null);
		insertAfter(head, newNode);
	}
	
	public void inverseLinkedList() {
		inverseLinkedList(head);
	}

	private void inverseLinkedList(Node beginNode) {
		Node p = beginNode.next, cur;
		beginNode.next =null;
		while (p != null) {
			cur = p.next;
			insertAfter(beginNode, p);
			p = cur;
		}
	}
	
	/**Determine is it palindrome */
	public boolean isPalindrome() {
		Node p,q;
		boolean flag = true;
		if(head.next == null)
			return false;
		p = q = head.next;
		while(q.next!=null && q.next.next!=null) {
			p = p.next;
			q = q.next.next;
		}
		inverseLinkedList(p);
		Node left=head.next,right=p.next;
		while(right!=null) {
			if(right.data != left.data) {
				flag = false;
				break;
			}
			left=left.next;
			right=right.next;
		}
		inverseLinkedList(p);
		return flag;
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
		int[] data= {1,2};
		for(int i=0;i<data.length;i++) {
			list.insertTail(data[i]);
		}
		System.out.println(list.isPalindrome());
		list.printAll();
//		list.inverseLinkedList();
//		list.printAll();
	}

}
