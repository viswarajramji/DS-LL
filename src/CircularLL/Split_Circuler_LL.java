package CircularLL;

import java.util.Scanner;

public class Split_Circuler_LL {

	static Node head = null;
	static Node tail = null;
	static Node head1 = null;
	static Node tail1 = null;
	static Node temp = null;
	static Node mid = null;

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

	static void print_values(Node head) {
		temp = head;
		if (temp != null) {
			do {
				System.out.println(temp.data);
				temp = temp.next;
			} while (temp != head);
		}

	}

	static boolean split(Node temp) {
		if (temp == null || temp == head) {
			mid = head;
			return false;
		}
		boolean flag = false;
		flag = split(temp.next);
		if (!flag && mid == temp) {
			temp = temp.next;
			mid.next = head;
			tail1 = mid;
			tail.next = temp;
			head1 = temp;
			flag = true;
		} else if (!flag && mid.next == temp) {
			mid.next = head;
			tail1 = mid;
			tail.next = temp;
			head1 = temp;
			flag = true;
		}
		if (flag)
			return flag;
		mid = mid.next;
		return flag;
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
				print_values(head);
				break;
			case 3:
				System.exit(0);
			case 4:
				split(head.next);
				System.out.println("first half");
				print_values(head);
				System.out.println("second half");
				print_values(head1);

			}
		} while (true);
	}

}
