import java.io.*;

class Console
{
	public static void main(String[] args) throws Exception
	{
		Console c = System.console();
		String uname = c.readLine("User Name :");
		char[] pwd = c.readPassword("PassWord :");
		String upwd = new String(pwd);
		if(uname.equals("durga") && upwd.equals("durga")) {
			System.out.println("Valid User");
		}
		else {
			System.out.println("InValid User");
		}
	}
}
