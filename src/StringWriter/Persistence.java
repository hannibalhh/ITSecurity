package StringWriter;

import StringWriter.Implementation.MyFileSystem;
import StringWriter.Interface.FileSystem;

/**
 * Persistence layer to read and write to persistence unit like file
 * @author Sigurd Sippel
 */
final public class Persistence {
	
	/**
	 * Write to file
	 * @param path The file path (if not exists, it will create; if it exists, it will override)
	 * @return FileSystem to operate
	 */
	public static FileSystem file(String path){
		return MyFileSystem.valueOf(path);
	}
	
	/**
	 * Invalid Write to file
	 * @return InvalidObject with stupid values without exceptions by method call
	 */
	public static FileSystem NaFS(){
		return MyFileSystem.NaFS;
	}

}
