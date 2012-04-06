package StringWriter;

import StringWriter.Implementation.MyFileSystem;
import StringWriter.Interface.FileSystem;

public final class w {

	public static FileSystem file(String path){
		return MyFileSystem.valueOf(path);
	}
}
