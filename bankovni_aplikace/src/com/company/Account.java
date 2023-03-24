package com.company;

public class Account {
    private String jmeno;
    private String prijmeni;
    private String prihlasovaciJmeno;
    private String heslo;
    private int cisloKarty;
    private int kodBanky;
    private int CVV;
    private int zustatek;
    private int cisloUctu;

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public String getPrihlasovaciJmeno() {
        return prihlasovaciJmeno;
    }

    public void setPrihlasovaciJmeno(String prihlasovaciJmeno) {
        this.prihlasovaciJmeno = prihlasovaciJmeno;
    }

    public String getHeslo() {
        return heslo;
    }

    public void setHeslo(String heslo) {
        this.heslo = heslo;
    }

    public int getCisloKarty() {
        return cisloKarty;
    }

    public void setCisloKarty(int cisloKarty) {
        this.cisloKarty = cisloKarty;
    }

    public int getKodBanky() {
        return kodBanky;
    }

    public void setKodBanky(int kodBanky) {
        this.kodBanky = kodBanky;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public int getZustatek() {
        return zustatek;
    }

    public void setZustatek(int zustatek) {
        this.zustatek = zustatek;
    }

    public int getCisloUctu() {
        return cisloUctu;
    }

    public void setCisloUctu(int cisloUctu) {
        this.cisloUctu = cisloUctu;
    }

    public Account(String jmeno, String prijmeni, String prihlasovaciJmeno, String heslo, int cisloKarty, int kodBanky, int CVV, int zustatek, int cisloUctu) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.prihlasovaciJmeno = prihlasovaciJmeno;
        this.heslo = heslo;
        this.cisloKarty = cisloKarty;
        this.kodBanky = kodBanky;
        this.CVV = CVV;
        this.zustatek = zustatek;
        this.cisloUctu = cisloUctu;
    }
}
