package Aufgabe31;

import java.math.BigInteger;
import CharReader.r;

public class Mac {
	
	static final BigInteger key = BigInteger.valueOf(0x123);
//	static final byte[] m = r.fileToByteArray("src/Aufgabe31/kafka-strafkolonie01.txt");
//	static final byte[] clearm = r.fileToByteArray("src/Aufgabe31/short");
	static final byte[] clearm = r.fileToByteArray("/home/nora/itsec/src/Aufgabe31/short");
	
	public static void main(String args[]){
		Message m=Message.create(clearm, key);
		System.out.println(m);
		Bf bf=new Bf(15*8,m.m(),clearm);
		System.out.println("Found HEX-String key: 0x"+bf.foundKey);
		System.out.println("tested Keys: "+bf.searchedKeys);
		System.out.println("Duration in ms: "+bf.lastDurationMS);
	}

}
