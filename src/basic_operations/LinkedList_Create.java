package basic_operations;

import java.util.Scanner;

public class LinkedList_Create {

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
	}

	static void print_values() {
		temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	static void delete_operations(int val) {
		boolean flag = false;
		temp = head;
		if (temp.data == val) {
			head = head.next;
			flag = true;
		} else {
			while (temp.next != null) {
				if (temp.next.data == val) {
					temp.next = temp.next.next;
					flag = true;
					break;
				}
				temp = temp.next;
			}
		}
		if (flag) {
			System.out.println("Number removed");
		} else {
			System.out.println("Number not found");
		}
	}

	public static void main(String[] args) {
		// perform basic operations
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Enter options: 1-> insert 2> print 3-> exit 4-> delete operations");
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
			case 4:
				System.out.println("Enter the values");
				val = scan.nextInt();
				delete_operations(val);
				break;
			}
		} while (true);
	}
}
