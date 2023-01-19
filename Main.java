import java.util.*;
class Main{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		int input;
		System.out.println("""
				Willkommen beim Rechenbot, wähle eine Kategorie.
				0-Dezimalrechnung
				1-Bruchrechnung
				""");
		input = sc.nextInt();
		switch (input) {
			case 0:
				System.out.println("Gib die gewünschte rundenzahl an.");
				int rounds = sc.nextInt();
				practiceRand(rounds);
				break;
			case 1:
				System.out.println("WIP");
				break;
			default:
				System.out.println("Ungueltige eingabe.");
		}
	}
	static void practiceAdd(){
		double operators[] = createOperators(3);
		double sum = 0.0;

		for(double i: operators){
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
		double input = Double.parseDouble(sc.next());
		if(input == sum){
			System.out.println(input + " ist richtig!");
		}else {
			System.out.println(input + " ist falsch " + sum + " war die richtige antwort.");
		}
		return;
	}
	static void practiceMult(){
		double sum = 1.0;
		double operators[] = createOperators(2);
		for(double i: operators){
			sum *= i;
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
					System.out.print(operators[i] + " * ");
			}
		}
		double input = Double.parseDouble(sc.next());
		if(input == sum){
			System.out.println(input + " ist richtig!");
		}else {
			System.out.println(input + " ist falsch " + sum + " war die richtige antwort.");
		}
		return;
	}
	static void practiceDiv(){
		double operators[] = createOperators(2);
		double sum = operators[0];
		for(double i: operators){
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
	static double[] createOperators(int bound){
		Random random = new Random();
		int nOperators = random.nextInt(bound-1);
		nOperators = nOperators+2;
		double operators[] = new double[nOperators];


		for(int i = 0; i<nOperators;i++){
			operators[i] = Math.round(Math.random() * 1000.0)/10.0;
		}
		return operators;
	}
}