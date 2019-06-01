package CircularLL;

import java.util.Scanner;

public class Traversal {

	static Node head = null;
	static Node tail = null;
	static Node temp = null;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}

	}

	static void insert_values(int val) {
		Node node = new Node(val);
		if (head == null) {
			tail = head = node;
		} else {
			tail.next = node;
			tail = node;
		}
		tail.next = head;
	}

	static void print_values() {
		temp = head;
		if (temp != null) {
			do {
				System.out.println(temp.data);
				temp = temp.next;
			} while (temp != head);
		}

	}

	public static void main(String[] args) {
		// perform basic operations
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Enter options: 1-> insert 2> print 3-> exit ");
			int option = scan.nextInt();
			switch (option) {
			case 1:
				System.out.println("Enter the input");
				int val = scan.nextInt();
				insert_values(val);
				break;
			case 2:
				print_values();
				break;
			case 3:
				System.exit(0);
			}
		} while (true);
	}
}
