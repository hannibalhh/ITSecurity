package Aufgabe43;

import CharReader.r;
import CharReader.Interface.CharReader;


public class Oscar {
	static final String path = "src/Aufgabe43/text";
	static final CharReader clearm = r.file(path);
	// 65334
	
	public static void main(String args[]){

		newMessage();
//		newMac(229,"00");
	}
	
	public static void newMac(int mac,String affix){
		MacCalculator m = MacCalculator.create(mac,affix);
		System.out.println("m: " + m);		
	}
	
	public static void newMessage(){
		MacCalculator m = MacCalculator.createReverse(229,clearm.toString());
		System.out.println("m: " + m);		
		
		MacCalculator m2 = MacCalculator.create(65334,clearm.toString());
		System.out.println("m: " + m2);	
	}
}
