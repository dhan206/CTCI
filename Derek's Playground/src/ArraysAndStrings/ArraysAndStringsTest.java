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
	
	@Test void testCheckPermutation() {
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
}
