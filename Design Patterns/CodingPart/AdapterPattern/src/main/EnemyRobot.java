package main;

import java.util.Random;

public class EnemyRobot {
	Random generator = new Random();
	
	public void smashWithHands() {
		int attackDamage = generator.nextInt(10)+1;
		
		System.out.println("Enemy Robot Causes " + attackDamage + " Damage with its hands");
	}
	
	public void walkForward() {
		int movement = generator.nextInt(5)+1;
		
		System.out.println("Enemy Robor walks forward " + movement + " spaces");
	}
	
	public void reactToHuman(String diriverName) {
		System.out.println("Enemy robot tramps on " + diriverName);
	}
	
}
