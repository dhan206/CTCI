package LinkedLists;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ArraysAndStrings.ArraysAndStrings;
import LinkedLists.LinkedLists.Node;

class LinkedListsTest {

	@Test
	void testRemoveDuplicates() {
		Node<Integer> current = new LinkedLists.Node(0);
		Node<Integer> head = current;
		for(int i = 0; i < 5; i++) {
			current.next = new Node(i);
			current = current.next;
			current.next = new Node(i);
			current = current.next;
		}
		Node<Integer> cloneOfHead = head.clone();
		
		assertEquals("[0]->[0]->[0]->[1]->[1]->[2]->[2]->[3]->[3]->[4]->[4]", 
				head.toString());
		head = LinkedLists.removeDuplicates(head);
		assertEquals("[0]->[1]->[2]->[3]->[4]", 
				head.toString());
		
		assertEquals("[0]->[0]->[0]->[1]->[1]->[2]->[2]->[3]->[3]->[4]->[4]", 
				cloneOfHead.toString());
		cloneOfHead = LinkedLists.removeDuplicatesFollowUp(cloneOfHead);
		assertEquals("[0]->[1]->[2]->[3]->[4]", 
				cloneOfHead.toString());
	}
}
