package main;

public class Robot implements RobotPlan {

	private String robotHead;
	private String robotTorso;
	private String robotArms;
	private String robotLegs;
	
	
	// Setters
	@Override
	public void setRobodHead(String head) {
		this.robotHead = head;
	}

	@Override
	public void setRobodTorso(String torso) {
		this.robotTorso = torso;
	}

	@Override
	public void setRobodArms(String arms) {
		this.robotArms = arms;
	}

	@Override
	public void setRobodLegs(String legs) {
		this.robotLegs = legs;
	}
	
	// Getters
	
	public String getRobotHead() {
		return robotHead;
	}

	public String getRobotTorso() {
		return robotTorso;
	}

	public String getRobotArms() {
		return robotArms;
	}

	public String getRobotLegs() {
		return robotLegs;
	}
	
	

}













