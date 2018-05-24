package studentCoursesBackup.driver;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import studentCoursesBackup.util.FileDisplayInterface;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.TreeBuilder;
import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.myTree.Operations;
import studentCoursesBackup.util.Results;
/**
* The studentCoursesBackup program implements an Observer Pattern
* @author  Abhishek Patankar
* @version 1.0
* @since   2018-02-06
*/
public class Driver {


		private static BufferedReader bufferreader;
		/**
		 * @param args
		 * @throws IOException
		 */
		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			CommandLineValidation(args);
			String Line;
			 try
		        {
				 TreeBuilder BSTTree = new TreeBuilder();
				 TreeBuilder Backup1 = new TreeBuilder();
				 TreeBuilder Backup2 = new TreeBuilder();
				 FileProcessor FIProcessor = new FileProcessor(args[0]);
				 if (!isfileempty(args[0]))
				 {
				 while ((Line = FIProcessor.FileReader() ) != null) {
					 
					 if (!BSTTree.FindNode(bno(Line)))
					 {
					 Node node = new Node(bno(Line),Course(Line));
					 Node b1 = new Node(bno(Line),Course(Line));
					 Node b2 = new Node(bno(Line),Course(Line));
					 BSTTree.InsertBST(node, bno(Line), Course(Line));
					 Backup1.InsertBST(b1, bno(Line), Course(Line));
					 Backup2.InsertBST(b2, bno(Line), Course(Line));
					 node.RegisterObserver(b1);
					 node.RegisterObserver(b2);
					 }else{
					 BSTTree.UpdateTree(bno(Line),Course(Line),Operations.INSERT); 
					 }
				 }
				 }
				 FileProcessor FDProcessor = new FileProcessor(args[1]);
				 if (!isfileempty(args[1]))
				 {
				 while ((Line = FDProcessor.FileReader() ) != null) {
					 if (BSTTree.FindNode(bno(Line)))
					 {
				     BSTTree.UpdateTree(bno(Line), Course(Line), Operations.UPDATE);
					 }
				 }
				 
		        }
				 FileDisplayInterface Tree = new Results();
				 FileDisplayInterface bTree1 = new Results();
				 FileDisplayInterface bTree2 = new Results();
				 BSTTree.printNode(Tree);
				 Backup1.printNode(bTree1);
				 Backup2.printNode(bTree2);
				 Tree.FileWriter(args[2]);
				 bTree1.FileWriter(args[3]);
				 bTree2.FileWriter(args[4]);
				 System.out.println("Successfully Executed");
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
		
		public static String Course(String Line)
		{
			String Ignore = "[:]";
			String[] tokens = Line.split(Ignore);
			return tokens[1];
		}
		public static int bno(String Line)
		{
			String Ignore = "[:]";
			String[] tokens = Line.split(Ignore);
			int bnumber = Integer.parseInt(tokens[0]);
		    return bnumber;
		}
		public static boolean isfileempty(String file) throws IOException
		{
			File file1 = new File(file);
			FileReader filereader = new FileReader(file1);
			bufferreader = new BufferedReader(filereader);
			if (bufferreader.readLine() == null)
			return true;
			else
			return false;
		}
		public static void CommandLineValidation (String[] args)
		{
			if (args.length != 5 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")
			|| args[3].equals("${arg3}") || args[4].equals("${arg4}")) {

		    System.err.println("Error: Incorrect number of arguments. Program accepts 5 arguments.");
		    System.exit(0);
	        }
		}

}
