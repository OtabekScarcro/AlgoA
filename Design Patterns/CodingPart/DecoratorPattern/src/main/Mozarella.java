package main;

public class Mozarella extends ToppingDecorator{

	public Mozarella(Pizza newPizza) {
		super(newPizza);

		System.out.println("Adding Dough");
		
		System.out.println("Adding Moz");
		
	}
	
	@Override
	public String getDescription() {
		return tempPizza.getDescription() + ", Mozarella";
	}

	@Override
	public double getCost() {
		return tempPizza.getCost() + .50;
	}
	
}
