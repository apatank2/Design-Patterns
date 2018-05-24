package troubleShootSearch.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessor implements FileDisplayInterface {
	public File file1;
	public FileReader filereader;
	public BufferedReader bufferreader;
	/**
	 * Constructor
	 * @param file
	 * @throws FileNotFoundException
	 */
	public FileProcessor () 
	{
	
    };
    public FileProcessor (String FileIn) throws FileNotFoundException
	{
    	Logger.writeMessage("Inside FileProcessor Construtor", DebugLevel.CONSTRUCTOR);
    	file1 = new File(FileIn);
    	filereader = new FileReader(file1);
    	bufferreader = new BufferedReader(filereader);
    };
   /**
    * Read the file line by line and return
    * @return
    */
    public void ProcessFile(String FileIn) throws FileNotFoundException
    {
    	file1 = new File(FileIn);
    	filereader = new FileReader(file1);
    	bufferreader = new BufferedReader(filereader);
    }
    public String FileReader()
    {

	String CurrentLine = null;

    try {

	CurrentLine = bufferreader.readLine();
	
	} 
	catch(FileNotFoundException fnotfound)
	{
		Logger.writeMessage("FileNotFoundException", DebugLevel.ERROR);
		System.exit(0);
	}
	catch(Exception e)
	{
		Logger.writeMessage("Exception occured", DebugLevel.ERROR);
		System.exit(0);
	} 
   finally {

		

	}
return CurrentLine;
	}
public void FileWriter(String content, String FilenameIn)  {
	// TODO Auto-generated method stub
	try
	{
		BufferedWriter writer = new BufferedWriter(new FileWriter(FilenameIn));
	    writer.write(content);
	    writer.close();
	}
	catch(IOException e)
	{
		System.out.println(e.toString());
		System.exit(0);
	}
	finally
	{
		
	}
}
}
