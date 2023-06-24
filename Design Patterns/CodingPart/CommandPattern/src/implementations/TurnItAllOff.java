package implementations;

import java.util.List;

import interfaces.Command;
import interfaces.ElectronicDevice;

public class TurnItAllOff implements Command{
	
	List<ElectronicDevice> theDevices;
	
	public TurnItAllOff(List<ElectronicDevice> theDevices) {
		this.theDevices = theDevices;
	}


	@Override
	public void execute() {
		for(ElectronicDevice device : theDevices) {
			device.off();
		}
	}
	
	@Override
	public void undo() {
		for(ElectronicDevice device : theDevices) {
			device.on();
		}
	}
}
