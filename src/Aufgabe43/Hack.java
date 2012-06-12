package Aufgabe43;

import Aufgabe31.CharBuffer.Bf;
import Aufgabe31.CharBuffer.Block;

public class Hack {

	static final String path = "src/Aufgabe43/text";
	public static void main(String args[]){
		Block mac = Block.fillKey("229".toCharArray());
		System.out.println(mac);
		System.out.println(mac.countNullValues());
		Bf bf= Bf.create(12*8,mac,path);
		System.out.println("Found HEX-String key: 0x"+bf.foundKey);
		System.out.println("tested Keys: "+bf.searchedKeys);
		System.out.println("Duration in ms: "+bf.lastDurationMS);
	}
}
