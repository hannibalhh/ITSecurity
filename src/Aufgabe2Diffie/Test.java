package Aufgabe2Diffie;

import java.math.BigInteger;

public class Test {
	
	static long fastest = Long.MAX_VALUE;
	
	public static void main(String args[]){
		for (int i = 0;i<10;i++)
			test(100,1024);
		s();
	}
	
	public static boolean test(int n, int bitLength){
		SmallInteger si = SmallInteger.create(BigPrimeN.create(bitLength).next());
		System.out.print("Test is running... ");
		long start = System.currentTimeMillis();
		for (int i = 0;i<n;i++){
			if (!test(si.next(),si.next())){
				return false;
			}
		}
		long end = System.currentTimeMillis()-start;
		if (end < fastest)
			fastest = end;
		System.out.println("and is successful with "  + end + "ms");
		return true;
	}
	
	public static boolean test(BigInteger x, BigInteger y){
		Alice alice = Alice.create(x);
		Bob bob = Bob.create(y);
		alice.init(bob);
		if (!alice.isBundledWith(bob)){
			System.err.println("Error: x:" + x + "y:" + y);
			return false;
		}
		else
			return true;
	}
	
	public static void test(){
		Alice alice = Alice.create(BigInteger.valueOf(2));
		Bob bob = Bob.create(BigInteger.valueOf(4));
		alice.init(bob);
		System.out.println(alice);
		System.out.println(bob);
		System.out.println(alice.isBundledWith(bob));
	}
	
	public static void s(){
		System.out.println("Fastest test needs " + fastest + "ms");
	}
	
	public static void p(Object o){
		System.out.println(o);
	}

}
