package troubleShootSearch.util;

import java.io.FileNotFoundException;

public interface FileDisplayInterface {
	/**
	 * Write a String to a specified file
	 * @param Filename
	 */
	public void FileWriter(String content, String FilenameIn);
	public void ProcessFile(String FileIn) throws FileNotFoundException;
	public String FileReader();
}
