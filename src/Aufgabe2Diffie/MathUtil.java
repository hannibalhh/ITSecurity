package Aufgabe2Diffie;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;

public class MathUtil {

	public static final boolean squareAndMultiply = false;
	
	public static BigInteger squareAndMultiply(BigInteger base, BigInteger exp){
		int bitCounter=0;
		byte[] bytearray=exp.toByteArray();
		BigInteger result=BigInteger.valueOf(1);
		for(byte b:bytearray){		
			ArrayList<Boolean> blubb=new ArrayList<Boolean>();
			
			//change the order of the bits from the specific byte
			for(int j=0;j<8;j++){
				if(exp.bitLength()<=j)
					break;
				boolean h=(b & (1 << j)) > 0;
				blubb.add(0, h);
			}
			
			for(int i=0;i<blubb.size();i++){			
				result=result.pow(2);
				//bits ueberpruefen ob es 1 war
				if (blubb.get(i)) 
					result=result.multiply(base); 				
				bitCounter++;
				if(bitCounter>=exp.bitLength())
					return result;
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
