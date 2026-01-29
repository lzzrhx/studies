package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.*;
import no.hvl.data102.filmarkiv.klient.*;

import java.util.Scanner;

public class FilmarkivMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("------------------------------------------------------------------------");
        System.out.println("FILMARKIV (Tabell)");
        System.out.println("------------------------------------------------------------------------");
        Meny meny = new Meny(new Filmarkiv(100), scanner);
        System.out.println();
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("FILMARKIV (Lenket liste)");
        System.out.println("------------------------------------------------------------------------");
        Meny meny2 = new Meny(new Filmarkiv2(), scanner);
        System.out.println();
        scanner.close();
    }
}
