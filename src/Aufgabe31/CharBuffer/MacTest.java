package Aufgabe31.CharBuffer;

import java.math.BigInteger;

import Aufgabe2Diffie.BigPrimeN;
import Aufgabe2Diffie.SmallInteger;
import CharReader.r;
import CharReader.Interface.CharReader;

public class MacTest {
	
	static final BigInteger key = BigInteger.valueOf(0xff235673);
	static final String path = "src/Aufgabe31/short";
//	static final CharReader clearm = r.file("src/Aufgabe31/kafka");
//	static final CharReader clearm = r.file("src/Aufgabe31/short");
	static final CharReader clearm = r.file(path);
	
	public static void main(String args[]){
//		easyTest();
//		bigKeyTest();
		bruteForceTest();
	}
	
	public static void easyTest(){
		Message m = Message.create(clearm, key);
		System.out.println("key: "+ m.k());
		System.out.println("mac: " + m.mac().number());
	}
	
	public static void bigKeyTest(){
		BigPrimeN prime = BigPrimeN.create(32);
		SmallInteger small = SmallInteger.create(prime.next());
		Message m = Message.create(clearm, small.next());
		System.out.println("key: "+ m.k());
		System.out.println("mac: " + m.mac().number());
	}	
	
	public static void bruteForceTest(){
		Message m=Message.create(clearm, key);
		System.out.println("Testnachricht: " + m);
		System.out.println("Brutforce: ");
		Bf bf= Bf.create(15*8,m.mac(),path);
		System.out.println("Found HEX-String key: 0x"+bf.foundKey);
		System.out.println("tested Keys: "+bf.searchedKeys);
		System.out.println("Duration in ms: "+bf.lastDurationMS);		
	}
}
