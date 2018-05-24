package troubleShootSearch.visitors;

import troubleShootSearch.products.Product1;
import troubleShootSearch.products.Product2;
import troubleShootSearch.products.Product3;
import troubleShootSearch.products.Product4;
import troubleShootSearch.products.Products;

public interface Visitor {
	public void visit(Product1 product1);
	public void visit(Product2 product2);
	public void visit(Product3 product3);
	public void visit(Product4 product4);
	public void visit(Products products);
}
