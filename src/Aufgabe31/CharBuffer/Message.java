package Aufgabe31.CharBuffer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import CharReader.Interface.CharReader;

public class Message {

	private final Block mac;
	private final List<Block> clearm;
	private final Block k;

	private Message(Block mac, List<Block> clearm, Block k) {
		this.mac = mac;
		this.clearm = clearm;
		this.k = k;
	}

	public static Message create(CharReader clearm, BigInteger k) {
		List<Block> clearblocks = Block.buildBlocks(clearm);
		Block filledk = Block.fillKey(k.toString(16).toCharArray());
		return new Message(mac(clearblocks, filledk), clearblocks, filledk);
	}
	public static Message create(CharReader clearm, String k) {
		List<Block> clearblocks = Block.buildBlocks(clearm);
		Block filledk = Block.fillKey(k.toCharArray());
		return new Message(mac(clearblocks, filledk), clearblocks, filledk);
	}

	public static Block mac(List<Block> clearm, Block filledk) {
		List<Block> blocks = new ArrayList<Block>();
		blocks.add(filledk);
		blocks.addAll(clearm);
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

	public List<Block> clearm() {
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
		return "Message(mac=" + mac.number() + ", clearm=" + clearm + ", k=" + k + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clearm == null) ? 0 : clearm.hashCode());
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
		if (clearm == null) {
			if (other.clearm != null)
				return false;
		} else if (!clearm.equals(other.clearm))
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
