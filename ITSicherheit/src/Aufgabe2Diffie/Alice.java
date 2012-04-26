package Aufgabe2Diffie;

import java.math.BigInteger;

public class Alice {

	private static final BigPrimeN genN = BigPrimeN.create();
	private static final BigInteger n = genN.next();

	private static final SmallInteger genG = SmallInteger.create(n);
	private static final BigInteger g = genG.next();

	private final BigInteger x;
	private BigInteger Kab;

	private Alice(BigInteger x) {
		this.x = x;
	}

	public static Alice create(BigInteger x) {
		return new Alice(x);
	}

	public void YyxMODn(BigInteger GyMODn) {
		// Kab berechnen mit (y hoch yx) mod n
		Kab = GyMODn.modPow(x, n);
	}

	public BigInteger n() {
		return n;
	}

	public BigInteger g() {
		return g;
	}

	public BigInteger x() {
		return x;
	}

	public BigInteger Kab() {
		return Kab;
	}

	public void init(Bob bob) {
		bob.sendG(g);
		bob.sendN(n);
		YyxMODn(bob.GyMODn(g.modPow(x, n)));
	}

	@Override
	public String toString() {
		return "Alice(n=" + n() + ", g=" + g() + ", x=" + x + ", Kab=" + Kab + ")";
	}

	public boolean isBundledWith(Bob bob) {
		return this.Kab().equals(bob.Kab());
	}

}
