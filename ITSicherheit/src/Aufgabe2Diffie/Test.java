package Aufgabe2Diffie;

import java.math.BigInteger;

public class Test {
	
	public static void main(String args[]){
		test(100,1024);
//		test();
	}
	
	public static void test(int n, int bitLength){
		SmallInteger si = SmallInteger.create(BigPrimeN.create(bitLength).next());
		for (int i = 0;i<n;i++){
			test(si.next(),si.next());
		}
	}
	
	public static void test(BigInteger x, BigInteger y){
		Alice alice = Alice.create(x);
		Bob bob = Bob.create(y);
		alice.init(bob);
		System.out.println(alice.isBundledWith(bob));
	}
	
	public static void test(){
		Alice alice = Alice.create(BigInteger.valueOf(2));
		Bob bob = Bob.create(BigInteger.valueOf(4));
		alice.init(bob);
		System.out.println(alice);
		System.out.println(bob);
		System.out.println(alice.isBundledWith(bob));
	}

}
