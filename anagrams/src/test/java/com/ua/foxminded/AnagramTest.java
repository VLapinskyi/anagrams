package com.ua.foxminded;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnagramTest {

    private static final String EMPTY = "";
    private static final String ONLY_LETTERS = "abc";
    private static final String ONLY_LETTERS_REVERSED = "cba";
    private static final String ONLY_NUMBERS = "123456";
    private static final String ONLY_SYMBOLS = "!& :;'";
    private static final String LETTERS_AND_NUMBERS = "c1b2a3";
    private static final String LETTERS_AND_NUMBERS_REVERSED = "a1b2c3";
    private static final String LETTERS_AND_SYMBOLS = "et! s?; st";
    private static final String LETERRS_AND_SYMBOLS_REVERSED = "te! s?; ts";
    private static final String NUMBERS_AND_SYMBOLS = "12 $34! 56&";
    private static final String LETTERS_AND_NUMBERS_AND_SYMBOLS = "e1t$ #s?2 s89@?t";
    private static final String LETTERS_AND_NUMBERS_AND_SYMBOLS_REVERSED = "t1e$ #s?2 t89@?s";

    Anagram anagram;

    @BeforeEach
    void init() {
	anagram = new Anagram();
    }

    @Test
    void shouldThrowIllegalArgumentEcxeptionWhenDeliversNull() {
	assertThrows(NullPointerException.class, () -> anagram.reverseText(null),
		"This method should throws NullPointerException");
    }

    @Test
    void shouldReturnSameStringWhenPassedBlankText() {
	String actual = anagram.reverseText(EMPTY);
	assertEquals(EMPTY, actual, "This method should return blank text");
    }

    @Test
    void shouldReturnReversedStringWhenPassedLetters() {
	String actual = anagram.reverseText(ONLY_LETTERS);
	assertEquals(ONLY_LETTERS_REVERSED, actual,
		"This method should reverse a word, which containts only with letters");
    }

    @Test
    void shouldReturnSameStringWhenPassedNumbers() {
	String actual = anagram.reverseText(ONLY_NUMBERS);
	assertEquals(ONLY_NUMBERS, actual,
		"This method should return numbers in the same order in which they were passed into method");
    }

    @Test
    void shouldReturnSameStringWhenPassedSymbols() {
	String actual = anagram.reverseText(ONLY_SYMBOLS);
	assertEquals(ONLY_SYMBOLS, actual,
		"This method should return symbols in the same order in which they were passed into method");
    }

    @Test
    void shouldReturnPartiallyReversedStringWhenPassedLettersAndNumbers() {
	String actual = anagram.reverseText(LETTERS_AND_NUMBERS);
	assertEquals(LETTERS_AND_NUMBERS_REVERSED, actual,
		"The method should revers only letters, numbers should remain unchanged");
    }

    @Test
    void shouldReturnPartiallyReversedStringWhenPassedLettersAndSymbols() {
	String actual = anagram.reverseText(LETTERS_AND_SYMBOLS);
	assertEquals(LETERRS_AND_SYMBOLS_REVERSED, actual,
		"The method should revers only letters, symbols should remain unchanged");
    }

    @Test
    void shouldReturnSameStringWhenPassedNumbersAndSymbols() {
	String actual = anagram.reverseText(NUMBERS_AND_SYMBOLS);
	assertEquals(NUMBERS_AND_SYMBOLS, actual,
		"This method should return numbers and symbols in the same order in which they were passed into method");
    }

    @Test
    void shouldReturnPartiallyReversedStringWhenPassedLettersAndNumbersAndSymbols() {
	String actual = anagram.reverseText(LETTERS_AND_NUMBERS_AND_SYMBOLS_REVERSED);
	assertEquals(LETTERS_AND_NUMBERS_AND_SYMBOLS, actual,
		"The method should revers only letters, symbols and numbers should remain unchanged");
    }

}
