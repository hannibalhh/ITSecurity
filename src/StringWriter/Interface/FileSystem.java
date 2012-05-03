package StringWriter.Interface;

/**
 * FileSystem provides to write text in file
 * @author Sigurd Sippel
 */
public interface FileSystem {

	/**
	 * Close writing, file can used otherwise
	 */
	void close();
	
	/**
	 * @param text to write at the end of file 
	 * @return Success
	 */
	boolean concat(String text);
	
	/**
	 * @param text to write on file and close the file after that
	 * @return Success
	 */
	boolean write(String text);
	
	/**
	 * @param text to write at the end of file with new line
	 * @return Success
	 */
	boolean concatLine(String text);
	
	/**
	 * @return whether FileSystem is valid (path could noch valid or system error, usser priviles error)
	 */
	boolean isNaFS();
	
	/**
	 * @return defined pathm of file
	 */
	String path();
}
