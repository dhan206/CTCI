package ArraysAndStrings;
import java.util.*;

// Page 90
public class ArraysAndStrings {
	public static void main(String[] args) {
		// #1.1 IsUnique
//		System.out.println("[IsUnique] Expected TRUE: " + IsUnique("abcde"));
//		System.out.println("[IsUnique] Expected FALSE: " + IsUnique("abcda"));
		
		// #1.2 CheckPermutation
//		System.out.println("[CheckPermutation] Expected TRUE: " + CheckPermutation("APPLE", "EPLPA"));
//		System.out.println("[CheckPermutation] Expected FALSE: " + CheckPermutation("APPLE", "EPLPE"));
		
		// #1.3 URLify
//		System.out.println("[URLify] input: \'Mr John Smith    \', output: " + URLify(("Mr John Smith    ").toCharArray(), 13));
		
		// #1.4 IsPalindromePermutation
//		System.out.println("[IsPalindromePermutation] Expected TRUE: " + IsPalindromePermutation("Tact Coa"));
//		System.out.println("[IsPalindromePermutation] Expected TRUE: " + IsPalindromePermutation("Tact Ca"));
//		System.out.println("[IsPalindromePermutation] Expected TRUE: " + IsPalindromePermutation("Tact CoaO"));
//		System.out.println("[IsPalindromePermutation] Expected FALSE: " + IsPalindromePermutation("Tact Coae"));
		
	}
	
	// #1.1
	// Question: Implement an algorithm to determine if a string has all unique characters.
	// Assumption: All characters are in ASCII
	// Time complexity: O(n) where n is length of string
	// Space complexity: O(1), will always require a boolean array length 128
	public static boolean IsUnique(String s) {
		boolean[] char_set = new boolean[128]; // 128 because ASCII values range from 0 - 127
	
		for (int i = 0; i < s.length(); i++) {
			int char_val = s.charAt(i);
			if (char_set[char_val]) { // if the value has been set, it isn't unique
				return false;
			}
			char_set[char_val] = true;
		}
		
		return true;
	}
	
	// #1.2
	// Question: Given two strings, write a method to decide if one is a permutation of the other.
	// Assumption: Two strings are permutation of each other if 1) are the same length, 2) have the same letters
	// Time complexity: O(n), because it must loop over s1 and s2 each once... O(n + n) ==> O(n)
	// Space complexity: O(n) because it must store s1 into an ArrayList for comparison
	public static boolean CheckPermutation(String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		
		HashMap<Character, Integer> char_map = new HashMap<Character, Integer>();
		for (char c : s1.toCharArray()) { // puts s1 into a character array
			char_map.merge(c, 1, Integer::sum); // initiates to 1 if key does not exist, increments by 1 if key exists
		}
		
		for (int i = 0; i < s2.length(); i++) { // loops over s2 and removes characters from s1
			char currChar = s2.charAt(i);
			if (!char_map.containsKey(currChar) || char_map.get(currChar) == 0) return false;
			char_map.put(currChar, char_map.get(currChar) - 1);
		}
		
		return true;
	}
	
	// #1.3
	// Question: Write a method to replace all spaces in a string with '%20'. You may assume that the string 
	//		has sufficient space at the end to hold the additional characters, and that you are given the 
	//		"true" length of the string. (Note: if implementing in Java, please use a character array so 
	//		that you can perform this operation in place.)
	// Assumption: 
	// Time complexity: O(n), loop through string twice, first time to get spaces and 
	//		second time to build the URL string
	// Space complexity: O(1) (i think?) because the operation is performed in-place, 
	//		no other data structures are used
	public static String URLify(char[] s, int length) {
		int numSpaces = 0;
		for (int i = 0; i < length; i++) {
			if (s[i] == ' ') {
				numSpaces++;
			}
		}
		
		int newLength = length - numSpaces + (numSpaces * 3);
		for (int i = length - 1; i >= 0; i--) {
			if (s[i] == ' ') {
				s[newLength - 1] = '0';
				s[newLength - 2] = '2';
				s[newLength - 3] = '%';
				newLength -= 3;
			} else {
				s[newLength - 1] = s[i];
				newLength -= 1;
			}
		}
		
		return new String(s);
	}

	// #1.4
	// Question: Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is
	//		a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters.
	//		the palindrome does not need to be limited to just dictionary words.
	// Assumption: All characters in string are ASCII. Palindrome letters come in pairs unless there is an odd amount
	//		of letters in the string. Case-insensitive.
	// Time complexity: O(n) where n is length of the string because it is looped over once 
	//		to collect the character counts
	// Space complexity: O(1) because only need an int array of size 128 each time
	public static boolean IsPalindromePermutation(String s) {
		int[] characterCount = new int[128]; // to store 0 - 127 ASCII codes
		int stringLengthWithoutSpaces = 0;
		s = s.toLowerCase();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				int char_val = s.charAt(i);
				characterCount[char_val]++;
				stringLengthWithoutSpaces++;
			}
		}
		
		// odd character palindromes are allowed 1 odd count letter
		boolean oneOddAllowed = (stringLengthWithoutSpaces % 2 == 1); 
		
		for (int count : characterCount) {
			if (count % 2 != 0) {
				if (oneOddAllowed) {
					oneOddAllowed = !oneOddAllowed; // toggle when allowed odd is found
				} else {
					return false;
				}
			}
		}
		return true;
	}
	
//	// #
//	// Question:
//	// Assumption:
//	// Time complexity:
//	// Space complexity:
//	public static
}
