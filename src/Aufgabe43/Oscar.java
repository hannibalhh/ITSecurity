package Aufgabe43;

import CharReader.r;
import CharReader.Interface.CharReader;


public class Oscar {
	public static final boolean DEBUG=true;
	static final String path = "/home/nora/itsec/src/Aufgabe43/text";
	static final CharReader clearm = r.file(path);
	// 65334
	
	public static void main(String args[]){

	//aufgabe 4.3a
	//	newMac(229,"00");
	
	//aufgabe 4.3b
		newMessage(229,clearm.toString(), "UEBERWEISUNG AN COOKIE MONSTER: EUR 423");
	}
	
	public static void newMac(int mac,String affix){
		MacCalculator m = MacCalculator.create(mac,affix);
		System.out.println("m: " + m);		
	}
	
	public static void newMessage(int oldMac,String oldMessage, String newMessage){
		
		
		System.out.println( "read Message: "+oldMessage);
		MacCalculator m = MacCalculator.createReverse(229,oldMessage);
		System.out.println("m: " + m);		
		System.out.println("got Mac from Key: "+m.getMacAsInt());

		System.out.println("\n=======================================\n");
		
		
		MacCalculator m2 = MacCalculator.create(m.getMacAsInt(),oldMessage);
		System.out.println("m2: " + m2);	
		System.out.println("same mac can be repoduced: "+ new Integer(oldMac).equals(new Integer(m2.getMacAsInt())) );
		
		System.out.println("\n=======================================\n");

		
		System.out.println("creating own verifiable message: "+newMessage+"\n");
		MacCalculator m3 = MacCalculator.create(m.getMacAsInt(),newMessage);
		System.out.println("m3: "+m3);
		
	}
}
