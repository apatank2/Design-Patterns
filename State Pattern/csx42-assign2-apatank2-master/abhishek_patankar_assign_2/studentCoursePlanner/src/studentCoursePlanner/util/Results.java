package studentCoursePlanner.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import studentCoursePlanner.util.FileDisplayInterface;
import studentCoursePlanner.util.StdoutDisplayInterface;

public class Results implements FileDisplayInterface,StdoutDisplayInterface {
	public List<String> Courses = new ArrayList<String>();
	/**
	 * Constructor
	 */
	public Results(){};
	/**
	 * Write the result to Output File.
	 * @param Filename
	 */
	public void FileWriter(String FilenameIn) throws IOException {
		// TODO Auto-generated method stub
		try
		{
		File foutput = new File(FilenameIn);
		FileOutputStream fostream = new FileOutputStream(foutput);
	 
		BufferedWriter bwriter = new BufferedWriter(new OutputStreamWriter(fostream));
		for (int i = 0; i < Courses.size(); i++) {
			 bwriter.write(Courses.get(i));
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
	 *  Test the results for specified file
	 */
	public void PrintOnConsole()
	{
		for (int i = 0; i < Courses.size(); i++) {
			 System.out.println(Courses.get(i));
		}
	}
}
