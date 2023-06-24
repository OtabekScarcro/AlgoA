package main;

public interface Mediator {
	public void saleOffer(String stocks, int shares, int collCode);
	public void buyOffer(String stocks, int shares, int collCode);
	public void addColleague(Colleague colleague);
}
