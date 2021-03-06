package basic_operations;

import java.util.Scanner;

import basic_operations.LinkedList_Search.Node;

public class MiddleElement {
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

	static int find_length_rec(Node temp) {
		if (temp == null)
			return 0;
		return 1 + find_length_rec(temp.next);
	}

	static int find_values_index(int val, Node temp, int index) {
		if (temp == null)
			return -1;
		if (temp.data == val)
			return index;
		return find_values_index(val, temp.next, index + 1);
	}

	static void compute_mid_element() {
		Node temp1 = head;
		Node temp2 = head;
		while (temp2 != null && temp2.next != null) {
			temp1 = temp1.next;
			temp2 = temp2.next.next;
		}
		System.out.println(temp1.data);
	}

	public static void main(String[] args) {
		// perform basic operations
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Enter options: 1-> insert 2> print  3-> middle  100-> exit");
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
			case 100:
				System.exit(0);
			case 3:
				compute_mid_element();
			}
		} while (true);
	}
}
