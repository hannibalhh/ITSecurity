package Aufgabe31.Char;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	public static List<Block> buildBlocks(char[] blocks){
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
				if (i < k.length){
					array[i] = k[i];
				}
				else{
					array[i] = 0;
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
		String s = "";
		for (char b : array) {
			s += (char) b;
		}
		return s;
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
