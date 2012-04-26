package Aufgabe2Diffie;

import java.math.BigInteger;
import java.util.Random;

public class SmallInteger {
	
	private final BigInteger n;
	
	private SmallInteger(BigInteger n){
		this.n = n;
	}
	
	public static SmallInteger create(BigInteger n){
		return new SmallInteger(n);
	}
	
	public BigInteger n(){
		return n;
	}

	// {2,..,n-2}
	BigInteger next(){
		return rand(BigInteger.valueOf(2),n.subtract(BigInteger.valueOf(2)));
	}
	
	public BigInteger rand(BigInteger up,BigInteger to) {
		to = to.subtract(BigInteger.valueOf(2));
	    Random rand = new Random();
	    BigInteger result = new BigInteger(n.bitLength(), rand);   
	    result = result.mod(to);
	    result = result.add(BigInteger.valueOf(2));
	    return result;
	}
	
}
