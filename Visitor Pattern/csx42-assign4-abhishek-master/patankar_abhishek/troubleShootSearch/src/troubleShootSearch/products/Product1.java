package troubleShootSearch.products;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import troubleShootSearch.util.DebugLevel;
import troubleShootSearch.util.FileDisplayInterface;
import troubleShootSearch.util.Logger;
import troubleShootSearch.visitors.Visitor;
import troubleShootSearch.util.dSeaGateProducts;

public class Product1 implements dSeaGateProductI {
	public ArrayList<String> SeaGate_P1 = new ArrayList<String>();
	public String line = null;
	
	public Product1(FileDisplayInterface FileDisplay) throws FileNotFoundException
	{
		Logger.writeMessage("Inside Product1 Construtor", DebugLevel.CONSTRUCTOR);
		FileDisplay.ProcessFile(dSeaGateProducts.SeaGate_STEL6000100.toString()+".txt");
		Logger.writeMessage("Initiated ArrayList of Product 1 by "+dSeaGateProducts.SeaGate_STEL6000100.toString()+".txt", DebugLevel.FLOW);
		while ((line = FileDisplay.FileReader())!= null)
			SeaGate_P1.add(line);
	}
	

	@Override
	public void accept(Visitor visitor, String lineIn) {
		// TODO Auto-generated method stub
		line = lineIn;
		visitor.visit(this);
	}

}
