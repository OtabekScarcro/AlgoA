package main;

import devices.Television;
import interfaces.ElectronicDevice;

public class TVRemote {
	public static ElectronicDevice getDevice() {
		return new Television();
	}
}
