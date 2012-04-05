package Aufgabe13;

import Aufgabe11aCaesar.Caesar;
import Aufgabe11bSkytale.SkytaleHighLevel;
import CharReader.r;

//2x Keys -> HŠufigkeitsverteilung -> Sicherheit? -> Protokollieren
public class aSkytaleHighLevelLongTest {

	public static void main(String args[]){
		test(99);
	}
	
	public static void test(int key){
		String phrase = r.file("src/Aufgabe12/kafka-strafkolonie01.txt").toString();
		SkytaleHighLevel c = SkytaleHighLevel.create(phrase, key);
		String crypt = c.crypt();
		System.out.println("crypt:" + crypt);
		SkytaleHighLevel c2 = SkytaleHighLevel.create(crypt, key);
		String phrase2 = c2.decrypt();
//		System.out.println(crypt);
		System.out.println(phrase2);
	}
}
