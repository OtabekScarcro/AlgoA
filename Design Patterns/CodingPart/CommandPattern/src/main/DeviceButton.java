package main;

import interfaces.Command;

public class DeviceButton {
	Command theCommand;

	public DeviceButton(Command theCommand) {
		this.theCommand = theCommand;
	}
	
	public void press() {
		theCommand.execute();
	}
	
	public void pressUndo() {
		theCommand.undo();
	}
}
