package troubleShootSearch.products;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import troubleShootSearch.products.dSeaGateProductI;
import troubleShootSearch.util.DebugLevel;
import troubleShootSearch.util.FileDisplayInterface;
import troubleShootSearch.util.Logger;
import troubleShootSearch.util.dSeaGateProducts;
import troubleShootSearch.visitors.Visitor;

public class Product3 implements dSeaGateProductI {

	public ArrayList<String> SeaGate_P3 = new ArrayList<String>();
	public String line = null;
	
	public Product3(FileDisplayInterface FileDisplay) throws FileNotFoundException
	{
		Logger.writeMessage("Inside Product3 Construtor", DebugLevel.CONSTRUCTOR);
		FileDisplay.ProcessFile(dSeaGateProducts.SeaGate_STEL6000300.toString()+".txt");
		Logger.writeMessage("Initiated ArrayList of Product 3 by "+dSeaGateProducts.SeaGate_STEL6000300.toString()+".txt", DebugLevel.FLOW);
		while ((line = FileDisplay.FileReader())!= null)
			SeaGate_P3.add(line);
	}
	
	

	@Override
	public void accept(Visitor visitor, String lineIn) {
		// TODO Auto-generated method stub
		line = lineIn;
		visitor.visit(this);
	}

}
