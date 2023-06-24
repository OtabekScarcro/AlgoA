package implementations;

import interfaces.Command;
import interfaces.ElectronicDevice;

public class TurnTVOn implements Command{
	
	ElectronicDevice theDevice;
	
	public TurnTVOn(ElectronicDevice theDevice) {
		this.theDevice = theDevice;
	}

	@Override
	public void execute() {
		theDevice.on();
	}

	@Override
	public void undo() {
		theDevice.off();
	}
}
