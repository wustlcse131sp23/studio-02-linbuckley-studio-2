package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println ("Welcome to the Casino");
		int startAmount = in.nextInt();
		double winChance = in.nextDouble();
		int winLimit = in.nextInt();
		int totalSimulations = in.nextInt();
		int totalLosses = 0;
		int day = 0;
		for (int sim = totalSimulations; sim >0; sim --) {
			int plays = 0;
			int amount = startAmount;
			while (amount < winLimit && amount > 0) {
				double gameChance = Math.random();
				if (gameChance < winChance) { 
					amount += 1;
					plays += 1;
				}
				else {
					amount -=1;
					plays += 1;
				}
			}
		day +=1;
		if (amount == winLimit) {
			System.out.println ("Simulation " + day + ": "+ plays + " WIN");
		}
		else {
			System.out.println ("Simulation " + day + ": "+ plays + " LOSE");
			totalLosses += 1;
			
		}
	}
		System.out.println("Losses: " + totalLosses + " Simulations: " + totalSimulations);
		double ruinRate = ((double) totalLosses / (double)totalSimulations);
		double a = (1-winChance)/winChance;
		if (winChance == 0.5) {
			double expectedRuin = 1 - startAmount/winLimit;
			System.out.println("Ruin Rate from Simulation: " + ruinRate + "Expected Ruin Rate: " + expectedRuin);
		}
		else {
			double expectedRuin = (Math.pow(a, startAmount) - Math.pow(a, winLimit))/(1-Math.pow (a, winLimit));
			System.out.println("Ruin Rate from Simulation: " + ruinRate + " Expected Ruin Rate: " + expectedRuin);
		}
		
	}
}
