package studentCoursePlanner.driver;


import java.io.IOException;

import studentCoursePlanner.state.CourseAllocation;
import studentCoursePlanner.util.FileProcessor;
import studentCoursePlanner.util.Results;
/**
* The studentCoursePlanner program implements an State Pattern
* @author  Abhishek Patankar
* @version 1.0
* @since   2018-03-04
*/
public class Driver {
	/**
	 * @param args :- Takes in Input and Output File
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try
		{
		if (args.length != 2 || args[0].equals("${arg0}") || args[1].equals("${arg1}")) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 2 arguments.");
		    System.exit(0);
		}
		FileProcessor FIProcessor = new FileProcessor(args[0]);
		String Line;
		while ((Line = FIProcessor.FileReader() ) != null) {
			Results results = new Results();
			CourseAllocation Course = new CourseAllocation();
			Course.AssignCourse(Line);
			Course.PrintResult(results); 
			results.FileWriter(args[1]);
		}
		System.out.println("Successfully Executed");
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
	
}
