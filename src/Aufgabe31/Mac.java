package Aufgabe31;

import java.math.BigInteger;
import CharReader.r;

public class Mac {
	
	static final BigInteger key = BigInteger.valueOf(0x123);
//	static final byte[] m = r.fileToByteArray("src/Aufgabe31/kafka-strafkolonie01.txt");
	static final byte[] clearm = r.fileToByteArray("src/Aufgabe31/short");
	
	public static void main(String args[]){
		System.out.println(Message.create(clearm, key));
	}

}
