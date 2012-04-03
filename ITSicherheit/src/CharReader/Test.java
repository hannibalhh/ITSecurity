package CharReader;

public class Test {

	public static void main(String args[]){
		string();
	}
	
	public static void file(){
		CharReader c = r.file("src/CharReader/Test");
		System.out.println(c.isNaC());
		while (c.hasNext()){
			System.out.print(c.next());
		}		
	}
	
	public static void string(){
		CharReader c = r.string("src/CharReader/Test");
		System.out.println(c.isNaC());
		while (c.hasNext()){
			System.out.print(c.next());
		}	
	}
}
