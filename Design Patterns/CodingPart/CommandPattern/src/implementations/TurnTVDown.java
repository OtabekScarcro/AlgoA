package implementations;

import interfaces.Command;
import interfaces.ElectronicDevice;

public class TurnTVDown implements Command{
	
	ElectronicDevice theDevice;
	
	public TurnTVDown(ElectronicDevice theDevice) {
		this.theDevice = theDevice;
	}

	@Override
	public void execute() {
		theDevice.volumeDown();
	}
	
	@Override
	public void undo() {
		theDevice.on();
	}
	
}
