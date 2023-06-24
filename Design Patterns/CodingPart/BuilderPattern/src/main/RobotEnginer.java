package main;

public class RobotEnginer {
	private RobotBuilder robotBuilder;
	
	public RobotEnginer(RobotBuilder robotBuilder) {
		this.robotBuilder = robotBuilder;
	}
	
	public Robot getRobot() {
		return this.robotBuilder.getRobot();
	}
	
	public void makeRobot() {
		this.robotBuilder.buildRobotHead();
		this.robotBuilder.buildRobotTorso();
		this.robotBuilder.buildRobotArms();
		this.robotBuilder.buildRobotLegs();
	}
	
}
