package ArraysAndStrings;
import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.Test;

class ArraysAndStringsTest {

	@Test
	void testIsUnique() {
		assertTrue(ArraysAndStrings.IsUnique("abcdegf"));
		assertFalse(ArraysAndStrings.IsUnique("abcdega"));
	}
	
	@Test 
	void testCheckPermutation() {
		assertTrue(ArraysAndStrings.CheckPermutation("APPLE", "APPLE"));
		assertTrue(ArraysAndStrings.CheckPermutation("APPLE", "ELPPA"));
		assertTrue(ArraysAndStrings.CheckPermutation("APPLE", "ALPPE"));
		assertTrue(ArraysAndStrings.CheckPermutation("APPLE", "PPLEA"));
		assertTrue(ArraysAndStrings.CheckPermutation("APPLE", "APLEP"));
		assertTrue(ArraysAndStrings.CheckPermutation("APPLE", "PLPEA"));
		
		assertFalse(ArraysAndStrings.CheckPermutation("APPLE", ""));
		assertFalse(ArraysAndStrings.CheckPermutation("APPLE", "APPLA"));
		assertFalse(ArraysAndStrings.CheckPermutation("APPLE", "APLE"));
		assertFalse(ArraysAndStrings.CheckPermutation("APPLE", "AAAAA"));
		assertFalse(ArraysAndStrings.CheckPermutation("APPLE", "APPLE "));
	}
	
	@Test
	void testURLify() {
		assertEquals("Mr%20John%20Smith", ArraysAndStrings.URLify(("Mr John Smith    ").toCharArray(), 13));
		assertEquals("Mr%20John%20Smith%20", ArraysAndStrings.URLify(("Mr John Smith       ").toCharArray(), 14));
		assertEquals("Facebook%20Is%20Selling%20Your%20Information%20To%20The%20Government", ArraysAndStrings.URLify(("Facebook Is Selling Your Information To The Government              ").toCharArray(), 54));
		
		assertNotEquals("Mr%20John%20Smith%20", ArraysAndStrings.URLify(("Mr John Smith    ").toCharArray(), 13));
	}
	
	@Test
	void testIsPalindromePermutation() {
		assertTrue(ArraysAndStrings.IsPalindromePermutation("racecar"));
		assertTrue(ArraysAndStrings.IsPalindromePermutation("Tact Coa"));
		assertTrue(ArraysAndStrings.IsPalindromePermutation("Tact Ca"));
		assertTrue(ArraysAndStrings.IsPalindromePermutation("Tact CoaO"));
		assertFalse(ArraysAndStrings.IsPalindromePermutation("Tact Coae"));
		assertFalse(ArraysAndStrings.IsPalindromePermutation("racecars"));
	}
	
	@Test
	void testOneAway() {
		assertTrue(ArraysAndStrings.OneAway("pale", "ple"));
		assertTrue(ArraysAndStrings.OneAway("pales", "pale"));
		assertTrue(ArraysAndStrings.OneAway("pale", "bale"));
		assertFalse(ArraysAndStrings.OneAway("pale", "bake"));
		assertFalse(ArraysAndStrings.OneAway("pool", "polo"));
		assertFalse(ArraysAndStrings.OneAway("pool", "polls"));
	}
	
	@Test
	void testStringCompression() {
		assertEquals("a2b1c5a3", ArraysAndStrings.StringCompression("aabcccccaaa"));
		assertEquals("a1A1b1c5a3", ArraysAndStrings.StringCompression("aAbcccccaaa"));
		assertEquals("abcdefghijk", ArraysAndStrings.StringCompression("abcdefghijk"));		
	}
}
