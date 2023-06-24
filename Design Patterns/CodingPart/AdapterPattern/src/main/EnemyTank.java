package main;

import java.util.Random;

public class EnemyTank implements EnemyAttacker{
	
	Random random = new Random();

	@Override
	public void fireWeapon() {
		
		int attackDamage = random.nextInt(10)+1;
		
		System.out.println("Enemy Tank does " + attackDamage + " damage");
	}

	@Override
	public void driveForward() {
		
		int movement = random.nextInt(10)+1;
		
		System.out.println("Enemy Tank moves " + movement + " spaces");
	}

	@Override
	public void assignDriver(String driverName) {
		System.out.println(driverName + " is driving the Tank");
	}

}









