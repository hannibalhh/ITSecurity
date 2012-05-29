package Aufgabe31.CharBuffer;

import java.math.BigInteger;

import CharReader.r;
import CharReader.Interface.CharReader;

public class Bf {

	int leading0s;
	Block mac; 
	long searchedKeys;
	String foundKey;
	String clearmpath;
	long lastDurationMS=0;
	
	private Bf(int leading0s, Block mac, String clearmpath ){
		this.leading0s=leading0s;
		this.mac=mac;
		this.clearmpath = clearmpath;
		this.foundKey= findKey();
	}
	
	public static Bf create(int leading0s, Block mac,String path){
		return new Bf(leading0s,mac,path);
	}
	
	public BigInteger amountPossibleKeysWithN0s(){	
		BigInteger biggi= BigInteger.valueOf(2);
		return biggi.pow((Block.length()*8)-leading0s);
	}
	
	public BigInteger amountPossibleKeysAbsolute(){
		BigInteger biggi= BigInteger.valueOf(2);
		return biggi.pow((Block.length()*8));
	}
	
	public String findKey(){		
		long start = System.currentTimeMillis();
		searchedKeys=0;
		BigInteger maxRounds=amountPossibleKeysAbsolute();
		System.out.println("max Rounds="+maxRounds);
		for(BigInteger i=BigInteger.valueOf(0); i.compareTo(maxRounds)<0; i=i.add(BigInteger.valueOf(1))){
			Message mess=Message.create(r.file(this.clearmpath),i);
//			System.out.println("mess.mac: " + mess.mac().number());
//			System.out.println("mac: " + mac.number());
			if(mess.mac().equals(mac)){
				this.lastDurationMS = System.currentTimeMillis()-start;
				return Integer.toHexString(i.intValue());			
			}
			else searchedKeys++;
		}
		this.lastDurationMS = System.currentTimeMillis()-start;
		return "nothing found";
	}	
}
