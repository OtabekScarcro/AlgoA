package main;

public class VisitorTest {

	public static void main(String[] args) {
		TaxVisitor taxCalc = new TaxVisitor();
		TaxHolidayVisitor taxHolidayCalc = new TaxHolidayVisitor();
		Necessity milk = new Necessity(3.47);
		Liquor vodka = new Liquor(11.99);
		Tobacco sigars = new Tobacco(19.99);
		
		System.out.println(milk.accept(taxCalc) + "\n");
		System.out.println(vodka.accept(taxCalc) + "\n");
		System.out.println(sigars.accept(taxCalc) + "\n");
		
		System.out.println("TAX HOLIDAY PRICES\n");
		
		System.out.println(milk.accept(taxHolidayCalc) + "\n");
		System.out.println(vodka.accept(taxHolidayCalc) + "\n");
		System.out.println(sigars.accept(taxHolidayCalc) + "\n");
	}

}
