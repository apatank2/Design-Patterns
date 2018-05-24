package troubleShootSearch.visitors;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import troubleShootSearch.products.Product1;
import troubleShootSearch.products.Product2;
import troubleShootSearch.products.Product3;
import troubleShootSearch.products.Product4;
import troubleShootSearch.products.Products;
import troubleShootSearch.util.DebugLevel;
import troubleShootSearch.util.FileDisplayInterface;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.Logger;
import troubleShootSearch.util.dSeaGateProducts;

public class dSeaGateVisitor implements Visitor {

	private Product1 product1;
	private Product2 product2;
	private Product3 product3;
	private Product4 product4;
	private ArrayList<Integer> Duplicate_Search = new ArrayList<Integer>();
	public FileDisplayInterface fileDisplay;
	String Synonyms = "synonym.txt";
	Map<String, String> Synonym = new HashMap<String,String>();
	String line = null;
	public dSeaGateVisitor() 
	{
		Logger.writeMessage("Inside Visitor Construtor", DebugLevel.CONSTRUCTOR);
	}
	
	@Override
	public void visit(Product1 product1In) {
		// TODO Auto-generated method stub
		
		product1 = product1In;
		Logger.writeMessage("Keyword : " + product1.line, DebugLevel.SEARCHRESULT);
		Logger.writeMessage("Search Results : ", DebugLevel.SEARCHRESULT);
		ExactMatch(product1.line,dSeaGateProducts.SeaGate_STEL6000100,product1.SeaGate_P1);
		NaiveMatch(product1.line,dSeaGateProducts.SeaGate_STEL6000100,product1.SeaGate_P1);
		SemanticMatch(product1.line,dSeaGateProducts.SeaGate_STEL6000100,product1.SeaGate_P1);
	}

	@Override
	public void visit(Product2 product2In) {
		// TODO Auto-generated method stub
		product2 = product2In;
		ExactMatch(product2.line,dSeaGateProducts.SeaGate_STEL6000200,product2.SeaGate_P2);
		NaiveMatch(product2.line,dSeaGateProducts.SeaGate_STEL6000200,product2.SeaGate_P2);
		SemanticMatch(product2.line,dSeaGateProducts.SeaGate_STEL6000200,product2.SeaGate_P2);
	}

	@Override
	public void visit(Product3 product3In) {
		// TODO Auto-generated method stub
		product3 = product3In;
		ExactMatch(product3.line,dSeaGateProducts.SeaGate_STEL6000300,product3.SeaGate_P3);
		NaiveMatch(product3.line,dSeaGateProducts.SeaGate_STEL6000300,product3.SeaGate_P3);
		SemanticMatch(product3.line,dSeaGateProducts.SeaGate_STEL6000300,product3.SeaGate_P3);
	}

	@Override
	public void visit(Product4 product4In) {
		// TODO Auto-generated method stub
		product4 = product4In;
		ExactMatch(product4.line,dSeaGateProducts.SeaGate_STEL6000400,product4.SeaGate_P4);
		NaiveMatch(product4.line,dSeaGateProducts.SeaGate_STEL6000400,product4.SeaGate_P4);
		SemanticMatch(product4.line,dSeaGateProducts.SeaGate_STEL6000400,product4.SeaGate_P4);
	}
	
	public void ExactMatch(String keyword,dSeaGateProducts ProductName,ArrayList<String> Product)
	{
		String pattern = "\\b"+keyword+"\\b";
        Pattern p=Pattern.compile(pattern);
        for (int i = 0; i < Product.size(); i++) {
        	Matcher m=p.matcher(Product.get(i));
            if (m.find())
            {
            	/*System.out.println("Exact Match is :");
            	System.out.println(SeaGate_P1.get(i));*/
            	//Logger.writeMessage("Exact Match is :", DebugLevel.SEARCHRESULT);	
            	Logger.writeMessage(ProductName.toString(), DebugLevel.SEARCHRESULT);
            	Logger.writeMessage(Product.get(i), DebugLevel.SEARCHRESULT);
				Logger.writeMessage(keyword + " found in "+ProductName.toString() + " Product by Exact Match", DebugLevel.PRODUCTNAME);
            	Duplicate_Search.add(i);
            	//return true;
            }
            DuplicateSearch(ProductName);
		}
        
        //return false;
		
	}
	
