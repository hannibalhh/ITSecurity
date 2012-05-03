package Aufgabe13;

import StringWriter.w;
import Aufgabe11aCaesar.Caesar;
import Aufgabe11bSkytale.SkytaleLowLevel;
import CharReader.r;

//2x Keys -> HŠufigkeitsverteilung -> Sicherheit? -> Protokollieren
public class bCaesarLongTest {


	public static void main(String args[]){
		test(22);
	}
	
	
	public static void test(int key){
		String phrase = r.file("src/Aufgabe12/kafka-strafkolonie01.txt").toString();
		Caesar c = Caesar.create(phrase, key);
		String crypt = c.crypt();
		w.file("src/Aufgabe13/CaesarCrypted["+key+"]").write(crypt);
		Caesar c2 = Caesar.create(crypt, key);
		String decrypt = c2.decrypt();
		w.file("src/Aufgabe13/CaesarDecrypted["+key+"]").write(decrypt);
	}
}
