package Aufgabe2Diffie;

import java.math.BigInteger;

public class TestNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		generateN();
	}

	public static void generateG(){
		SmallIntegerG g = SmallIntegerG.create(BigInteger.valueOf(23000));
		for (int i = 0;i< 10;i++){
			System.out.println(g.next());			
		}
	}
	
	public static void generateN(){
		BigPrimeN n = BigPrimeN.create();
		for (int i = 0;i< 10;i++){
			System.out.println(n.next());			
		}
	}
	
	public static void genGN(){
		BigPrimeN n = BigPrimeN.create();
		SmallIntegerG g = SmallIntegerG.create(n.next());
		for (int i = 0;i< 10;i++){
			System.out.println(g.next());			
		}
	}
}
