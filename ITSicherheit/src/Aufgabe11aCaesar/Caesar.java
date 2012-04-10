package Aufgabe11aCaesar;

import java.io.BufferedWriter;
import java.io.FileWriter;

import StringWriter.w;
import CharReader.r;

public class Caesar {

	public static void main(String[] args) {
//		writest();
		int key = 2;
		Caesar c = create(r.file("src/Aufgabe11aCaesar/CaesarTest").toString(),key);
		String crypt = c.crypt();
		w.file("src/Aufgabe11aCaesar/CaesarTestCrypted").write(crypt);
		Caesar c1 = create(crypt, key);
		String decrypt = c1.decrypt();
		w.file("src/Aufgabe11aCaesar/CaesarTestDecrypted").write(decrypt);
		System.out.println("Finished.");
	}

	final private String s;
	final private int key;
	public static final Caesar NaC = new Caesar(null, Integer.MIN_VALUE);

	private Caesar(String s, int key) {
		this.s = s;
		this.key = key;
	}

	public boolean isNaC() {
		return this == NaC || s == null;
	}

	public static Caesar create(String s, int key) {
		if (s == null) {
			System.err.println("String can't be null");
			return NaC;
		}
		if (key < 0 || key > 255) {
			System.err.println("Your key in not valid (only 0-255)");
			return NaC;
		} else
			return new Caesar(s, key);
	}

	private char crypt(char c, int key) {
		int i = (int) c;
		return (char) (i + key);
	}

	private char decrypt(char c, int key) {
		return crypt(c, -key);
	}

	public String crypt() {
		if (isNaC())
			return "";
		String cryptedTex = "";
		for (char c : s.toCharArray()) {
			cryptedTex += (crypt(c, key));
		}
		return cryptedTex;
	}

	public String decrypt() {
		if (isNaC())
			return "";
		String decryptedTex = "";
		for (char c : s.toCharArray()) {
			decryptedTex += (decrypt(c, key));
		}
		return decryptedTex;
	}

	public int key() {
		return key;
	}

}
