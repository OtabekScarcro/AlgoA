package main;

public class SampleClass {
	
	public SampleClass() {}

	public SampleClass(String str, int num) {
		System.out.println("You send : " + str + " and " + num);
	}
	
	private String name = "Otabek";
	private String surname = "Otabaev";
	private int age = 18;
	
	void getInfo() {
		System.out.println("My name is " + this.name);
		System.out.println("My surename is " + this.surname);
		System.out.println("My age is " + this.age);
	}
	
	private void setInfo(String name, String surname, int age) {
		this.name = name;
		this.surname = surname;
		this.age = age;
	}

	public String getName() {
		return this.name;
	}
	
	
}
