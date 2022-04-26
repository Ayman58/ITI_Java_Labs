package concurrncy;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Concurrncy extends Application {

    TextArea textArea = new TextArea();
    Label statusLabel = new Label("not started...");

    Button startbtn = new Button("start");
    Button exttbtn = new Button("Exit");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        startbtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                startTask();

            }

            public void startTask() {
                Runnable task = new Runnable() {
                    public void run() {
                        runTask();
                    }
                };
                Thread bgThread = new Thread(task);
                bgThread.setDaemon(true);
                bgThread.start();
            }

            private void runTask() {
                for (int i = 1; i <= 10; i++) {
                    try {
                        final String status = "Processing" + i + "of" + 10;
                        Platform.runLater(new Runnable() {

                            public void run() {
                                statusLabel.setText(status);
                                textArea.appendText(status + "\n");
                            }
                        });
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                }
            }
        });

        exttbtn.setOnAction(
                new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event
            ) {
                stage.close();
            }
        }
        );
        FlowPane pane = new FlowPane(startbtn, exttbtn);
        BorderPane root = new BorderPane();

        root.setTop(statusLabel);

        root.setCenter(pane);

        root.setBottom(textArea);

        Scene scene = new Scene(root, 300, 250);

        stage.setTitle("Hello World!");
        stage.setScene(scene);

        stage.show();

    }
}
