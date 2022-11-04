package it.polito.oop.constants;

public class CrazyConstants {
	public final static double GARGLE = 8.2;
	public final static int THE_ANSWER = 42;
	public final static long ZAP;
	
	static {
		ZAP = System.currentTimeMillis();
	}
}
