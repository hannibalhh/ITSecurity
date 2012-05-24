package Aufgabe31;

import java.util.Arrays;

public class Block {

	private final byte[] b;
	private static int blockLength = Message.blockLength();
	
	private Block(byte[] b){
		this.b = b;
	}
	
	public static Block create(byte[] b){
		if (b.length > blockLength){
			System.err.println("block is too long");
			return null;
		}
		return new Block(b);
	}
	
	public byte[] value(){
		return b;
	}

	@Override
	public String toString() {
		return "Block(b=" + Arrays.toString(b) + ")";
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
