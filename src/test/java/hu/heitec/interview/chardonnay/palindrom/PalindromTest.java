package hu.heitec.interview.chardonnay.palindrom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PalindromTest {

	private Palindrom undertest;

	@Test
	public void testForEmptyString() {
		Assertions.assertTrue(undertest.isPalindrom(""));
	}

	@ParameterizedTest
	@ValueSource(strings = {
		"abba",
		"beka!akeb",
		"][_(a(_[]",
		"aaaa!!aaaa",
	})
	public void testValidPalindroms(String input) {
		Assertions.assertTrue(undertest.isPalindrom(input));
	}

	@ParameterizedTest
	@ValueSource(strings = {
		"alma",
		"beka",
		"labda!adba",
		"][_.([])]_,",
	})
	public void testInvalidPalindroms(String input) {
		Assertions.assertFalse(undertest.isPalindrom(input));
	}

}