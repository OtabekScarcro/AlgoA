package main;

public class TestStockMediator {
	public static void main(String[] args) {
		
		StockMediator nyse = new StockMediator();
		
		GormanSlacks broker = new GormanSlacks(nyse);
		JTPoorman broker2 = new JTPoorman(nyse);
		
		broker.saleOffer("MSFT", 100000);
		broker.saleOffer("Goog", 50);
		
		broker2.saleOffer("MSFT", 100000);
		broker2.saleOffer("NRG", 10);
		
		broker.buyOffer("NRG", 10);
			
		nyse.getStockOfferings();
		
	}
}
