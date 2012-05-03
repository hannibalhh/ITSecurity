package StringWriter.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import StringWriter.Persistence;
import StringWriter.Interface.FileSystem;

public class MyFileSystemTest {

	@Test
	public void testCreate() {
		String path =  "src/Persistence/Test/blub22.txt";
		FileSystem f = Persistence.file(path);
		assertEquals(false,f.isNaFS());
		assertEquals(path,f.path());

		assertEquals(f,f);
		FileSystem f2 = Persistence.file(path);
		assertEquals(f,f2);
	}
	
	@Test
	public void testCreateIvalid() {
		String path1 = "";
		String path2 = System.getProperty("user.home") + "";
		FileSystem f1 = Persistence.file(path1);
		FileSystem f2 = Persistence.file(path2);
		assertEquals(true,f1.isNaFS());
		assertEquals(true,f2.isNaFS());
		assertEquals(false,f1.equals(f1));
		
		String path3 = System.getProperty("user.home") + "/blub22.txt";
		FileSystem f3 = Persistence.file(path3);
		assertEquals(false,f3.equals(f1));
	}
	
	@Test
	public void testReadable() {
		FileSystem f = Persistence.file(System.getProperty("user.home") + "/blub22.txt");
		System.out.println(f);
		for(int i=0;i<10;i++){
			System.out.println(f.concatLine("blub22" +i));
		}
		
		System.out.println("Test needed: Cant test 'write to file' because a read function is not implemented");

	}

}
