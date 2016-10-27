package com.danielacedo.psp;

public class VowelCounterTest {
	

	public static void main(String[] args) {
		if(args.length==0){
			System.err.println("You haven't entered any parameter. Please enter one phrase between quotation marks to begin. (Example \"Test parameter\")");
		}else{
			VowelCounter vowelCounter = new VowelCounter(args[0]);
			vowelCounter.startCounting();
		}
	}

}
