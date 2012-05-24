package Aufgabe31;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Message {

	private static int blockLength = 16; // byte
	private final byte[] m;
	private final byte[] clearm;
	private final BigInteger k;
	
	private Message(byte[] m,byte[] clearm,BigInteger k){
		this.m = m;
		this.clearm = clearm;
		this.k = k;
	}
	
	public static Message create(byte[] clearm, BigInteger k){
		return new Message(
				mac(clearm,fillKey(k.toByteArray())),
				clearm,
				k);
	}
	
	public static byte[] mac(byte[] clearm, byte[] filledk){ 
		List<Block> blocks = blocks(clearm);
		Iterator<Block> i = blocks.iterator();
		Block a = null;
		Block b = i.next();
		while(i.hasNext()){
			a = b;
			a = Block.create(hash(a.value(),b.value()));
			b = i.next();
		}
		return a.value();
	}	
	
	public static List<Block> blocks(byte[] blocks){
		List<Block> l = new ArrayList<Block>();
		byte[] temp = new byte[blockLength];
		int i = 0;
		for(byte b: blocks){
			if(i % blockLength == 0){
				i = 0;
				temp = new byte[blockLength];
			}
			temp[i] = b;
			l.add(Block.create(temp));
			i++;
		}
		return l;
	}
	
	public static byte[] fillKey(byte[] k){
		if (k.length < blockLength){
			byte[] array = new byte[blockLength];
			for(int i = 0;i < blockLength;i++){
				if (i < blockLength){
					array[i] = k[i];
				}
				else{
					array[i] = 0;
				}
			}
			return array;
		}
		else if (k.length == blockLength){
			return k;
		}
		else{
			System.err.println("key to long: " + k.length);
			return k;
		}
	}
	
	public static final byte intToByte(int value) {
	    return (byte)value;
	}
	
	public static byte[] hash(byte[] a, byte[] b){
		if (a.length != b.length){
			System.err.println("a:" + a.length +" != b:" + b.length);
			System.exit(-1);
		}
		byte[] r = new byte[a.length];
		for (int i=0;i<=a.length;i++){
			r[i] = intToByte(a[i] ^ b[i]);
		}
		return r;
	}
	
	public byte[] m(){
		return m;
	}
	
	public byte[] clearm(){
		return clearm;
	}
	
	public BigInteger k(){
		return k;
	}
	
	public static String print(byte[] array){
		String s = "";
		for (byte b:array){
			s += (char)b;
		}
		return s;
	}
	
	public static int blockLength(){
		return blockLength;
	}

	@Override
	public String toString() {
		return "Message(m=" + Arrays.toString(m) + ", clearm="
				+ Arrays.toString(clearm) + ", k=" + k + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(clearm);
		result = prime * result + ((k == null) ? 0 : k.hashCode());
		result = prime * result + Arrays.hashCode(m);
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
		Message other = (Message) obj;
		if (!Arrays.equals(clearm, other.clearm))
			return false;
		if (k == null) {
			if (other.k != null)
				return false;
		} else if (!k.equals(other.k))
			return false;
		if (!Arrays.equals(m, other.m))
			return false;
		return true;
	}
	
	
}
