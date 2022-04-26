package clintapp;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.Socket;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ClintApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("send");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
        Label label = new Label("Enter text here");
        TextField text = new TextField();
        TextArea textA = new TextArea();
        FlowPane pane = new FlowPane(label, text, btn);
        BorderPane root = new BorderPane();
        root.setCenter(textA);
        root.setBottom(pane);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("clint ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    Socket mySocket;
    DataInputStream dis;
    PrintStream ps;

    public ClintApp() {
        try {

            mySocket = new Socket("127.0.0.1", 5005);
            dis = new DataInputStream(mySocket.getInputStream());
            ps = new PrintStream(mySocket.getOutputStream());
            ps.println("hello from clint");
            String replyMsg = dis.readLine();
            System.out.println(replyMsg);

            ps.close();
            dis.close();
            mySocket.close();
            mySocket.close();

        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        launch(args);
       new ClintApp();
    }

}
