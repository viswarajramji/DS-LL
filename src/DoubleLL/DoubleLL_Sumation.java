package DoubleLL;

import java.util.Scanner;

public class DoubleLL_Sumation {

	static Node head = null;
	static Node tail = null;
	static Node temp = null;

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

	}

	static void insert_values(int val) {
		Node node = new Node(val);
		if (head == null) {
			tail = head = node;
		} else {
			tail.right = node;
			node.left = tail;
			tail = node;
		}

	}

	static void print_values_left() {
		temp = head;
		System.out.println("Print values left to right");
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.right;
		}
	}

	static void print_values_right_to_left() {
		temp = tail;
		System.out.println("Print values right to left ");
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.left;
		}
	}

	static void find_triplets() {
		int sum = 0;
		int cnt = 0;
		temp=head;
		while (temp != null && cnt < 3) {
			sum += temp.data;
			temp = temp.right;
			cnt++;
		}
		int max_sum = sum;
		Node pointer = head;
		while (temp != null) {
			sum += temp.data - (pointer.data);
			temp = temp.right;
			pointer = pointer.right;
			if (max_sum < sum) {
				max_sum = sum;
			}
		}
		System.out.println("the max sum value is "+max_sum);

	}

	public static void main(String[] args) {
		// perform basic operations
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Enter options: 1-> insert 2-> print values 3-> Max triplets exit ");
			int option = scan.nextInt();
			switch (option) {
			case 1:
				System.out.println("Enter the input");
				int val = scan.nextInt();
				insert_values(val);
				break;
			case 2:
				print_values_left();
				print_values_right_to_left();
				break;

			case 3:
				find_triplets();
				break;
			case 100:
				System.exit(0);
			}
		} while (true);
	}
}
