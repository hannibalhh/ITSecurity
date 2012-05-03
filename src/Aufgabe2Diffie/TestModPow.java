package Aufgabe2Diffie;

import java.math.BigInteger;

public class TestModPow {

	public static void main(String[] args) {
		// generateN();
		modPowTest();
	}



	public static void squareAndMultiplayDemonstrate(){
		BigInteger base=BigInteger.valueOf(2);
		//
		for(int i=1; i<=23; i++){
		BigInteger exp=BigInteger.valueOf(i);
		BigInteger biggi = MathUtil.squareAndMultiply(base ,exp);
		System.out.println("2 ^ "+i+"="+biggi);
		}
	}

	

	public static void squareAndMultiplyMod(BigInteger base, BigInteger exp,BigInteger mod) {
		BigInteger biggi = MathUtil.squareAndMultiply(base,exp).mod(mod);
		System.out.println(biggi);
	}

	public static void modPowTestEasy(){
		BigInteger base = BigInteger.valueOf(2);
	    BigInteger exp = BigInteger.valueOf(7);
		BigInteger mod = BigInteger.valueOf(5) ;
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
}
