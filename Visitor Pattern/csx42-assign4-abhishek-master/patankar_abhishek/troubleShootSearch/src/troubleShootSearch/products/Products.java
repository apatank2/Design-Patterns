package troubleShootSearch.products;

import java.io.FileNotFoundException;

import troubleShootSearch.products.dSeaGateProductI;
import troubleShootSearch.util.DebugLevel;
import troubleShootSearch.util.FileDisplayInterface;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.Logger;
import troubleShootSearch.visitors.Visitor;

/**
 * Products --- to call individual products
 */
public class Products implements dSeaGateProductI {

	public FileDisplayInterface fdi;
    private dSeaGateProductI[] productItems;
    FileDisplayInterface fileDisplay; 
    private String line;
    
    /**
	   * Constructor: instantiate productItem
	   * @param FileDisplayInterface: to process input file
	   * @return No return value.
	   */
    public Products(FileDisplayInterface fi) throws FileNotFoundException
    {
    	Logger.writeMessage("Inside Products Construtor", DebugLevel.CONSTRUCTOR);
    	this.fdi = fi;
    	fileDisplay = new FileProcessor();
    	Logger.writeMessage("Initiated Products", DebugLevel.FLOW);
    	productItems = new dSeaGateProductI[] {new Product1(fileDisplay), new Product2(fileDisplay), new Product3(fileDisplay), new Product4(fileDisplay)};
    }
	
    /**
	   * accept: to call accept of each product
	   * @param FileDisplayInterface: to process input file
	   * @return No return value.
	   */
	@Override
	public void accept(Visitor visitor, String lineL) {
		// TODO Auto-generated method stub
		visitor.visit(this);
		Logger.writeMessage("For Each Search Visiting Exact Match, Naive Match and Semantic Match for all 4 Products One By One", DebugLevel.FLOW);
		while ((line = fdi.FileReader())!= null)
		{
			for (int i = 0; i < productItems.length; i++) {
				productItems[i].accept(visitor, line);
		      }
		}
	}
}
