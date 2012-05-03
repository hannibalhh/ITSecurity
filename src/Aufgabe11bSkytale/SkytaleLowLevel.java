package Aufgabe11bSkytale;

import StringWriter.w;
import CharReader.r;
import CharReader.Interface.CharReader;

public class SkytaleLowLevel {

	public static void main(String[] args) {

//		System.out.println(ntest());
		simpleTest();
	}

	public static void simpleTest() {
		int key = 5;
		SkytaleLowLevel c = create(r.file("src/Aufgabe11bSkytale/SkytaleTest")
				.toString(), key);
		String crypt = c.crypt();
		w.file("src/Aufgabe11bSkytale/SkytaleTestLowCrypted").write(crypt);
		SkytaleLowLevel c1 = create(crypt, key);
		String decrypt = c1.decrypt();
		w.file("src/Aufgabe11bSkytale/SkytaleTestLowDecrypted").write(decrypt);
		System.out.println("Finished.");
	}

	public static boolean test(int key) {
		String phrase = r.file("src/Aufgabe11bSkytale/SkytaleTest").toString();
		SkytaleLowLevel c = create(phrase, key);
		String crypt = c.crypt();
		SkytaleLowLevel c2 = create(crypt, key);
		String phrase2 = c2.decrypt();
		if (!phrase.equals(phrase2))
			System.out.println("key" + key + ": " + phrase + " = " + phrase2
					+ "'");
		return phrase.equals(phrase2.trim());
	}

	public static boolean ntest() {
		for (int i = 0; i <= 100; i++) {
			if (!test(i)) {
				return false;
			}
		}
		return true;
	}

	final private String s;
	final private CharReader cr;
	final private int key;
	final private int columns;
	public static final SkytaleLowLevel NaC = new SkytaleLowLevel("", Integer.MIN_VALUE);

	private SkytaleLowLevel(String s, int key) {
		this.s = s;
		this.cr = r.string(s);
		this.key = key;
		this.columns = columns(key);
	}

	public boolean isNaC() {
		return this == NaC;
	}

	public static SkytaleLowLevel create(String s, int key) {
		if (s == null) {
			System.err.println("String can't be null");
			return NaC;
		}
		if (key < 0 || key > 100) {
			System.err.println("Your key in not valid (only 0-100)");
			return NaC;
		} else
			return new SkytaleLowLevel(s, key);
	}

	private String flatten(char matrix[][]) {
		print(matrix);
		String s = "";
		for (char[] m : matrix) {
			for (Character c : m) {
				s += c;
			}
		}
		return s;
	}
	
	private static String print(char[] m){
		String str = "[";
		for (char c: m){
			str += "(" + c + ")";
		}
		str += ']';
		return str;
	}
	private static void print(char[][] m){
		String str = "[";
		for (char[] cl: m){
			str  += print(cl) + "\n";
		}
		str += ']';
		System.out.println(str);
	}
	
	private int next(char list[]){
		int next = 0;
		for(char c: list){
			if (!Character.isIdentifierIgnorable(c)){
				next += 1;
			}
		}
		return next;
	}

	private int columns() {
		return columns;
	}

	private int columns(int key) {
		if (key == 0)
			return 0;
		if (s.length() % key == 0)
			return s.length() / key;
		else
			return s.length() / key + 1;
	}
	
	public int key() {
		return key;
	}

	public int rows() {
		return key;
	}

//	private char[][] crypt(int circle, int circle_len, char[][] matrix) {
//		if (!cr.hasNext())
//			return matrix;
//		else {
//			char c = cr.next();
//			if (circle < circle_len) {				
////				System.out.println("[" + circle + "][" + next(matrix[circle]) + "] = " + c);
//				matrix[circle][next(matrix[circle])] = c;
//				return crypt(circle + 1, circle_len, matrix);
//			} else {
////				System.out.println("[" + circle + "][" + next(matrix[0]) + "] = " + c);
//				matrix[0][next(matrix[0])] = c;
//				return crypt(1, circle_len, matrix);
//			}
//		}
//	}
	
	private char[][] crypt(int circle, int circle_len, char[][] matrix) {
		while (cr.hasNext())
		{
			char c = cr.next();
			if (circle < circle_len) {				
//				System.out.println("[" + circle + "][" + next(matrix[circle]) + "] = " + c);
				matrix[circle][next(matrix[circle])] = c;
				circle += 1;
			} else {
//				System.out.println("[" + circle + "][" + next(matrix[0]) + "] = " + c);
				matrix[0][next(matrix[0])] = c;
				circle = 1;
			}
		}
		return matrix;
	}
	
	private String crypt(int circle_len,int columns, int rows){
		if (isNaC())
			return "";
		if (key() == 0)
			return s;
		char matrix[][] = new char[columns][rows]; 
		matrix = crypt(0, circle_len, matrix);
		return flatten(matrix);
	}

	public String crypt() {
		return crypt(columns(),columns(),rows());
	}

	public String decrypt() {
		return crypt(rows(),rows(),columns()).trim();
	}

}
