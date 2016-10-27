package com.danielacedo.psp;

public class VowelCounter{
	public enum Codes{
		a, e, i, o, u
	};
	
	private static final Object mutexCounter = new Object(); //Monitor for vowelCount
	
	private int vowelCount;
	private Integer aCount, eCount, iCount, oCount, uCount;
	private String textToSearch;
	
	public VowelCounter(String text){
		this.vowelCount = 0;
		this.aCount = 0;
		this.eCount = 0;
		this.iCount = 0;
		this.oCount = 0;
		this.uCount = 0;
		this.textToSearch = text;
	}
	
	public void startCounting(){
		//Create a thread for every letter we want to keep track of and start them
		VowelFinderThread finderThread_A = new VowelFinderThread('a', this.textToSearch, Codes.a, this);
		VowelFinderThread finderThread_E = new VowelFinderThread('e', this.textToSearch, Codes.e, this);
		VowelFinderThread finderThread_I = new VowelFinderThread('i', this.textToSearch, Codes.i, this);
		VowelFinderThread finderThread_O = new VowelFinderThread('o', this.textToSearch, Codes.o, this);
		VowelFinderThread finderThread_U = new VowelFinderThread('u', this.textToSearch, Codes.u, this);
		
		finderThread_A.start();
		finderThread_E.start();
		finderThread_I.start();
		finderThread_O.start();
		finderThread_U.start();
		
		//Wait for them to finish
		try{
			finderThread_A.join();
			finderThread_E.join();
			finderThread_I.join();
			finderThread_O.join();
			finderThread_U.join();
			
		}catch(InterruptedException e){
			System.err.println("Error concerning vowel counter thread interruption");
		}
		
		printValues();
		
	}
	
	public void printValues(){
		System.out.println("Text:");
		System.out.println(textToSearch);
		System.out.println("------");
		System.out.println("Values");
		System.out.println("========");
		System.out.println("a: "+aCount);
		System.out.println("e: "+eCount);
		System.out.println("i: "+iCount);
		System.out.println("o: "+oCount);
		System.out.println("u: "+uCount);
		System.out.println("\nTotal vowels: "+vowelCount);
		
	}
	
	public void incrementVowel(Codes code){
		switch (code){
			case a:
				synchronized (mutexCounter) {
					aCount++;
					vowelCount++;
				}
				break;
			case e:
				synchronized (mutexCounter) {
					eCount++;
					vowelCount++;
				}
				break;
			case i:
				synchronized (mutexCounter) {
					iCount++;
					vowelCount++;
				}
				break;
			case o:
				synchronized (mutexCounter) {
					oCount++;
					vowelCount++;
				}
				break;
			case u:
				synchronized (mutexCounter) {
					uCount++;
					vowelCount++;
				}
				break;
			default:
				break;
		}
	}
	
}
