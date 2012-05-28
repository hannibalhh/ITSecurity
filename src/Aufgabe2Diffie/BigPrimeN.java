package Aufgabe2Diffie;

import java.math.BigInteger;
import java.util.Random;

public class BigPrimeN {

	private static final int standardBitLength = 1024;
	private final int bitLength;

	private BigPrimeN(int bitLength){
		this.bitLength = bitLength;
	}
	
	public static BigPrimeN create(int bitLength){
		return new BigPrimeN(bitLength);
	}
	public static BigPrimeN create(){
		return new BigPrimeN(standardBitLength);
	}
	
	public int bitLength(){
		return bitLength;
	}
	
	public BigInteger next(){
		return BigInteger.probablePrime(bitLength, new Random());
	}
}
