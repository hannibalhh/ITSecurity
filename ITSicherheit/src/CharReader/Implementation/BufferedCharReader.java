package CharReader.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import CharReader.Interface.CharReader;

public class BufferedCharReader implements CharReader{
	
	final private BufferedReader s;
	public static final BufferedCharReader NaC = new BufferedCharReader(null);
	
	private BufferedCharReader(BufferedReader s){
		this.s = s;
	}
	
	@Override
	public boolean isNaC(){
		return this == NaC;
	}
	
	public static BufferedCharReader create(String str){
		if (str == null){
			System.err.println("CharReader is not valid. Filepath cant be null");
			return NaC;
		}
		else{
			BufferedReader s;
			try {
//				s = new BufferedReader(new FileReader(str));
				
				InputStream fis = new FileInputStream(str);
			    Reader isr = new InputStreamReader(fis, "8859_1");
			    s=new BufferedReader(isr);
			} catch (FileNotFoundException e) {
				System.err.println("CharReader is not valid. FileNotFoundException.");
				return NaC;
			} catch (UnsupportedEncodingException e) {
				System.err.println("CharReader is not valid. UnsupportedEncodingException.");
				return NaC;
			}
			return new BufferedCharReader(s);
		}
			
	}
	
	public boolean hasNext(){
		if (isNaC()){
			return false;
		}
		try {
			return s.ready();
		} catch (IOException e) {
			return false;
		}
	}
	
	public char next(){
		if (isNaC()){
			System.err.println("CharReader is not valid");
			return '0';
		}
		try {
			return (char)(int)s.read();
		} catch (IOException e) {
			System.err.println("You read out of BufferedReader");
			return '0';
		}
	}

	@Override
	public Iterator<Character> iterator() {
		return CharacterIterator.valueOf(this);
	}
	
	@Override
	public String toString(){
		String s = "";
		for (char c:this){
			s += c;
		}
		return s;
	}

}
