package hu.heitec.interview.malbec.roman;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ArabicToRomanConverterTest {

	private ArabicToRomanConverter undertest = new ArabicToRomanConverter();

	@ParameterizedTest
	@ValueSource(ints = {0, 4000})
	public void testBounds(int number) throws Exception {
		assertThrows(IllegalArgumentException.class, () -> undertest.convertToRoman(number));
	}

	@ParameterizedTest
	@MethodSource("provideRomanNumerals")
	public void testForRomanNumerals(int number, char[] expected) {
		assertArrayEquals(expected, undertest.convertToRoman(number));
	}

	@ParameterizedTest
	@MethodSource("provideSimpleNumbers")
	public void testForSimpleNumbers(int number, char[] expected) {
		assertArrayEquals(expected, undertest.convertToRoman(number));
	}

	@ParameterizedTest
	@MethodSource("provideComplexNumbers")
	public void testForComplexNumbers(int number, char[] expected) {
		assertArrayEquals(expected, undertest.convertToRoman(number));
	}

	private static Stream<Arguments> provideRomanNumerals() {
		return Stream.of(
			Arguments.of(1, new char[] {'I'}),
			Arguments.of(5, new char[] {'V'}),
			Arguments.of(10, new char[] {'X'}),
			Arguments.of(50, new char[] {'L'}),
			Arguments.of(100, new char[] {'C'}),
			Arguments.of(500, new char[] {'D'}),
			Arguments.of(1000, new char[] {'M'})
		);
	}

	private static Stream<Arguments> provideSimpleNumbers() {
		return Stream.of(
			Arguments.of(1101, new char[] {'M', 'C', 'I'}),
			Arguments.of(3333, new char[] {'M', 'M', 'M', 'C', 'C', 'C', 'X', 'X', 'X', 'I', 'I', 'I'}),
			Arguments.of(2206, new char[] {'M', 'M', 'C', 'C', 'V', 'I'}),
			Arguments.of(1560, new char[] {'M', 'D', 'L', 'X'})
		);
	}

	private static Stream<Arguments> provideComplexNumbers() {
		return Stream.of(
			Arguments.of(3999, new char[] {'M', 'M', 'M', 'C', 'M', 'X', 'C', 'I', 'X'}),
			Arguments.of(2491, new char[] {'M', 'M', 'C', 'D', 'X', 'C', 'I'}),
			Arguments.of(1843, new char[] {'M', 'D', 'C', 'C', 'C', 'X', 'L', 'I', 'I', 'I'}),
			Arguments.of(3434, new char[] {'M', 'M', 'M', 'C', 'D', 'X', 'X', 'X', 'I', 'V'})
		);
	}

}