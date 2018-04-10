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
		while(current.next != null) {
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
	public static Node<Integer> removeDuplicatesFollowUp(Node head) {
		Node<Integer> currentOutside = head;
		while(currentOutside.next != null) {
			Node<Integer> previousInside = currentOutside;
			Node<Integer> currentInside = currentOutside.next;
			while(currentInside.next != null) {
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
	
//	// #
//	// Question:
//	// Assumption:
//	// Time complexity:
//	// Space complexity:
//	public static
}
