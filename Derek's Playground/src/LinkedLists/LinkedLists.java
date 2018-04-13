package LinkedLists;
import java.util.HashSet;

public class LinkedLists {
	
	// Node class for Linked List problems
	static class Node<AnyType> {
		public AnyType data;
		public Node<AnyType> next;
		
		public Node(AnyType data) {
			this.data = data;
			this.next = null;
		}
		
		public Node(AnyType data, Node<AnyType> next) {
			this.data = data;
			this.next = next;
		}
		
		// for testing and debugging
		public String toString() {
			StringBuffer buffer = new StringBuffer();
			Node<AnyType> curr = this;
			buffer.append("[" + curr.data + "]");
			while(curr.next != null) {
				curr = curr.next;
				buffer.append("->[" + curr.data + "]");
			}
			return buffer.toString();
		}
		
		// clone for testing purposes
		public Node<AnyType> clone() {
			Node<AnyType> curr = this;
			Node<AnyType> clone = new Node<AnyType>(curr.data);
			Node<AnyType> headOfClone = clone;
			while(curr.next != null) {
				curr = curr.next;
				clone.next = new Node<AnyType>(curr.data);
				clone = clone.next;
			}
			return headOfClone;
		}
	}
	
	public static void main(String[] args) {
		
	}
	
	// #2.1
	// Question: Write code to remove duplicates from an unsorted linked list.
	// Assumption: Data in the nodes are integers. The passed parameter is a
	//		reference to the Node that is the head of the linked list.
	// Time complexity: O(n) because must iterate through entire linked list
	// Space complexity: O(n) because must keep a HashSet of visited/seen data values
	public static Node<Integer> removeDuplicates(Node head) {
		HashSet<Integer> set = new HashSet<Integer>();
		Node<Integer> current = head;
		Node<Integer> previous = null;
		while(current != null) {
			if(set.contains(current.data)) {
				previous.next = current.next;
			} else {
				set.add(current.data);
				previous = current;
			}
			current = current.next;
		}
		return head;
	}
	
	// # 2.1.FOLLOW UP
	// Question: Same problem as question above but with the following constraint:
	//			How would you solve this problem if a temporary buffer is not allowed
	// Assumption: Same assumptions as above. Temporary buffer means arrays, other data
	//			structures. To satisfy the constraint the space complexity must be constant.
	// Time complexity: O(n^2) I think, see: http://jwilson.coe.uga.edu/EMAT6680Fa2013/Hendricks/Essay%202/Essay2.html
	// Space complexity: O(1)
	public static Node<Integer> removeDuplicatesFollowUp(Node<Integer> head) {
		Node<Integer> currentOutside = head;
		while(currentOutside != null) {
			Node<Integer> previousInside = currentOutside;
			Node<Integer> currentInside = currentOutside.next;
			while(currentInside != null) {
				if (currentOutside.data == currentInside.data) {
					previousInside.next = currentInside.next;
				} else {
					previousInside = currentInside;
				}
				currentInside = currentInside.next;
			}
			currentOutside = currentOutside.next;
		}
		return head;
	}
	
	// #2.2
	// Question: Implement an algorithm to find the kth to last element of a singly linked list
	// Assumption: Since it is a singly linked list, we can only go forward (.next), 
	//				"1st to last" is the last element, values in linked list are char
	// Time complexity: O(n) runner must traverse through entire linked list once
	// Space complexity: O(1) always two 'pointers', runner and finder
	public static char returnKthToLast(Node<Character> head, int k) {
		Node<Character> runner = head;
		Node<Character> finder = head;
		for(int i = 0; i < k; i++) {
			if (runner == null) {
				return '\u0000'; // empty null character
			}
			runner = runner.next;
		}
		while (runner != null) {
			runner = runner.next;
			finder = finder.next;
		}
		return finder.data;
	}
	
	// #2.3
	// Question: Implement an algorithm to delete a node in the middle (ie, any node but the first and
	//			last, not necessarily the exact middle) of a singly linked list, given only access to
	//			to that node.
	// Assumption:
	//				NOTE: I do not modify, store or use head in any way besides returning 
	//				it to show the final results.
	// Time complexity: O(1)
	// Space complexity: O(1)
	public static Node<Character> removeFromMiddle(Node<Character> head, Node<Character> middle) {
		if (middle != null && middle.next != null) {
			// set everything to next node, basically skipping over the middle
			middle.data = middle.next.data;
			middle.next = middle.next.next;
		}
		return head;
	}
	
//	// #
//	// Question:
//	// Assumption:
//	// Time complexity:
//	// Space complexity:
//	public static
}