	public void NaiveMatch(String KeyWords,dSeaGateProducts ProductName,ArrayList<String> Product)
	{
		for (int i = 0; i < Product.size(); i++) {
			String Ignore = "[ ]";
			String[] tokens = KeyWords.split(Ignore);
			if (Product.get(i).contains(tokens[0]))
			{
				//System.out.println("Naive Match is :");
			//System.out.println(SeaGate_P1.get(i));
				//Logger.writeMessage("Naive Match is :", DebugLevel.SEARCHRESULT);	
				Logger.writeMessage(ProductName.toString(), DebugLevel.SEARCHRESULT);
				Logger.writeMessage(Product.get(i), DebugLevel.SEARCHRESULT);
				Logger.writeMessage(KeyWords + " found in "+ProductName.toString() + " Product by Naive Match", DebugLevel.PRODUCTNAME);
			Duplicate_Search.add(i);
			//return true;
			}
		}
		DuplicateSearch(ProductName);
		
		//return false;
	}
	
	public void SemanticMatch(String keyword,dSeaGateProducts ProductName,ArrayList<String> Product)
	{
	String lastWord = keyword.substring(keyword.lastIndexOf(" ")+1);
	for (Object o : Synonym.keySet()) {
		  if (o.toString().equals(lastWord))
		  {
			  
			  
			  String pattern = "\\b"+Synonym.get(o)+"\\b";
		        Pattern p=Pattern.compile(pattern);
		        for (int i = 0; i < Product.size(); i++) {
		        	Matcher m=p.matcher(Product.get(i));
		            if (m.find())
		            {
		            		
		            	Logger.writeMessage(ProductName.toString(), DebugLevel.SEARCHRESULT);
		            	Logger.writeMessage(Product.get(i), DebugLevel.SEARCHRESULT);
		            	Logger.writeMessage(keyword + " found in "+ProductName.toString() + " Product by Semantic Match", DebugLevel.PRODUCTNAME);
		            	Duplicate_Search.add(i);
		            	//return true;
		            }
		            DuplicateSearch(ProductName);}
		  }
		  }
	}
	
	public void DuplicateSearch(dSeaGateProducts ProductName)
	{
		for (int i = 0; i < Duplicate_Search.size(); i++) 
        {
        	 if (dSeaGateProducts.SeaGate_STEL6000100 == ProductName)
        		 product1.SeaGate_P1.remove(product1.SeaGate_P1.get(Duplicate_Search.get(i)));
        	 if (dSeaGateProducts.SeaGate_STEL6000200 == ProductName)
        		 product2.SeaGate_P2.remove(product2.SeaGate_P2.get(Duplicate_Search.get(i)));
        	 if (dSeaGateProducts.SeaGate_STEL6000300 == ProductName)
        		 product3.SeaGate_P3.remove(product3.SeaGate_P3.get(Duplicate_Search.get(i)));
        	 if (dSeaGateProducts.SeaGate_STEL6000400 == ProductName)
        		 product4.SeaGate_P4.remove(product4.SeaGate_P4.get(Duplicate_Search.get(i)));
        }
        Duplicate_Search.removeAll(Duplicate_Search);
	}

	@Override
	public void visit(Products products) {
		// TODO Auto-generated method stub
		try
		{
			Logger.writeMessage("Initiated Map Data Structure for Storing Synonyms from " + Synonyms, DebugLevel.FLOW);
		fileDisplay = new FileProcessor();
		fileDisplay.ProcessFile(Synonyms);
		while ((line = fileDisplay.FileReader())!= null)
		{
			String Ignore = "[:]";
			String[] tokens = line.split(Ignore);
			Synonym.put(tokens[0], tokens[1]);	
		}
		}
		catch(Exception ex)
		{
			System.out.println("Exception occured while execution");
			System.exit(0);
		}
	}

}
