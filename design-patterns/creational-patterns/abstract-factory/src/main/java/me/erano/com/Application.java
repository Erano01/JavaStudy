package me.erano.com;

import me.erano.com.example1.Client;
import me.erano.com.example1.abstract_factories.WidgetFactory;
import me.erano.com.example1.concrete_factories.MotifWidgetFactory;
import me.erano.com.example1.concrete_factories.PresentationManagerWidgetFactory;

public class Application {

	public static void main(String[] args) {
        WidgetFactory motifFactory = new MotifWidgetFactory();
        Client motifClient = new Client(motifFactory);
        motifClient.renderUI();

        WidgetFactory pmFactory = new PresentationManagerWidgetFactory();
        Client pmClient = new Client(pmFactory);
        pmClient.renderUI();
    }
}
