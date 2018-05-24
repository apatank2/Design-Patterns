package troubleShootSearch.products;


import troubleShootSearch.visitors.Visitor;

public interface dSeaGateProductI {
  public void accept(Visitor visitor, String line);
}
