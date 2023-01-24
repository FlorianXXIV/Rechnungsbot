import java.util.*;

public class Bruchrechnung{
    Scanner sc = new Scanner(System.in);
    int sol[] = new int[2];
    int input[] = new int[2];
    String strInput;

    public void bruchrechnung(int rounds){
        Random rand = new Random();
        int randI;

        System.out.println("""
                Bei der Bruchrechnung sollten alle ergebnisse auch in form eines bruches angegeben werden.
                Diese werden in der form zaehler|nenner angegeben.
                Tastenkombination fuer |: altGr + <
                """);
        for(int i = 0; i<rounds; i++){
            randI = rand.nextInt(3);
            switch (randI){
                case 0:
                    fracMult();
                    break;
                case 1:
                    fracAdd();
                    break;
                case 2:
                    fracDiv();
                    break;
                default:
                    System.out.println("Unbekannter Fehler.");
                    System.out.println("bruchrechnung() konnte keinen zufaelligen Integer zwischen 0 und 3 generieren.");
            }
        }
    }

    void fracMult(){
        int operators[][] = createOperators();
        System.out.println("Berechne:");
        System.out.println(operators[0][0] + "|" + operators[0][1] + " * " + operators[1][0] + "|" + operators[1][1]);
        sol[0] = operators[0][0] * operators[1][0];
        sol[1] = operators[0][1] * operators[1][1];
        sol = fracSimplify(sol);
        checkInput(sol);
    }
    void fracAdd(){
        int operators[][] = createOperators();
        System.out.println("Berechne:");
        System.out.println(operators[0][0] + "|" + operators[0][1] + " + " + operators[1][0] + "|" + operators[1][1]);
        if(operators[0][1] == operators[1][1]){
            sol[0] = operators[0][0] + operators[1][0];
            sol[1] = operators[0][1];
        }else{
            sol[0] = (operators[0][0]*operators[1][1]) + (operators[1][0]*operators[0][1]);
            sol[1] = operators[0][1]*operators[1][1];
        }
        sol = fracSimplify(sol);
        checkInput(sol);
    }
    void fracDiv(){
        int operators[][] = createOperators();
        System.out.println("Berechne:");
        System.out.println(operators[0][0] + "|" + operators[0][1] + " / " + operators[1][0] + "|" + operators[1][1]);
        sol[0] = operators[0][0]*operators[1][1];
        sol[1] = operators[0][1]*operators[1][0];
        sol = fracSimplify(sol);
        checkInput(sol);
    }
    int[][] createOperators(){
        Random random = new Random();
        int operators[][] = new int[2][2];
        for(int i = 0; i<2; i++){
            for(int j = 0; j<2;j++){
                operators[i][j] = random.nextInt(20)+1;
            }
        }
        return operators;
    }
    void checkInput(int[] sol){
        strInput = sc.nextLine();
        input = toFrac(strInput);

        if(input[0]/input[1] == sol[0]/sol[1]){
            if (input.equals(sol)){
                System.out.println(input[0] + "|" + input[1] + " ist Korrekt!");
            }else{
                System.out.println(input[0] + "|" + input[1] + " ist Korrekt, aber");
                System.out.println("es kann zu " + sol[0] + "|" + sol[1] + " gekuertzt werden.");
            }
        }else{
            System.out.println(input[0] + "|" + input[1] + " ist Falsch!");
            System.out.println(sol[0] + "|" + sol[1] + " waere Richtig!");
        }
    }
    int[] toFrac(String fraction){
        int[] frac = new int[2];
        Scanner scanner = new Scanner(fraction).useDelimiter("\\|");
        frac[0] = scanner.nextInt();
        frac[1] = scanner.nextInt();
        return frac;
    }

    int[] fracSimplify(int[] frac){
        int gcd = gcd(frac[0],frac[1]);
        System.out.println(gcd);
        int nenner = frac[0]/gcd;
        int zaehler = frac[1]/gcd;
        return new int[]{nenner,zaehler};
    }
    int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}
