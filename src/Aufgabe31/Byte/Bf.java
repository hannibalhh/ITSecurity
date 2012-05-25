package Aufgabe31.Byte;

import java.math.BigInteger;

public class Bf {

	int leading0s;
	Block mac;
	long searchedKeys;
	String foundKey;
	byte[] clearm;
	long lastDurationMS=0;
	
	public Bf(int leading0s, Block mac, byte[] clearm ){
		this.leading0s=leading0s;
		this.mac=mac;
		this.clearm=clearm;
		this.foundKey= findKey();
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
			Message mess=Message.create(this.clearm,i);
			if(mess.m().equals(mac)){
				this.lastDurationMS = System.currentTimeMillis()-start;
				return Integer.toHexString(i.intValue());			
			}
			else searchedKeys++;
		}
		this.lastDurationMS = System.currentTimeMillis()-start;
		return "nothing found";
	}	
}
