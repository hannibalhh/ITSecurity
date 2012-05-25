package Aufgabe31.Char;

import java.math.BigInteger;
import CharReader.r;

public class MacTest {
	
	static final BigInteger key = BigInteger.valueOf(0x123);
//	static final char[] m = r.fileTocharArray("src/Aufgabe31/kafka-strafkolonie01.txt");
//	static final char[] clearm = r.fileTocharArray("src/Aufgabe31/short");
	static final char[] clearm = r.file("src/Aufgabe31/short").toString().toCharArray();
	
	public static void main(String args[]){
		easyTest();
	}
	
	public static void easyTest(){
		System.out.println(r.file("src/Aufgabe31/short").toString());
		System.out.println(Block.print(clearm));
		Message m = Message.create(clearm, key);
		System.out.println(m);
	}	
	
	public static void bruteForceTest(){
		Message m=Message.create(clearm, key);
		System.out.println(m);
		Bf bf=new Bf(15*8,m.m(),clearm);
		System.out.println("Found HEX-String key: 0x"+bf.foundKey);
		System.out.println("tested Keys: "+bf.searchedKeys);
		System.out.println("Duration in ms: "+bf.lastDurationMS);		
	}

}
