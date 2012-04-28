package Aufgabe2Diffie;

import java.math.BigInteger;
import java.util.BitSet;

public class MathUtil {

	public static BigInteger squareAndMultiply(BigInteger x, BigInteger exp){
		int bitCounter=0;
		byte[] bytearray=exp.toByteArray();
		BigInteger result=x;
		
		for(byte b:bytearray){			
			
			for(int i=0;i<8;i++){
				if(bitCounter>=exp.bitLength()-1){
					return result;
				}else{
					bitCounter++;
				}
				result=result.pow(2);
				
				//eine 1 zu der überprüfenden stelle shiften -> bitweise und --> wenn die herrauskommende zahl groesser 0, 
				//dann wars eine 1 an der i-ten stelle
				boolean h=(b & (1 << i)) > 0;
				
				
				System.out.println("h: "+h);
				if (h)  
			    {  
					result=result.multiply(x);
			    }  		
				System.out.println("actual result:"+result.toString());
				
			}
		}
		return result;
	}
	
	public static BigInteger multiply(BigInteger x, BigInteger exp){
		return null;
	}
}
