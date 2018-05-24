package troubleShootSearch.products;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import troubleShootSearch.util.DebugLevel;
import troubleShootSearch.util.FileDisplayInterface;
import troubleShootSearch.util.Logger;
import troubleShootSearch.util.dSeaGateProducts;
import troubleShootSearch.visitors.Visitor;

public class Product2 implements dSeaGateProductI {

	public ArrayList<String> SeaGate_P2 = new ArrayList<String>();
	public String line;
	
	public Product2(FileDisplayInterface FileDisplay) throws FileNotFoundException
	{
		Logger.writeMessage("Inside Product2 Construtor", DebugLevel.CONSTRUCTOR);
		FileDisplay.ProcessFile(dSeaGateProducts.SeaGate_STEL6000200.toString()+".txt");
		Logger.writeMessage("Initiated ArrayList of Product 2 by "+dSeaGateProducts.SeaGate_STEL6000200.toString()+".txt", DebugLevel.FLOW);
		while ((line = FileDisplay.FileReader())!= null)
			SeaGate_P2.add(line);
	}
	
	

	@Override
	public void accept(Visitor visitor, String lineIn) {
		// TODO Auto-generated method stub
		line = lineIn;
		visitor.visit(this);
	}

}
