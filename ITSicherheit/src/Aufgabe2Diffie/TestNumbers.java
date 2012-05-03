package Aufgabe2Diffie;

import java.math.BigInteger;

public class TestNumbers {

	public static void main(String[] args) {
		// generateN();
		modPowTest();
	}

	public static void squareAndMultiplyMod(BigInteger base, BigInteger exp,BigInteger mod) {
		BigInteger biggi = MathUtil.squareAndMultiply(base,exp).mod(mod);
		System.out.println(biggi);
	}

	public static void modPowTestEasy(){
		BigInteger base = BigInteger.valueOf(2);
	    BigInteger exp = BigInteger.valueOf(7);
		BigInteger mod = BigInteger.valueOf(5);
		System.out.println("standardimpl: " + base.modPow(exp, mod));
		squareAndMultiplyMod(base,exp,mod);			
	}
	
	public static void modPowTest(){
		BigInteger base = BigInteger.valueOf(2);
	    BigInteger exp = BigInteger.valueOf(7);
		BigInteger mod = BigInteger.valueOf(5);
		System.out.println("standardimpl: " + base.modPow(exp, mod));
		System.out.println(MathUtil.modPow(base, exp, mod));		
	}
	
	public static void squareAndMultiply(BigInteger base, BigInteger exp) {
		BigInteger biggi = MathUtil.squareAndMultiply(base,exp);
		System.out.println(biggi);
	}

	public static void powTest(){
		BigInteger base = BigInteger.valueOf(2);
	    BigInteger exp = BigInteger.valueOf(7);
		System.out.println("standardimpl: " + base.pow(exp.intValue()));
		squareAndMultiply(base,exp);			
	}

	public static void generateG() {
		SmallInteger g = SmallInteger.create(BigInteger.valueOf(23000));
		for (int i = 0; i < 10; i++) {
			System.out.println(g.next());
		}
	}

	public static void generateN() {
		BigPrimeN n = BigPrimeN.create();
		System.out.println(n.next().bitLength());

		for (int i = 0; i < 10; i++) {
			System.out.println(n.next());
		}
	}

	public static void genGN() {
		BigPrimeN n = BigPrimeN.create();
		SmallInteger g = SmallInteger.create(n.next());
		for (int i = 0; i < 10; i++) {
			System.out.println(g.next());
		}
	}
}
