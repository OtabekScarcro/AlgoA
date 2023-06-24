package main;

public class BankAccountFacade {
	private int accountNumber;
	private int securityCode;
	
	AccountNumberCheck acctChecker;
	SecurityCodeCheck codeChecker;
	FundsCheck fundChecker;
	
	WelcomeToBank bankWelcome;
	
	public BankAccountFacade(int newAccount, int secCode) {
		this.accountNumber = newAccount;
		this.securityCode = secCode;
		
		bankWelcome = new WelcomeToBank();
		acctChecker = new AccountNumberCheck();
		codeChecker = new SecurityCodeCheck();
		fundChecker = new FundsCheck();
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public int getSecurityCode() {
		return securityCode;
	}
	
	public void withdrawCash(double cashToGet) {
		
		if(acctChecker.accountActive(getAccountNumber()) &&
				codeChecker.isCodeCorrect(getSecurityCode()) &&
				fundChecker.haveEnoughMoney(cashToGet)) {
			
			System.out.println("Transaction Completed\n");
		} else {
			System.out.println("Transaction Failed!\n");
		}
		
	}
	
	public void depositCash(double cashToDeposit) {
		
		if(acctChecker.accountActive(getAccountNumber()) &&
				codeChecker.isCodeCorrect(getSecurityCode())) {
			
			fundChecker.makeDeposit(cashToDeposit);
			
			System.out.println("Transaction Completed\n");
		} else {
			System.out.println("Transaction Failed!\n");
		}
		
	}
	
}











