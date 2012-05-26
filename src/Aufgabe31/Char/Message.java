package Aufgabe31.Char;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Message {

	private final Block mac;
	private final char[] clearm;
	private final Block k;

	private Message(Block m, char[] clearm, Block k) {
		this.mac = m;
		this.clearm = clearm;
		this.k = k;
	}

	public static Message create(char[] clearm, BigInteger k) {
		Block filledk = Block.fillKey(k.toString().toCharArray());
		return new Message(mac(clearm, filledk), clearm, filledk);
	}
	public static Message create(char[] clearm, String k) {
		Block filledk = Block.fillKey(k.toCharArray());
		return new Message(mac(clearm, filledk), clearm, filledk);
	}

	public static Block mac(char[] clearm, Block filledk) {
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
	
	

	public Block mac() {
		return mac;
	}

	public char[] clearm() {
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
		return "Message(m=" + mac + ", clearm=" + Block.print(clearm) + ", k=" + k + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(clearm);
		result = prime * result + ((k == null) ? 0 : k.hashCode());
		result = prime * result + ((mac == null) ? 0 : mac.hashCode());
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
		if (mac == null) {
			if (other.mac != null)
				return false;
		} else if (!mac.equals(other.mac))
			return false;
		return true;
	}

}
