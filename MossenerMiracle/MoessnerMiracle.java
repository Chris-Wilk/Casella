/**
 * MoessnerMiracle is a Java program that demonstrates the Moessner Miracle using a linked list of integers.
 * It calculates and prints the first ten positive integers, first ten squares, first ten positive cubes,
 * and first ten fourth and fifth powers using the Moessner Miracle method.
 * @author Chris Wilk
 * @date: 1 November 2023
 * @assignment CIS 203, Assignment 09, Fall 2023
 */

public class MoessnerMiracle {
	private intNode head;

	/**
	 * A node class for the linked list.
	 */
	private class intNode {
		private int data;
		private intNode next;

		public intNode(int inData) {
			this.data = inData;
			this.next = null;
		}
	}

	/**
	 * Append a value to the end of the linked list.
	 * 
	 * @param value The value to be appended.
	 */
	private void append(int val) {
		if (head == null) {
			head = new intNode(val);
		} else {
			appendRecursive(head, val);
		}
	}

	private void appendRecursive(intNode current, int value) {
		if (current.next == null) {
			current.next = new intNode(value);
		} else {
			appendRecursive(current.next, value);
		}
	}

	/**
	 * Generate a string representation of the linked list.
	 * 
	 * @return A string containing the contents of the linked list.
	 */
	public String toString() {
		return toStringRecursive(head);
	}

	private String toStringRecursive(intNode current) {
		if (current == null) {
			return "";
		} else {
			return current.data + " " + toStringRecursive(current.next);
		}
	}

	/**
	 * Fill the linked list with the first n positive integers.
	 * 
	 * @param n The number of nodes to fill with positive integers.
	 */
	private void fillWithInts(int n) {
		fillWithIntsRecursive(1, n);
	}

	private void fillWithIntsRecursive(int value, int count) {
		if (count > 0) {
			append(value);
			fillWithIntsRecursive(value + 1, count - 1);
		}
	}

	/**
	 * Remove every kth node from the linked list.
	 * 
	 * @param k The interval at which nodes should be removed.
	 */
	private void removeKth(int k) {
		if (k <= 1 || head == null) {
			return;
		}
		head = removeKthRecursive(head, k, k);
	}

	private intNode removeKthRecursive(intNode current, int k, int count) {
		if (current == null) {
			return null;
		}
		if (count == 1) {
			return removeKthRecursive(current.next, k, k);
		}
		current.next = removeKthRecursive(current.next, k, count - 1);
		return current;
	}

	/**
	 * Replace each value in the linked list with the sum of its contents and all
	 * nodes that came before it.
	 */
	private void sumToNodes() {
		head = sumToNodesRecursive(head, 0);
	}

	private intNode sumToNodesRecursive(intNode current, int sum) {
		if (current == null) {
			return null;
		}
		int value = current.data;
		current.data += sum;
		current.next = sumToNodesRecursive(current.next, value + sum);
		return current;
	}

	/**
	 * Perform the Moessner Miracle for a given power and print the results.
	 * 
	 * @param power The power to which integers are raised.
	 */

	public static void miracle(int power) {
		MoessnerMiracle list = new MoessnerMiracle();
		list.fillWithInts(20);

		miracleRecursive(list, power);
	}

	private static void miracleRecursive(MoessnerMiracle list, int power) {
		if (power == 0) {

		} else {
			list.removeKth(power);
			list.sumToNodes();
			System.out.println("First ten positive integers to the power of " + power + ":");
			System.out.println(list);

			miracleRecursive(list, power - 1);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		System.out.println("The Moessner Miracle Program");
		System.out.println();

		System.out.println("Squares (power = 2):");
		miracle(2);

		System.out.println("Cubes (power = 3):");
		miracle(3);

		System.out.println("Fourth powers (power = 4):");
		miracle(4);

		System.out.println("Fifth powers (power = 5):");
		miracle(5);
	}
}
