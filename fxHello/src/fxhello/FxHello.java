package fxhello;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class FxHello extends Application {

    public void start(Stage primarySage) {
        primarySage.setTitle("hello world ");
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        Reflection ref = new Reflection();
        ref.setFraction(0.6F);
        Stop[] stop = {new Stop(0, Color.BLACK),
            new Stop(0.5, Color.WHITE),
            new Stop(1, Color.BLACK)};
        LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stop);

        Text hello = new Text("Hello world FX !!!"); // node 

        hello.setFill(Color.RED);
        hello.setFont(Font.font(null, FontWeight.BOLD, 70));
        hello.setEffect(ref);
        Rectangle rect = new Rectangle(0, 0, screenBounds.getWidth(), screenBounds.getHeight());  //node2
        rect.setFill(gradient);
        StackPane rootPane = new StackPane(rect, hello); //pane 

        Scene scene = new Scene(rootPane, 400, 300); //scene
        primarySage.setScene(scene);  //stage
        primarySage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
