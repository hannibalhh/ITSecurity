package Aufgabe13;

import java.util.Properties;

import Aufgabe11aCaesar.Caesar;
import Aufgabe11bSkytale.SkytaleLowLevel;
import CharReader.r;

//2x Keys -> HŠufigkeitsverteilung -> Sicherheit? -> Protokollieren
public class aSkytaleLongTest {

	public static void main(String args[]){
		test(99);
	}
	
	public static void test(int key){
		String phrase = r.file("src/Aufgabe12/kafka-strafkolonie01.txt").toString();
		SkytaleLowLevel c = SkytaleLowLevel.create(phrase, key);
		String crypt = c.crypt();
		System.out.println("crypt:" + crypt);
		SkytaleLowLevel c2 = SkytaleLowLevel.create(crypt, key);
		String phrase2 = c2.decrypt();
		long t = System.nanoTime();
//		System.out.println(crypt);
//		System.out.println(phrase2);
		System.out.println(System.nanoTime()-t);
	}
}
