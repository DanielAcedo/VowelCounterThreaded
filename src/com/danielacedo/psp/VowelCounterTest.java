package com.danielacedo.psp;

public class VowelCounterTest {
	

	public static void main(String[] args) {
		VowelCounter vowelCounter = new VowelCounter("ou should use enum types any time you need to represent a fixed set of constants. That includes natural enum types such as the planets in our solar system and data sets where you know all possible values at compile time—for example, the choices on a menu, command line flags, and so on.");
		vowelCounter.startCounting();
	}

}
