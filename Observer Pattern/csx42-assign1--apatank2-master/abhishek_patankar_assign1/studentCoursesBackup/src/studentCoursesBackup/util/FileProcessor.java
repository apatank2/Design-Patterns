package studentCoursesBackup.util;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;

public class FileProcessor
{
	public File file1;
	public FileReader filereader;
	public BufferedReader bufferreader;
	/**
	 * Constructor
	 * @param file
	 * @throws FileNotFoundException
	 */
	public FileProcessor (String file) throws FileNotFoundException
	{
	file1 = new File(file);
	filereader = new FileReader(file1);
	bufferreader = new BufferedReader(filereader);
    };
/**
 * Read the file line by line and return
 * @return
 */
public String FileReader()
{

	String CurrentLine = null;

try {

	CurrentLine = bufferreader.readLine();
	
	} 
	catch(FileNotFoundException fnotfound)
	{
		System.out.println("FileNotFoundException : "+fnotfound.getMessage());
		System.exit(0);
	}
	catch(Exception e)
	{
		System.out.println("Exception occured: "+e.getMessage());
		System.exit(0);
	} 
   finally {

		

	}
return CurrentLine;
	}


}
