package me.erano.com;

import me.erano.com.example1.ArrayCompositor;
import me.erano.com.example1.Composition;
import me.erano.com.example1.SimpleCompositor;
import me.erano.com.example1.TeXCompositor;

public class Application {
    public static void main(String[] args) {

        //example 1 - gof
        String[] paragraph = {
                "Strategy", "design", "pattern", "lets", "the", "algorithm",
                "vary", "independently", "from", "clients", "that", "use", "it."
        };

        Composition composition = new Composition(new SimpleCompositor());
        composition.repair(paragraph);

        System.out.println("\nSwitching to TeXCompositor:\n");
        composition.setCompositor(new TeXCompositor());
        composition.repair(paragraph);

        System.out.println("\nSwitching to ArrayCompositor:\n");
        composition.setCompositor(new ArrayCompositor());
        composition.repair(paragraph);

    }
}
