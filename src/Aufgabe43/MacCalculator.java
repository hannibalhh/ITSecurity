package Aufgabe43;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MacCalculator {
	private final Block premac;
	private final Block mac;
	private final String affix;

	private MacCalculator(Block premac,Block mac,String affix) {
		this.mac = mac;
		this.premac = premac;
		this.affix = affix;
	}

	public static MacCalculator create(int premac, String affix) {
		List<Block> affixblocks = Block.buildBlocks(affix.toCharArray());
		char[] premacList = new char[1];
		premacList[0] = (char)premac;
		Block filledpremac = Block.fill(premacList);
		System.out.println("filledpremac:" + filledpremac);
		return new MacCalculator(filledpremac,mac(affixblocks, filledpremac), affix);
	}
	
	public static MacCalculator createReverse(int premac, String clearm) {
		List<Block> clearmblocks = Block.buildBlocks(clearm.toCharArray());
		char[] premacList = new char[1];
		premacList[0] = (char)premac;
		Block filledpremac = Block.fill(premacList);
		System.out.println("filledpremac:" + filledpremac);
		return new MacCalculator(filledpremac,reverseMac(clearmblocks, filledpremac), clearm);
	}

	public static Block mac(List<Block> affix, Block premac) {
		List<Block> blocks = new ArrayList<Block>();
		blocks.add(premac);
		blocks.addAll(affix);
		Iterator<Block> i = blocks.iterator();
		Block a = i.next();
		Block b = null;
		while (i.hasNext()) {
			b = a;
			a = i.next();
			a = a.hash(b);	
		}
		return a;
	}
	
	public static Block reverseMac(List<Block> clearm, Block premac) {
		List<Block> blocks = new ArrayList<Block>();
		blocks.add(premac);
		blocks.addAll(clearm);
		Collections.reverse(blocks);
		Iterator<Block> i = blocks.iterator();
		Block a = i.next();
		Block b = null;
		while (i.hasNext()) {
			b = a;
			a = i.next();
			a = a.reverseHash(b);	
		}
		return a;
	}
	
	public String affix() {
		return affix;
	}
	
	public Block premac() {
		return premac;
	}	

	public Block mac() {
		return mac;
	}

	public static int blockLength() {
		return Block.length();
	}

	@Override
	public String toString() {
		return "MacCalculator(premac=" + premac + ", mac=" + mac + ", affix="
				+ affix + ")";
	}


}
