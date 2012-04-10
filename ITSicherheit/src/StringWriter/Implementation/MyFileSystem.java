package StringWriter.Implementation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import StringWriter.Interface.FileSystem;

public class MyFileSystem implements FileSystem {

	final private String path;
	final private BufferedWriter out;

	final public static FileSystem NaFS = new MyFileSystem(null, "");

	private MyFileSystem(BufferedWriter out, String path) {
		this.path = path;
		this.out = out;
	}

	public static FileSystem valueOf(String path) {
		try {
			File f = new File(path);
			if (!f.exists()) {
				f.createNewFile();
			}
			if (!f.canWrite()) {
				System.out.println("Datei nicht beschreibbar " + path);
				return NaFS;
			}
			if (!f.isFile()) {
				System.out.println("Keine Datei " + path);
				return NaFS;
			}			
			OutputStream fis = new FileOutputStream(path);
	        Writer isr = new OutputStreamWriter(fis, "8859_1");
	        
			BufferedWriter out = new BufferedWriter(isr);
			return new MyFileSystem(out, path);
		} catch (Exception e) {
			System.out.println("Exception " + e.getMessage());
			return NaFS;
		}
	}
	
	@Override
	public boolean isNaFS() {
		return this == NaFS;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this.isNaFS())
			return false;
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileSystem other = (FileSystem) obj;
		if (path == null) {
			if (other.path() != null)
				return false;
		} else if (!path.equals(other.path()))
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		if (isNaFS())
			return "Persistence(WrongFilesystem)";
		else
			return "Persistence(FileSystem to " + path + ")";
	}

	protected void finalize() {
		if (isNaFS())
			return;
		try {
			out.close();
		} catch (IOException e) {
		}
	}

	@Override
	public String path() {
		return path;
	}

	@Override
	public void close() {
		if (isNaFS())
			return;
		finalize();
	}

	@Override
	public boolean concatLine(String data) {
		return concat(data + "\n");
	}

	@Override
	public boolean concat(String data) {
		if (isNaFS())
			return false;
		try {
			
			out.flush();
			out.append(data);
			System.out.println(data);
			return true;
		} catch (IOException e) {
			System.out.println("IO Exceptopn");
			return false;
		}
	}

	@Override
	public boolean write(String text) {
		if (isNaFS())
			return false;
		try {			
			out.flush();
			out.write(text);
			close();
			return true;
		} catch (IOException e) {
			System.out.println("IO Exceptopn");
			return false;
		}
	}
	
}
