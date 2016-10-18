package com.danielacedo.psp;

public class VowelCounter{
	public enum Codes{
		a, e, i, o, u
	};
	
	public int vowelCount;
	public Integer aCount, eCount, iCount, oCount, uCount;
	public String textToSearch;
	
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
		
		try{
			finderThread_A.join();
			finderThread_E.join();
			finderThread_I.join();
			finderThread_O.join();
			finderThread_U.join();
			
		}catch(InterruptedException e){
			
		}
		
		printValues();
		
	}
	
	public void printValues(){
		System.out.println("Texto:");
		System.out.println(textToSearch);
		System.out.println("------");
		System.out.println("Valores");
		System.out.println("========");
		System.out.println("a: "+aCount);
		System.out.println("e: "+eCount);
		System.out.println("i: "+iCount);
		System.out.println("o: "+oCount);
		System.out.println("u: "+uCount);
		System.out.println("Total: "+vowelCount);
		
	}
	
	public synchronized void incrementVowel(Codes code){
		switch (code){
			case a:
				aCount++;
				vowelCount++;
				break;
			case e:
				eCount++;
				vowelCount++;
				break;
			case i:
				iCount++;
				vowelCount++;
				break;
			case o:
				oCount++;
				vowelCount++;
				break;
			case u:
				uCount++;
				vowelCount++;
				break;
			default:
				break;
		}
	}
	
}
