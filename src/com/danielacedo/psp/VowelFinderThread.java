package com.danielacedo.psp;

public class VowelFinderThread extends Thread{
	private char vowel;
	private String text;
	private VowelCounter.Codes code;
	private VowelCounter vowelCounter;
	
	public VowelFinderThread(char vowel, String text, VowelCounter.Codes code, VowelCounter vowelCounter) {
		this.vowel = vowel;
		this.text = text;
		this.code = code;
		this.vowelCounter = vowelCounter;
	}
	
	@Override
	public void run() {
		for(int i = 0; i<text.length(); i++){
			if(text.charAt(i) == vowel || text.charAt(i) == Character.toUpperCase(vowel)){
				this.vowelCounter.incrementVowel(code);
			}
		}
	}
}
