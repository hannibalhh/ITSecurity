package CharReader;

import CharReader.Implementation.BufferedCharReader;
import CharReader.Implementation.EasyCharReader;
import CharReader.Interface.CharReader;

final public class r {

	public static CharReader file(String path){
		return BufferedCharReader.create(path);
	}
	
	public static CharReader string(String str){
		return EasyCharReader.create(str);
	}
	
	public static byte[] fileToByteArray(String path){
		return BufferedCharReader.create(path).toString().getBytes();
	}
}
