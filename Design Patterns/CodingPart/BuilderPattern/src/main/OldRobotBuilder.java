package main;

public class OldRobotBuilder implements RobotBuilder {

	private Robot robot;
	
	public OldRobotBuilder() {
		robot = new Robot();
	}
	
	@Override
	public void buildRobotHead() {
		robot.setRobodHead("Tin Head");
	}

	@Override
	public void buildRobotTorso() {
		robot.setRobodTorso("Tin Torso");
	}

	@Override
	public void buildRobotArms() {
		robot.setRobodArms("Blowtorch Arms");
	}

	@Override
	public void buildRobotLegs() {
		robot.setRobodLegs("Roller Skates");
	}

	@Override
	public Robot getRobot() {
		return this.robot;
	}

}
