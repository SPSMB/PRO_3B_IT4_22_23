package com.company;

import java.util.Scanner;

public class Main {
    /**
     * Promenna, ktera slouzi pro praci s prihlasenym uzivatelem.
     * Jakmile je promenna null, uzivatel neni prihlasen.
     */
    public static Account prihlaseni;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(prihlaseni == null){ //Dokud je uzivatel null, opakujeme prihlaseni
            System.out.println("Zadej přihlašovací jméno:");
            String prihlasovaniJmeno = sc.nextLine();
            System.out.println("Zadej heslo:");
            String heslo = sc.nextLine();
            Database.database(prihlasovaniJmeno, heslo); //Volame na metodu database ve tride Database
        }
        System.out.println("Prihlasen");
        do { //Nekonecny loop, kde ma uzivatel moznost pracovat se svym prihlasenym uctem
            System.out.println("1 - výpis údajů");
            System.out.println("2 - převod peněz");
            System.out.println("3 - odhlášení");
            int cislo = sc.nextInt();
            switch (cislo){
                case 1 -> {
                    System.out.println("jmeno: "+prihlaseni.getJmeno());
                    System.out.println("prijmeni: "+prihlaseni.getPrijmeni());
                    System.out.println("prihlasovaciJmeno: "+prihlaseni.getPrihlasovaciJmeno());
                    System.out.println("cislo karty: "+prihlaseni.getCisloKarty());
                    System.out.println("kod banky: "+prihlaseni.getKodBanky());
                    System.out.println("CVV: "+prihlaseni.getCVV());
                    System.out.println("zustatek: "+prihlaseni.getZustatek());
                    System.out.println("cislo uctu: "+prihlaseni.getCisloUctu());
                }
                case 2 -> {
                    System.out.println("Zadej cislo uctu");
                    int ucet = sc.nextInt();
                    System.out.println("Zadej castku");
                    int castka = sc.nextInt();
                    if (prihlaseni.getZustatek() < castka) {
                        System.out.println("Nedostatek penez");
                        continue;
                    }
                    Database.sendMoney(ucet, castka);
                }
                case 3 -> {
                    System.exit(0); //Ukonci program
                }
            }
        }while(true);
    }
}
