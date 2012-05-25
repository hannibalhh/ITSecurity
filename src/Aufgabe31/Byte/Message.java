package Aufgabe31.Byte;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Message {

	private final Block m;
	private final byte[] clearm;
	private final Block k;

	private Message(Block m, byte[] clearm, Block k) {
		this.m = m;
		this.clearm = clearm;
		this.k = k;
	}

	public static Message create(byte[] clearm, BigInteger k) {
		Block filledk = Block.fillKey(k.toString().getBytes());
		return new Message(mac(clearm, filledk), clearm, filledk);
	}
	public static Message create(byte[] clearm, String k) {
		Block filledk = Block.fillKey(k.getBytes());
		return new Message(mac(clearm, filledk), clearm, filledk);
	}

	public static Block mac(byte[] clearm, Block filledk) {
		List<Block> blocks = new ArrayList<Block>();
		blocks.add(filledk);
		blocks.addAll(Block.buildBlocks(clearm));
		System.out.println("Blocks with key: " + blocks);
		Iterator<Block> i = blocks.iterator();
		Block a = i.next();
		Block b = null;
		int rounds = 0;
		while (i.hasNext()) {
			b = a;
			a = i.next();
			a = a.hash(b);	
			rounds++;
		}
		System.out.println("MAC rounds: " + rounds);
		return a;
	}
	
	

	public Block m() {
		return m;
	}

	public byte[] clearm() {
		return clearm;
	}

	public Block k() {
		return k;
	}

	public static int blockLength() {
		return Block.length();
	}

	@Override
	public String toString() {
		return "Message(m=" + m + ", clearm=" + Block.print(clearm) + ", k=" + k + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(clearm);
		result = prime * result + ((k == null) ? 0 : k.hashCode());
		result = prime * result + ((m == null) ? 0 : m.hashCode());
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
		if (m == null) {
			if (other.m != null)
				return false;
		} else if (!m.equals(other.m))
			return false;
		return true;
	}

}
