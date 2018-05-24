package troubleShootSearch.products;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import troubleShootSearch.products.dSeaGateProductI;
import troubleShootSearch.util.DebugLevel;
import troubleShootSearch.util.FileDisplayInterface;
import troubleShootSearch.util.Logger;
import troubleShootSearch.util.dSeaGateProducts;
import troubleShootSearch.visitors.Visitor;

public class Product4 implements dSeaGateProductI {

	public ArrayList<String> SeaGate_P4 = new ArrayList<String>();
	public String line = null;
	
	public Product4(FileDisplayInterface FileDisplay) throws FileNotFoundException
	{
		Logger.writeMessage("Inside Product4 Construtor", DebugLevel.CONSTRUCTOR);
		FileDisplay.ProcessFile(dSeaGateProducts.SeaGate_STEL6000400.toString()+".txt");
		Logger.writeMessage("Initiated ArrayList of Product 4 by "+dSeaGateProducts.SeaGate_STEL6000400.toString()+".txt", DebugLevel.FLOW);
		while ((line = FileDisplay.FileReader())!= null)
			SeaGate_P4.add(line);
	}
	

	@Override
	public void accept(Visitor visitor, String lineIn) {
		// TODO Auto-generated method stub
		line = lineIn;
		visitor.visit(this);
	}


}
