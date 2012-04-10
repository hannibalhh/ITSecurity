package Aufgabe13;

import Aufgabe12.TextAnalyse;

public class Haufigkeitsverteilung {

	public static void main(String args[]){
		amountOfPlaintext();
		amountOfCrypted();
	}
	
	public static void amountOfPlaintext(){
		String path[] = new String[2];
		path[0] = "src/Aufgabe12/kafka-strafkolonie01.txt";
		path[1] = "src/Aufgabe13/kafkaAmount";
		TextAnalyse.main(path);
	}
	
	public static void amountOfCrypted(){
		String path[] = new String[2];
		path[0] = "src/Aufgabe13/CaesarCrypted[22]";
		path[1] = "src/Aufgabe13/CaesarCryptedAmounts[22]";
		TextAnalyse.main(path);
		path[0] = "src/Aufgabe13/CaesarCrypted[89]";
		path[1] = "src/Aufgabe13/CaesarCryptedAmounts[89]";
		TextAnalyse.main(path);
		path[0] = "src/Aufgabe13/SkytaleHighCrypted[78]";
		path[1] = "src/Aufgabe13/SkytaleHighCryptedAmounts[78]";
		TextAnalyse.main(path);
		path[0] = "src/Aufgabe13/SkytaleHighCrypted[99]";
		path[1] = "src/Aufgabe13/SkytaleHighCryptedAmounts[99]";
		TextAnalyse.main(path);
		path[0] = "src/Aufgabe13/SkytaleLowCrypted[78]";
		path[1] = "src/Aufgabe13/SkytaleLowCryptedAmounts[78]";
		TextAnalyse.main(path);
		path[0] = "src/Aufgabe13/SkytaleLowCrypted[99]";
		path[1] = "src/Aufgabe13/SkytaleLowCryptedAmounts[99]";
		TextAnalyse.main(path);
	}
	
	
//	public static void main(String args[]){
//		String path[] = new String[4];
//		path[0] = "src/Aufgabe13/CaesarCrypted[22]";
//		path[1] = "src/Aufgabe13/CaesarCrypted[89]";
//		path[2] = "src/Aufgabe13/SkytaleHighCrypted[78]";
//		path[3] = "src/Aufgabe13/SkytaleHighCrypted[99]";
//		TextAnalyse.main(path);
//	}
}
