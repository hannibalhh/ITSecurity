package Aufgabe2Diffie;

import java.math.BigInteger;

public class TestNumbers {

	public static void main(String[] args) {
		//generateN();
		BigInteger biggi=MathUtil.squareAndMultiply(BigInteger.valueOf(2),BigInteger.valueOf(26) );
		System.out.println(biggi);
	}

	public static void generateG(){
		SmallInteger g = SmallInteger.create(BigInteger.valueOf(23000));
		for (int i = 0;i< 10;i++){
			System.out.println(g.next());			
		}
	}
	
	public static void generateN(){
		BigPrimeN n = BigPrimeN.create();
		System.out.println(n.next().bitLength());

		for (int i = 0;i< 10;i++){
			System.out.println(n.next());			
		}
	}
	
	public static void genGN(){
		BigPrimeN n = BigPrimeN.create();
		SmallInteger g = SmallInteger.create(n.next());
		for (int i = 0;i< 10;i++){
			System.out.println(g.next());			
		}
	}
}
