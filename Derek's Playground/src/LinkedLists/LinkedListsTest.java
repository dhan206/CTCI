package LinkedLists;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ArraysAndStrings.ArraysAndStrings;
import LinkedLists.LinkedLists.Node;

class LinkedListsTest {

	@Test
	void testRemoveDuplicates() {
		Node<Integer> current = new LinkedLists.Node<Integer>(0);
		Node<Integer> head = current;
		for(int i = 0; i < 5; i++) {
			current.next = new Node<Integer>(i);
			current = current.next;
			current.next = new Node<Integer>(i);
			current = current.next;
		}
		Node<Integer> cloneOfHead = head.clone();
		
		assertEquals("[0]->[0]->[0]->[1]->[1]->[2]->[2]->[3]->[3]->[4]->[4]", 
				head.toString());
		head = LinkedLists.removeDuplicates(head);
		assertEquals("[0]->[1]->[2]->[3]->[4]", head.toString());
		
		assertEquals("[0]->[0]->[0]->[1]->[1]->[2]->[2]->[3]->[3]->[4]->[4]", 
				cloneOfHead.toString());
		cloneOfHead = LinkedLists.removeDuplicatesFollowUp(cloneOfHead);
		assertEquals("[0]->[1]->[2]->[3]->[4]", cloneOfHead.toString());
	}
	
	@Test
	void testReturnKthToLast() {
		Node<Character> current = new LinkedLists.Node<Character>('A');
		Node<Character> head = current;
		current.next = new LinkedLists.Node<Character>('B');
		current.next.next = new LinkedLists.Node<Character>('C');
		current.next.next.next = new LinkedLists.Node<Character>('D');
		current.next.next.next.next = new LinkedLists.Node<Character>('E');

		assertEquals("[A]->[B]->[C]->[D]->[E]", head.toString());
		assertEquals('A', LinkedLists.returnKthToLast(head, 5));
		assertEquals('B', LinkedLists.returnKthToLast(head, 4));
		assertEquals('C', LinkedLists.returnKthToLast(head, 3));
		assertEquals('D', LinkedLists.returnKthToLast(head, 2));
		assertEquals('E', LinkedLists.returnKthToLast(head, 1));
		assertEquals('\u0000', LinkedLists.returnKthToLast(head, 6));
	}
	
	@Test
	void tesRemoveFromMiddle() {
		Node<Character> current = new LinkedLists.Node<Character>('A');
		Node<Character> head = current;
		current.next = new LinkedLists.Node<Character>('B');
		Node<Character> middle = new LinkedLists.Node<Character>('C');
		current.next.next = middle;
		current.next.next.next = new LinkedLists.Node<Character>('D');
		current.next.next.next.next = new LinkedLists.Node<Character>('E');
		
		assertEquals("[A]->[B]->[C]->[D]->[E]", head.toString());
		head = LinkedLists.removeFromMiddle(head, middle);
		assertEquals("[A]->[B]->[D]->[E]", head.toString());
	}
}
