package Aufgabe43;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Block {

	
	
	private final char[] b;
	private static int blockLength = 1; // char

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
			l.add(Block.fill(temp));
		}
		return l;
	}

	public static Block fill(char[] k){
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

	private char[] hash(char[] premac, char[] ch){
		char[] r = new char[premac.length];
	
		
		for (int i=0;i<premac.length;i++){
			int premacInt=premac[i];
			int charInt=ch[i];
			int ic= premacInt+charInt;
			int result=ic %	256;
			if(Oscar.DEBUG)System.out.println("hashing: \'"+(char)charInt+  "\'(="+ charInt +") with premac:"+premacInt+" and getting result: "+ result);
			r[0]=(char)result;

		}
		return r;
	}

	public Block reverseHash(Block b){
		return create(reverseHash(this.value(),b.value()));
	}

	private char[] reverseHash(char[] foundMac, char[] hint){
		char[] newMac = new char[foundMac.length];

		//getting loop out for  readability ;)
		if(foundMac.length==1 && hint.length==1){
			
			int a=foundMac[0];
			int b=hint[0];
			int c=a-b;
			int result=c % 256;
			if(result<0)result=256+result;
			
			if(Oscar.DEBUG)System.out.println("reducing: \'"+(char)b+  "\'(="+ b +") with foundMac: "+a+" and getting result: "+ result);
			newMac[0]=(char)result;
		}else{
			System.err.println("only works with block size 1!!!");
			return foundMac;
			}
		
		return newMac;
	}

	public char[] value(){
		return b;
	}

	public static int length(){
		return blockLength;
	}

	@Override
	public String toString() {
		return "Block(b=" + number() + ")";
	}

	//	public static String print(char[] array) {
	//		String s = "chars(";
	//		for (char b : array) {
	//			s += (char) b;
	//		}
	//		return s + ")";
	//	}

	public String number() {
		String s = "";		

		for (char myb : b) {
			s += Integer.valueOf((int)myb);
		}
		return new BigInteger(s).toString(10);
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
