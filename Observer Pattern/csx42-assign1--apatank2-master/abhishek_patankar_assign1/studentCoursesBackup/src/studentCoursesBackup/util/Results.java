package studentCoursesBackup.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Results implements FileDisplayInterface,StdoutDisplayInterface{
public List<String> Line = new ArrayList<String>();
/**
 * Constructor
 */
public Results(){};
/**
 * Write the final courses registered for each Bnumber 
 * into Output File.
 */
public void FileWriter(String Filename) throws IOException {
	// TODO Auto-generated method stub
	try
	{
	File foutput = new File(Filename);
	FileOutputStream fostream = new FileOutputStream(foutput);
 
	BufferedWriter bwriter = new BufferedWriter(new OutputStreamWriter(fostream));
	for (int i = 0; i < Line.size(); i++) {
		 bwriter.write(Line.get(i));
		 bwriter.newLine();
	}
	bwriter.close();
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
	finally
	{
	}
	}
/**
 * Print the Results on Console
 */
public void PrintOnConsole()
{
	for (int i = 0; i < Line.size(); i++) {
		 System.out.println(Line.get(i));
	}
}
		
}

