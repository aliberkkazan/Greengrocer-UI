package project;

public class TreeLinkedList {
	static LNode head;

	class LNode {
		String data;
		LNode next, prev;

		LNode(String d) {
			data = d;
			next = prev = null;
		}
	}

	class TNode {
		int data;
		TNode left, right;

		TNode(int d) {
			data = d;
			left = right = null;
		}
	}

	int countNodes(LNode head) {
		int count = 0;
		LNode temp = head;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}

	void push(String new_data) {
		LNode new_node = new LNode(new_data);

		new_node.prev = null;

		new_node.next = head;

		if (head != null)
			head.prev = new_node;

		head = new_node;
	}

	void printList(LNode node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	void preOrder(TNode node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	boolean isEmpty() {
		return countNodes(head) == 0;
	}
}