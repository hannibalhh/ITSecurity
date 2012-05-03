package Aufgabe2Diffie;

import java.math.BigInteger;
import java.util.BitSet;

public class MathUtil {

	public static final boolean squareAndMultiply = true;
	
	public static BigInteger squareAndMultiply(BigInteger base, BigInteger exp){
		int bitCounter=0;
		byte[] bytearray=exp.toByteArray();
		BigInteger result=base;
		
		for(byte b:bytearray){						
			for(int i=0;i<8;i++){
				if(bitCounter>=exp.bitLength()-1){
					return result;
				}else{
					bitCounter++;
				}
				result=result.pow(2);
				
				//eine 1 zu der ŸberprŸfenden stelle shiften -> bitweise und --> wenn die herrauskommende zahl groesser 0, 
				//dann wars eine 1 an der i-ten stelle
				boolean h=(b & (1 << i)) > 0;			
//				System.out.println("h: "+h);
				if (h)  
			    {  
					result=result.multiply(base);
			    }  		
//				System.out.println("actual result:"+result.toString());
				
			}
		}
		return result;
	}
	
	public static BigInteger modPow(BigInteger base,BigInteger exp, BigInteger m){
		if (squareAndMultiply)
			return squareAndMultiply(base,exp).mod(m);
		else // standard implementation (delegation)
			return base.modPow(exp, m);
	}
}
