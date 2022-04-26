package fxhello2;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;

import javafx.scene.layout.StackPane;

import javafx.scene.shape.Rectangle;

import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Fxhello2 extends Application {

    public void start(Stage primarySage) {
        primarySage.setTitle("hello world ");
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();

        Text hello = new Text("Hello world FX !!!"); // node 
        hello.setId("hellotxt");

        Rectangle rect = new Rectangle(0, 0, screenBounds.getWidth(), screenBounds.getHeight());  //node2
        rect.setId("myRect");
        StackPane rootPane = new StackPane(rect, hello); //pane 

        Scene scene = new Scene(rootPane, 400, 300); //scene
        scene.getStylesheets().add(getClass().getResource("../style.css").toString());

        primarySage.setScene(scene);  //stage
        primarySage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
