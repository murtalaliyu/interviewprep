package test;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class Questions {

	/**
	 * T.Rowe Price
	 * Return the longest word & wordLength from sentence.
	 * 
	 * @param sentence
	 * @return Map<word, wordLength>
	 */
	private String word = "";
	private Integer wordLength = 0;
	public Map<String, Integer> longestWord(String sentence) {
		// base case
		if (sentence.length() == 0) {
			return null;
		}
		
		String[] splits = sentence.split(" ");
		word = splits[0];
		wordLength = word.length();
		
		for (int i = 0; i < splits.length; i++) {
			String currentWord = splits[i];
			if (currentWord.length() > word.length()) {
				word = currentWord;
				wordLength = word.length();
			}
		}
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put(word, wordLength);
		return map;
	}
}
