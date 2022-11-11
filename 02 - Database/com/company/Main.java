package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("Jak žabička k problémům přišla", "Autor pochodovy", 154, "Fantasy", 1500);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book);
        for (Book b: books) {
            System.out.println(b.toString());
        }

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/bookshelf","root","");
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM books");
            while (rs.next()) {
                String name = rs.getString("name");
                String author = rs.getString("author");
                int pages = rs.getInt("pages");
                int year = rs.getInt("year");
                String genre = rs.getString("genre");
                System.out.println(name + " " + author + " " + pages + " " + year + " " + genre);
            }
            con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
