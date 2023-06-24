package main;

public class HasPin implements ATMState{
	
	ATMMachine atmMachine;

	public HasPin(ATMMachine atmMachine) {
		this.atmMachine = atmMachine;
	}

	@Override
	public void insertCard() {
		System.out.println("You can't enter more than one card");
	}

	@Override
	public void ejectCard() {
		System.out.println("Card Ejected");
		atmMachine.setATMState(atmMachine.getNoCardState());
	}

	@Override
	public void insertPin(int pinEntered) {
		System.out.println("Already Entered PIN");
	}

	@Override
	public void requestCash(int cashToWidthraw) {
		if(cashToWidthraw > atmMachine.cashInMachine) {
			System.out.println("Don't have that Cash");
			System.out.println("Card Ejected");
			atmMachine.setATMState(atmMachine.getNoCardState());
		} else {
			System.out.println(cashToWidthraw + " is provided by the Machine");
			atmMachine.setCashInMachine(atmMachine.cashInMachine - cashToWidthraw);
			System.out.println("Card Ejected");
			atmMachine.setATMState(atmMachine.getNoCardState());
			
			if(atmMachine.cashInMachine <= 0) {
				atmMachine.setATMState(atmMachine.getNoCashState());
			}
		}
	}

}

















































