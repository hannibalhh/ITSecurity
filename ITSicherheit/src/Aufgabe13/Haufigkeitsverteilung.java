package Aufgabe13;

import Aufgabe12.TextAnalyse;

public class Haufigkeitsverteilung {

	public static void main(String args[]){
		String path[] = new String[4];
		path[0] = "src/Aufgabe13/CaesarCrypted[22]";
		path[1] = "src/Aufgabe13/CaesarCrypted[89]";
		path[2] = "src/Aufgabe13/SkytaleHighCrypted[78]";
		path[3] = "src/Aufgabe13/SkytaleHighCrypted[99]";
		TextAnalyse.main(path);
	}
}
