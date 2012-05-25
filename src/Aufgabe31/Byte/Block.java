package Aufgabe31.Byte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Block {

	private final byte[] b;
	private static int blockLength = 16; // byte
	
	private Block(byte[] b){
		this.b = b;
	}
	
	public static Block create(byte[] b){
		if (b.length != blockLength){
			System.err.println("Block has wrong size, it must be a length of " + blockLength);
			return null;
		}
		return new Block(b);
	}
	
	public static List<Block> buildBlocks(byte[] blocks){
		List<Block> l = new ArrayList<Block>();
		byte[] temp = new byte[blockLength];
		int i = 0;
		for(byte b: blocks){
			if(i == blockLength){
				i = 0;
				l.add(Block.create(temp));
				temp = new byte[blockLength];
			}
			temp[i] = b;
			i++;
		}
		if (i > 0){
			l.add(Block.fillKey(temp));
		}
		return l;
	}
	
	public static Block fillKey(byte[] k){
		if (k.length < blockLength){
			byte[] array = new byte[blockLength];
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
	
	public static byte intToByte(int value) {
	    return (byte)value;
	}
	
	public Block hash(Block b){
		return create(hash(this.value(),b.value()));
	}
	
	private byte[] hash(byte[] a, byte[] b){
		byte[] r = new byte[a.length];
		for (int i=0;i<a.length;i++){
			r[i] = intToByte(a[i] ^ b[i]);
		}
		return r;
	}
	
	public byte[] value(){
		return b;
	}
	
	public static int length(){
		return blockLength;
	}

	@Override
	public String toString() {
		return "Block(b=" + print(b) + ")";
	}
	
	public static String print(byte[] array) {
		String s = "";
		for (byte b : array) {
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
