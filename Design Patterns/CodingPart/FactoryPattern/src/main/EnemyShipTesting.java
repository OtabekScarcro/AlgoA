package main;

import java.util.Scanner;

public class EnemyShipTesting {

	public static void main(String[] args) {
		
		EnemyShipFactory shipFactory = new EnemyShipFactory();
		
		EnemyShip theEnemy = null;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("What type of ship? (U / R / B)");
		
		if(sc.hasNextLine()) {
			String typeOfShip = sc.nextLine().toUpperCase();
			theEnemy = shipFactory.makeEnemyShip(typeOfShip);
		}
		
		if(theEnemy != null) {
			doStuffEnemy(theEnemy);
		}
		else {
			System.out.println("Enter a U, R or B next time!");
		}
		
		
		
		
		
		
	}

	private static void doStuffEnemy(EnemyShip enemyShip) {
		enemyShip.displayEnemyShip();
		enemyShip.followHeroShip();
		enemyShip.enemyShipShoots();
	}

}
