package CharReader;

final public class r {

	public static CharReader file(String path){
		return BufferedCharReader.create(path);
	}
	
	public static CharReader string(String str){
		return EasyCharReader.create(str);
	}
}
