package com.company;

import com.company.items.Item;
import com.company.items.drinks.CocaCola;
import com.company.items.drinks.Water;
import com.company.items.food.Soup;
import com.company.items.food.Steak;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /*
    Vytvořte program pro nákup položek v obchodu.
    Uživatel dostane na výběr z X kategorií a z každé kategorie dostane na výběr z Y produktů.
    Každá kategorie bude mít vlastní třídu/Enum.
    Každá položka bude mít vlastní třídu.
    Při vyúčtování program vypíše celý seznam položek a celkovou částku.
     */

    private static ArrayList<Category> categories = new ArrayList<>();
    private static ArrayList<Item> products = new ArrayList<>();
    private static ArrayList<Item> cart = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initialize();
        System.out.println("Welcome to the store");
        while (true) {
            System.out.println("Write your next action:");
            System.out.println();
            System.out.println("0 - Go to payment");
            for (Category c : categories) {
                System.out.println((categories.indexOf(c)+1) + " - " + c);
            }
            System.out.println(" ");
            int x = sc.nextInt()-1;
            if (x == -1) {
                System.out.println("Your cart: ");
                int price = 0;
                for (Item i : cart) {
                    System.out.println(i.getName() + " - $" + i.getPrice());
                    price+=i.getPrice();
                }
                System.out.println(" ");
                System.out.println("Total: $" + price);
                System.exit(0);
            }
            if (x<categories.size()) {
                Category category = categories.get(x);
                ArrayList<Item> currentProducts = new ArrayList<>();
                for (Item i : products) {
                    if (i.getCategory() == category) {
                        currentProducts.add(i);
                    }
                }
                for (Item i : currentProducts) {
                    System.out.println(currentProducts.indexOf(i) + " - " + i.getName() + "($" + i.getPrice() + ")");
                }
                System.out.println(" ");
                int y = sc.nextInt();
                if (y<currentProducts.size()) {
                    Item item = currentProducts.get(y);
                    cart.add(item);
                    System.out.println("Item added to cart");
                } else {
                    System.out.println("Item not found");
                }
            } else {
                System.out.println("Category not found");
            }
        }
    }

    private static void initialize() {
        categories.add(Category.FOOD);
        categories.add(Category.DRINKS);
        products.add(new Steak());
        products.add(new Soup());
        products.add(new Water());
        products.add(new CocaCola());
    }
}
