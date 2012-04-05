package Aufgabe13;

import Aufgabe11aCaesar.Caesar;
import CharReader.r;

//2x Keys -> HŠufigkeitsverteilung -> Sicherheit? -> Protokollieren
public class bCaesarLongTest {


	public static void main(String args[]){
		test(20);
	}
	
	public static void test(int key){
		String phrase = r.file("src/Aufgabe12/kafka-strafkolonie01.txt").toString();
		Caesar c = Caesar.create(phrase, key);
		String crypt = c.crypt();
		System.out.println(crypt);
		Caesar c2 = Caesar.create(crypt, key);
		String phrase2 = c2.decrypt();
		
//		System.out.println(phrase2);
	}
}
