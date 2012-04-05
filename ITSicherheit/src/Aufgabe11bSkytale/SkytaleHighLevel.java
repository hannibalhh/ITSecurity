package Aufgabe11bSkytale;

import java.util.*;

import CharReader.CharReader;
import CharReader.r;

public class SkytaleHighLevel {

	public static void main(String[] args) {
		System.out.println(ntest());
//		simpleTest();
	}
	
	public static void simpleTest(){
		int key = 3;
		SkytaleHighLevel c = create(r.file("src/Aufgabe11bSkytale/SkytaleTest").toString(), key);
		String crypt = c.crypt();
		System.out.println("  crypt: " + crypt);
		SkytaleHighLevel c1 = create(crypt, key);
		System.out.println("decrypt: " + c1.decrypt());
	}
	
	public static boolean test(int key){
		String phrase = r.file("src/Aufgabe11bSkytale/SkytaleTest").toString();
		SkytaleHighLevel c = create(phrase, key);
		String crypt = c.crypt();
		SkytaleHighLevel c2 = create(crypt, key);
		String phrase2 = c2.decrypt();
		if (!phrase.equals(phrase2))
			System.out.println("key" + key + ": " + phrase + " = " + phrase2 + "'");
		return phrase.equals(phrase2.trim());
	}
	
	public static boolean ntest(){
		for (int i=0;i<100;i++){
			if (!test(i)){
				return false;
			}
		}
		return true;
	}

	final private String s;
	final private CharReader cr;
	final private int key;
	final private int columns;
	public static final SkytaleHighLevel NaC = new SkytaleHighLevel("", Integer.MIN_VALUE);

	private SkytaleHighLevel(String s, int key) {
		this.s = s;
		this.cr = r.string(s);
		this.key = key;
		this.columns = columns(key);
	}

	public boolean isNaC() {
		return this == NaC;
	}

	public static SkytaleHighLevel create(String s, int key) {
		if (s == null) {
			System.err.println("String can't be null");
			return NaC;
		}
		if (key < 0 || key > 100) {
			System.err.println("Your key in not valid (only 0-100)");
			return NaC;
		} else
			return new SkytaleHighLevel(s, key);
	}
	
	private String flatten (List<ArrayList<Character>> matrix){
		String s = "";
		for (ArrayList<Character> m: matrix){
			for (Character c : m){				
				s += c;
			}
		}
		return s;
	}	
	
	private List<ArrayList<Character>> fillup(List<ArrayList<Character>> matrix,char filler,int size){
		for (ArrayList<Character> m: matrix){
			while (m.size() < size){
				m.add(filler);
			}
		}
		return matrix;
	}
	
	private int columns(){
		return columns;
	}
	
	private int columns(int key){
		if (key == 0)
			return 0;
		if (s.length() % key == 0)
			return s.length() / key;
		else
			return s.length() / key+1;
	}

//	private List<ArrayList<Character>> crypt(int circle, int circle_len,
//			List<ArrayList<Character>> matrix) {
//		if (!cr.hasNext())
//			return matrix;
//		else{
//			if (circle < circle_len){
//				if(!(matrix.size() > circle))
//					matrix.add(new ArrayList<Character>());
//				matrix.get(circle).add(cr.next());
//				return crypt(circle+1,circle_len,matrix);
//			}
//			else{
//				matrix.get(0).add(cr.next());
//				return crypt(1,circle_len,matrix);				
//			}
//		}
//	}
	
	private List<ArrayList<Character>> crypt(int circle, int circle_len,
			List<ArrayList<Character>> matrix) {
		while (cr.hasNext()){
			if (circle < circle_len){
				if(!(matrix.size() > circle))
					matrix.add(new ArrayList<Character>());
				matrix.get(circle).add(cr.next());
				circle += 1;
			}
			else{
				matrix.get(0).add(cr.next());
				circle = 1;			
			}
		}
		return matrix;
	}
	
	public String crypt() {
		if (isNaC())
			return "";
		if (key() == 0){
			return s;
		}
		List<ArrayList<Character>> matrix = crypt(0,columns(),new ArrayList<ArrayList<Character>>());
		return flatten(fillup(matrix,' ',key()));
	}

	public String decrypt() {
		if (isNaC())
			return "";
		if (key() == 0){
			return s;
		}
		List<ArrayList<Character>> matrix = crypt(0,key(),new ArrayList<ArrayList<Character>>());
		return flatten(matrix).trim();
	}

	public int key() {
		return key;
	}

}
