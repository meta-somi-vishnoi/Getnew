package com.metacube.training;

public class SpellChecker {
	private String word;
	
	public SpellChecker(String word) {
		this.word = word;
	}

	public String getWord() {
		return word;
	}

	public void checkSpelling(String word) {
		System.out.println("checkSpelling " + getWord());
	}
}
