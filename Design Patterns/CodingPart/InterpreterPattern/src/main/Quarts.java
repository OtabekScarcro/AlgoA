package main;

public class Quarts extends Expression{

	
	public String gallons(double quantity) {
		// TODO Auto-generated method stub
		return Double.toString(quantity / 4);
	}

	
	public String quarts(double quantity) {
		return Double.toString(quantity);
	}

	
	public String pints(double quantity) {
		return Double.toString(quantity * 4);
	}

	public String cups(double quantity) {
		return Double.toString(quantity * 8);
	}

	
	public String tablespoons(double quantity) {
		return Double.toString(quantity * 256);
	}

}
