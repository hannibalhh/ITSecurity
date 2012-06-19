package Aufgabe43;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MacCalculator {
	private final Block premac;
	private final Block mac;
	private final String affix;
	private final int macAsInt; 
	
	private MacCalculator(Block premac,Block mac,String affix) {
		this.mac = mac;
		this.premac = premac;
		this.affix = affix;
		this.macAsInt=Integer.parseInt(mac.number());
	}


	public static MacCalculator create(int premac, String affix) {
		List<Block> affixblocks = Block.buildBlocks(affix.toCharArray());
		char[] premacList = new char[1];
		premacList[0] = (char)premac;
		Block filledpremac = Block.fill(premacList);
		return new MacCalculator(filledpremac,mac(affixblocks, filledpremac), affix);
	}
	
	public static MacCalculator createReverse(int premac, String clearm) {
		List<Block> clearmblocks = Block.buildBlocks(clearm.toCharArray());
		char[] premacList = new char[1];
		premacList[0] = (char)premac;
		Block filledpremac = Block.fill(premacList);
		Block macFromKey=reverseMac(clearmblocks, filledpremac);
		if(Oscar.DEBUG)System.out.println("mac from key: "+macFromKey);
		
		return new MacCalculator(filledpremac,macFromKey, clearm);
	}

	public static Block mac(List<Block> affix, Block premac) {
		
		//liste mit der Nachrricht wird rückwärts ausgewertet
		//kopiert wegen java mutable kram...
		List<Block> blocks = new ArrayList<Block>();
		blocks.addAll(affix);
		if(Oscar.DEBUG)System.out.println("affix: "+blocks);
		Block b = premac;
		for(int j=0; j<blocks.size(); j++){
			b=b.hash(blocks.get(j));
		}
		return b;
		
		/*	blocks.add(premac);
		blocks.addAll(affix);
		Iterator<Block> i = blocks.iterator();
		Block a = i.next();
		Block b = null;
		while (i.hasNext()) {
			b = a;
			a = i.next();
			a = a.hash(b);	
		}
		return a;*/
	}
	
	public static Block reverseMac(List<Block> clearm, Block premac) {
	
		//liste mit der Nachrricht wird rückwärts ausgewertet
		//kopiert wegen java mutable kram...
		List<Block> blocks = new ArrayList<Block>();
		blocks.addAll(clearm);
		if(Oscar.DEBUG)System.out.println("clearm: "+blocks);
		//blocks.addAll(clearm);
		
		Collections.reverse(blocks);
		Block b = premac;
		for(int j=0; j<blocks.size(); j++){
			b=b.reverseHash(blocks.get(j));
		}

		return b;
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

	public int getMacAsInt(){
		return macAsInt;
	}
}
