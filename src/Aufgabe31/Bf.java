package Aufgabe31;

import java.math.BigInteger;

public class Bf {

	int leading0s;
	Block mac;
	int searchedKeys;
	String foundKey;
	byte[] clearm;
	public Bf(int leading0s, Block mac, byte[] clearm ){
		this.leading0s=leading0s;
		this.mac=mac;
		this.clearm=clearm;
		this.foundKey= findKey();
	}
	
	public BigInteger amountPossibleKeysWithN0s(){
		
		BigInteger biggi= BigInteger.valueOf(2);
		return biggi.pow((mac.length()*8)-leading0s);
	}
	
	public BigInteger amountPossibleKeysAbsolute(){
		BigInteger biggi= BigInteger.valueOf(2);
		return biggi.pow((mac.length()*8));
	}
	
	private String findKey(){
		searchedKeys=0;
		BigInteger maxRounds=amountPossibleKeysAbsolute();
		System.out.println("max Rounds="+maxRounds);
		for(BigInteger i=BigInteger.valueOf(0); i.compareTo(maxRounds)<0; i=i.add(BigInteger.valueOf(1))){
			Message mess=Message.create(this.clearm,i);
			if(mess.m().equals(mac)){
				return Integer.toHexString(i.intValue());
			}
			else searchedKeys++;
		}
		
		return "nothing found";
	}
	
}
