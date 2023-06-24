package main;

public class TestRobotBuilder {
	public static void main(String[] args) {
		RobotBuilder oldStyleRobot = new OldRobotBuilder();
		
		RobotEnginer robotEnginer = new RobotEnginer(oldStyleRobot);
		
		robotEnginer.makeRobot();
		
		Robot firstRobot = robotEnginer.getRobot();
		
		System.out.println("Robot built");
		
		System.out.println("Robot Head Type: " + firstRobot.getRobotHead());
		System.out.println("Robot Torso Type: " + firstRobot.getRobotTorso());
		System.out.println("Robot Arms Type: " + firstRobot.getRobotArms());
		System.out.println("Robot Legs Type: " + firstRobot.getRobotLegs());
	}
}
