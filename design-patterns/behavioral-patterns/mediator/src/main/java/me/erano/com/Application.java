package me.erano.com;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {

    public static void main(String[] args) {
        //to execute this application -> mvn clean javafx:run
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        var javaVersion = System.getProperty("java.version");
        var javafxVersion = System.getProperty("javafx.version");

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();
    }
}
