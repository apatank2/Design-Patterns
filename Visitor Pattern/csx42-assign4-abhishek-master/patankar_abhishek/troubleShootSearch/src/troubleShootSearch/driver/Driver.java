package troubleShootSearch.driver;

import java.io.FileNotFoundException;

import troubleShootSearch.products.Products;
import troubleShootSearch.products.dSeaGateProductI;
import troubleShootSearch.util.DebugLevel;
import troubleShootSearch.util.FileDisplayI;
import troubleShootSearch.util.FileDisplayInterface;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.Results;
import troubleShootSearch.visitors.Visitor;
import troubleShootSearch.visitors.dSeaGateVisitor;
import troubleShootSearch.util.Logger;

/**
 * Driver --- program to implement vistor pattern.
 */
public class Driver {
	private FileDisplayI fileDisplay;
	public Driver()
	{
		fileDisplay = new Results();
	}
	
	/**
	   * Entry point
	   * @param args string array containing the command line arguments.
	   * @return No return value.
	   */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		try
		{
			Driver driver = new Driver();
			driver.validateArguments(args);
			String InputFileName = "userInputs.txt";
                          Logger.setDebugValue(Integer.parseInt(args[0]));
		FileDisplayInterface File = new FileProcessor(InputFileName);
		dSeaGateProductI SeaGate = new Products(File);
		Visitor visitor = new dSeaGateVisitor();
		SeaGate.accept(visitor, null);
		//System.out.println(Logger.writer);
		
		driver.writeToFIle(Logger.writer);
		}
		catch(Exception ex)
		{

			Logger.writeMessage("file not found", DebugLevel.ERROR);
			System.exit(0);
		}
		finally
		{
			
		}
	}
	
	private void validateArguments(String[] args)
	{
		if (args.length != 1 || args[0].equals("${arg0}")) {
			//Logger.writeMessage("Error: Incorrect number of arguments. Program accepts 1 argumnets.", DebugLevel.ERROR);
			System.err.println("Error: Incorrect number of arguments. Program accepts 1 argumnets.");
			System.exit(0);
		}
	}
	
	 public void writeToFIle(String text)
	 {
		 fileDisplay.write(text, "output.txt");
	 }

}
