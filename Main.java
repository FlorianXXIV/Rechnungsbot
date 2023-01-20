import Programm.Bruchrechnung;

import java.util.*;
class Main{
	static Scanner sc = new Scanner(System.in);
	static Bruchrechnung br = new Bruchrechnung();
	public static void main(String[] args){ //Matrizenrechnung hinzufügen
		int input;
		int rounds;
		System.out.println("""
				Willkommen beim Rechenbot, wähle eine Kategorie.
				0-Dezimalrechnung
				1-Bruchrechnung
				2-Matrizenrechnung
				""");
		input = sc.nextInt();
		switch (input) {
			case 0:
				System.out.println("Gib die gewuenschte rundenzahl an.");
				rounds = sc.nextInt();
				practiceRand(rounds);
				break;
			case 1:
				System.out.println("Gib die gewuenschte rundenzahl an.");
				rounds = sc.nextInt();
				br.bruchrechnung(rounds);
				break;
			default:
				System.out.println("Ungueltige eingabe.");
		}
	}
	static void practiceAdd(){
		int operators[] = createOperators(3);
		int sum = 0;

		for(int i: operators){
			sum += i;
		}
		System.out.println("Berechne: ");
		for(int i = 0; i<=operators.length; i++){
			switch (operators.length-i){
				case 0:
					System.out.print(" = ");
					break;
				case 1:
					System.out.print(operators[i]);
					break;
				default:
					System.out.print(operators[i] + " + ");
			}
		}
		int input = sc.nextInt();
		if(input == sum){
			System.out.println(input + " ist richtig!");
		}else {
			System.out.println(input + " ist falsch " + sum + " war die richtige antwort.");
		}
		return;
	}
	static void practiceMult(){
		int sum = 1;
		int operators[] = createOperators(2);
		for(int i: operators){
			sum *= i;
		}
		System.out.println("Berechne: ");
		for(int i = 0; i<=operators.length; i++){
			switch (operators.length-i){
				case 0:
					System.out.print(" = ");
					break;
				case 1:
					System.out.print(operators[i]);
					break;
				default:
					System.out.print(operators[i] + " * ");
			}
		}
		int input = sc.nextInt();
		if(input == sum){
			System.out.println(input + " ist richtig!");
		}else {
			System.out.println(input + " ist falsch " + sum + " war die richtige antwort.");
		}
		return;
	}
	static void practiceDiv(){
		int operators[] = createOperators(2);
		double sum = operators[0];
		for(int i: operators){
			if(i != sum){
				sum /= i;
			}
		}
		sum = Math.round(sum * 100.0)/100.0;
		System.out.println("Berechne: ");
		for(int i = 0; i<=operators.length; i++){
			switch (operators.length-i){
				case 0:
					System.out.print(" = ");
					break;
				case 1:
					System.out.print(operators[i]);
					break;
				default:
					System.out.print(operators[i] + " / ");
			}
		}
		double input = Double.parseDouble(sc.next());
		if(input == sum){
			System.out.println(input + " ist richtig!");
		}else {
			System.out.println(input + " ist falsch " + sum + " war die richtige antwort.");
		}
	}
	static void practiceRand(int rounds){
		Random random = new Random();
		for(int i = 0; i<rounds; i++) {
			int selector = random.nextInt(3);
			switch (selector) {
				case 0:
					practiceAdd();
					break;
				case 1:
					practiceMult();
					break;
				case 2:
					practiceDiv();
					break;
				default:
					System.out.println("Unbekannter Fehler");
					System.out.println("practiceRand konnte keine kategorie auswaehlen!");
			}
		}
	}
	static int[] createOperators(int bound){
		Random random = new Random();
		int nOperators = random.nextInt(bound-1);
		nOperators = nOperators+2;
		int operators[] = new int[nOperators];

		for(int i = 0; i<nOperators;i++){
			operators[i] = random.nextInt(20) + 1;
		}
		return operators;
	}
}