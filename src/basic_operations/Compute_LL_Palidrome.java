package basic_operations;

public class Compute_LL_Palidrome {
	Node head; // head of list
	Node left;

	/* Linked list Node */
	class Node {
		char data;
		Node next;

		Node(char d) {
			data = d;
			next = null;
		}
	}

	boolean compute_isPalindrome(Node right) {
		left = head;
		if (right == null) {
			return true;
		}
		boolean flag = compute_isPalindrome(right.next);
		if (!flag || left.data != right.data)
			return false;
		left = left.next;
		return true;
	}

	boolean isPalindrome(Node node) {
		return compute_isPalindrome(head);
	}

	void printList(Node ptr) {
		while (ptr != null) {
			System.out.print(ptr.data + "->");
			ptr = ptr.next;
		}
		System.out.println("NULL");
	}

	public void push(char new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	public static void main(String[] args) {
		/* Start with the empty list */
		Compute_LL_Palidrome llist = new Compute_LL_Palidrome();
		char str[] = { 'a', 'b', 'a', 'c', 'a', 'b', 'a' };
		final String string = new String(str);
		for (int i = 0; i < 7; i++) {
			llist.push(str[i]);
			llist.printList(llist.head);
			if (llist.isPalindrome(llist.head) != false) {
				System.out.println("Is Palindrome");
				System.out.println("");
			} else {
				System.out.println("Not Palindrome");
				System.out.println("");
			}
		}
	}
}
