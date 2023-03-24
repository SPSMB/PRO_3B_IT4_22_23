package com.company;

import java.sql.*;

public class Database {
    public static void updateDataZustatek(int ucet, int zustatek) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/bank", "root", ""); //Za URL dosazujeme odkaz na pripojeni k databazi, pote jmeno a heslo pro prihlaseni
            PreparedStatement statement = con.prepareStatement("UPDATE uzivatel SET zustatek = ? WHERE cislo_uctu = ?"); //Do zavorky zadavame SQL prikaz, ktery se ma vykonat. Za udaje dosazujeme otazniky.
            statement.setInt(1, zustatek); //Dosazujeme udaje za otazniky v prikazu. Indexujeme od jednicky.
            statement.setInt(2, ucet);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendMoney(int ucet, int castka) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/bank", "root", "");
            PreparedStatement statement = con.prepareStatement("SELECT * FROM uzivatel WHERE cislo_uctu = ?");
            statement.setInt(1, ucet);
            ResultSet set = statement.executeQuery(); //ResultSet vraci zaznamy, které vykona vytvoreny statement
            if (!set.next()) { //Metoda next() posune pouzivany zaznam o jedna a zaroven vraci boolean, takze idealni pro pouziti do podminky.
                System.out.println("Ucet neexistuje");
                return;
            }
            int predZustatek = set.getInt("zustatek");
            Main.prihlaseni.setZustatek(Main.prihlaseni.getZustatek()-castka);
            updateDataZustatek(ucet, (predZustatek+castka));
            updateDataZustatek(Main.prihlaseni.getCisloUctu(), Main.prihlaseni.getZustatek());
            System.out.println("Uspesne odeslano");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean database(String prihlasovaci_jmeno, String heslo) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/bank", "root", "");
            PreparedStatement statement = con.prepareStatement("SELECT * FROM uzivatel WHERE prihlasovaci_jmeno = ? AND heslo = ?");
            statement.setString(1, prihlasovaci_jmeno);
            statement.setString(2, heslo);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String jmeno = rs.getString("jmeno");
                String prijmeni = rs.getString("prijmeni");
                String prihlasovaci = rs.getString("prihlasovaci_jmeno");
                int idKarty = rs.getInt("id_karty");
                int cisloUctu = rs.getInt("cislo_uctu");
                int zustatek = rs.getInt("zustatek");
                PreparedStatement statement2 = con.prepareStatement("SELECT * FROM platebni_karta WHERE id = ?");
                statement2.setInt(1, idKarty);
                ResultSet rs2 = statement2.executeQuery();
                rs2.next();
                int cisloKarty = rs2.getInt("cislo_karty");
                int kodBanky = rs2.getInt("kod_banky");
                int cvv = rs2.getInt("cvv");
                Main.prihlaseni = new Account(jmeno, prijmeni, prihlasovaci, heslo, cisloKarty, kodBanky, cvv, zustatek, cisloUctu);
                return true;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

}
