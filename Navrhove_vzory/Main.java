package com.company;

import com.company.builder.Builder;
import com.company.builder.Car;
import com.company.factory.Animal;
import com.company.factory.AnimalFactory;

public class Main {

    public static void main(String[] args) {
        //SINGLETON
        Singleton.getInstance(); //získáme instanci ze Singletonu

        //BUILDER
        Builder builder = new Builder(); //vytvoříme instanci od třídy Builder
        Car c = builder
                .setBrand("Brand auta")
                .setModel("Model auta")
                .build(); //pomocí metod nastavujeme to, co potřebujeme a jakmile skončíme, necháme vytvořit celý objekt

        //FACTORY
        AnimalFactory factory = new AnimalFactory();
        Animal dog = factory.createAnimal("dog"); //v deklaraci můžeme použít Animal, dále však s objektem pracujeme jako se psem

    }
}
