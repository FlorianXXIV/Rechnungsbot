package Programm;

import java.util.*;
public class Bruchrechnung{
    public void bruchrechnung(int rounds){
        Random rand = new Random();
        int randI = rand.nextInt(3);
        System.out.println("""
                Bei der Bruchrechnung sollten alle ergebnisse auch in form eines bruches angegeben werden.
                Diese werden in der form zaehler|nenner angegeben.
                Tastenkombination fuer |: altGr + <
                """);
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
                System.out.println("bruchrechnung() konnte keinen zufälligen Integer zwischen 0 und 3 generieren.");
        }
    }

    void fracMult(){

    }
    void fracAdd(){

    }
    void fracDiv(){

    }
    void createOperators(){

    }

}
