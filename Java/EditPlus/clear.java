import jline.console.ConsoleReader;

class clear 
{
	public static void main(String[] args) throws Exception
	{
		ConsoleReader r = new ConsoleReader();
		System.out.println("Hello World!");
		Thread.sleep(1000);
		r.flush();
		System.out.println("Hello World again!");
	}
}
