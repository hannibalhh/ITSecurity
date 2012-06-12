package Aufgabe31.CharBuffer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import CharReader.Interface.CharReader;

public class Block {

	private final char[] b;
	private static int blockLength = 16; // char
	
	private Block(char[] b){
		this.b = b;
	}
	
	public static Block create(char[] b){
		if (b.length != blockLength){
			System.err.println("Block has wrong size, it must be a length of " + blockLength);
			return null;
		}
		return new Block(b);
	}
	
	public static List<Block> buildBlocks(CharReader blocks){
		List<Block> l = new ArrayList<Block>();
		char[] temp = new char[blockLength];
		int i = 0;
		for(char b: blocks){
			if(i == blockLength){
				i = 0;
				l.add(Block.create(temp));
				temp = new char[blockLength];
			}
			temp[i] = b;
			i++;
		}
		if (i > 0){
			l.add(Block.fillKey(temp));
		}
		return l;
	}
	
	public static Block fillKey(char[] k){
		if (k.length < blockLength){			
			char[] array = new char[blockLength];
			for(int i = 0;i < blockLength;i++){
				if (i >= blockLength-k.length){
					array[i] = k[blockLength-i-1];
				}
				else{
					array[i] = '0';
				}
			}
			return create(array);
		}
		else if (k.length == blockLength){
			return create(k);
		}
		else{
			System.err.println("key to long: " + k.length);
			return null;
		}
	}
	
	public int countNullValues(){
		int i = 0;
		for (char b: this.value()){
			if (b == '0')
				i += 1;
		}
		return i;
	}
	
	public static char intToChar(int value) {
	    return (char)value;
	}
	
	public Block hash(Block b){
		return create(hash(this.value(),b.value()));
	}
	
	private char[] hash(char[] a, char[] b){
		char[] r = new char[a.length];
		for (int i=0;i<a.length;i++){
			r[i] = intToChar(a[i] ^ b[i]);
		}
		return r;
	}
	
	public char[] value(){
		return b;
	}
	
	public static int length(){
		return blockLength;
	}

	@Override
	public String toString() {
		return "Block(b=" + print(b) + ")";
	}
	
	public static String print(char[] array) {
		String s = "chars(";
		for (char b : array) {
			s += (char) b;
		}
		return s + ")";
	}
	
	public String number() {
		String s = "";		
		
		for (char myb : b) {
			s += Integer.valueOf((int)myb);
		}
		return new BigInteger(s).toString(16);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(b);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Block other = (Block) obj;
		if (!Arrays.equals(b, other.b))
			return false;
		return true;
	}	
}
