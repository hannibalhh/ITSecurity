package Aufgabe2Diffie;

import java.math.BigInteger;
import static Aufgabe2Diffie.MathUtil.modPow;


public class Bob {

	private BigInteger n;
	private BigInteger g;
	
	private final BigInteger y;
	private BigInteger Kab;
	
	private Bob(BigInteger y){
		this.y = y;
	}
	
	public static Bob create(BigInteger y){
		return new Bob(y);
	}
	
	public BigInteger n(){
		return n;
	}
	
	public BigInteger g(){
		return g;
	}
	
	public BigInteger y(){
		return y;
	}
	
	public BigInteger Kab(){
		return Kab;
	}
	
	public void sendN(BigInteger n){
		this.n = n;
	}
	
	public void sendG(BigInteger g){
		this.g = g;
	}
	
	public BigInteger GyMODn(BigInteger GxMODn){
		// Kab = (g hoch xy) mod n berechnen
//		Kab = GxMODn.modPow(y, n);
		Kab = modPow(GxMODn,y, n);
		return g.modPow(y, n);
	}
	
	@Override
	public String toString() {
		return "Bob  (n=" + n() + ", g=" + g() + ", y=" + y + ", Kab=" + Kab + ")";
	}
	
	public boolean isBundledWith(Alice alice){
		return this.Kab().equals(alice.Kab());
	}
	
	
}
