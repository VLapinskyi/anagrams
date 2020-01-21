package com.ua.foxminded;

import static java.lang.Character.isAlphabetic;

import java.util.StringJoiner;

public class Anagram {
    private static final String WHITE_SPACE = " ";

    public String reverseText(String source) {
	String[] words = source.split(WHITE_SPACE);
	String[] reversedTextArray = new String[words.length];
	for (int i = 0; i < reversedTextArray.length; i++) {
	    reversedTextArray[i] = reverseWord(words[i]);
	}
	StringJoiner resultText = new StringJoiner(WHITE_SPACE);
	for (int i = 0; i < reversedTextArray.length; i++) {
	    resultText.add(reversedTextArray[i]);
	}
	return resultText.toString();
    }

    private String reverseWord(String word) {
	char[] toArrayWord = word.toCharArray();
	int startPoint = 0;
	int endPoint = toArrayWord.length - 1;

	while (startPoint < endPoint) {
	    if (!isAlphabetic(toArrayWord[startPoint])) {
		startPoint++;
	    } else if (!isAlphabetic(toArrayWord[endPoint])) {
		endPoint--;
	    } else {
		toArrayWord = changeLetters(startPoint, endPoint, toArrayWord);
		startPoint++;
		endPoint--;
	    }
	}
	StringBuilder resultWord = new StringBuilder();
	for (int i = 0; i < toArrayWord.length; i++) {
	    resultWord.append(toArrayWord[i]);
	}
	return resultWord.toString();
    }

    private char[] changeLetters(int startPoint, int endPoint, char[] toArrayWord) {
	char[] resultArray = toArrayWord;
	char temp = resultArray[startPoint];
	resultArray[startPoint] = resultArray[endPoint];
	resultArray[endPoint] = temp;
	return resultArray;
    }
}
