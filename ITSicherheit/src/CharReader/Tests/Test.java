package CharReader.Tests;

import CharReader.r;
import CharReader.Interface.CharReader;

public class Test {

	public static void main(String args[]){
		file();
	}
	
	public static void file(){
		CharReader c = r.file("src/CharReader/Tests/Test");
		System.out.println(c.isNaC());
		while (c.hasNext()){
			System.out.print(c.next());
		}		
	}
	
	public static void string(){
		CharReader c = r.string("src/CharReader/Tests/Test");
		System.out.println(c.isNaC());
		while (c.hasNext()){
			System.out.print(c.next());
		}	
	}
}
