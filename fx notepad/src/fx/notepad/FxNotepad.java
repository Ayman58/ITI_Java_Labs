package fx.notepad;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.IndexRange;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FxNotepad extends Application {

    TextArea text;
    FileChooser fileChooser = new FileChooser();

    private void saveTextToFile(TextArea content, File file) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        } catch (IOException ex) {

        }
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("FX notepad ");
        MenuBar bar = new MenuBar();
        Menu file = new Menu("file");
        text = new TextArea();

        MenuItem newItem = new MenuItem("new");
        newItem.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);
                File file = fileChooser.showSaveDialog(primaryStage);
                if (file != null) {
                    saveTextToFile(text, file);
                }
            }
        });

        MenuItem openItem = new MenuItem("open");
        openItem.setAccelerator(KeyCombination.keyCombination("Ctrl+m"));
        openItem.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                File file = fileChooser.showOpenDialog(primaryStage);

                try {
//                    DataInputStream dataIn = new DataInputStream(
//                            new FileInputStream(file.getAbsolutePath()));
                    Scanner s = new Scanner(new File(file.getAbsolutePath())).useDelimiter("\\s+");
                    while (s.hasNext()) {
                        if (s.hasNextInt()) { // check if next token is an int
                            text.appendText(s.nextInt() + " "); // display the found integer
                        } else {
                            text.appendText(s.next() + " "); // else read the next token
                        }
                    }
                } catch (FileNotFoundException ex) {
                    System.err.println(ex);
                }
////                fileChooser.showOpenDialog(primaryStage);
//                FileChooser fileChooser = new FileChooser();
////File selFile = new File(fileChooser.getSelectedfile());
//                File file = fileChooser.showOpenDialog(primaryStage);
//                
//
//                try {
//
//                    DataInputStream dataIn = new DataInputStream(
//                            new FileInputStream(file.getAbsolutePath()));
//
//                    while ((dataIn.available()) >0) {
//                        String st = dataIn.readUTF();
//                        System.out.println(st + "");
//                        text.appendText(st);
//
//                    }
//                } catch (IOException ex) {
//                }
            }
        }
        );

        MenuItem saveItem = new MenuItem("save");

        saveItem.addEventHandler(ActionEvent.ACTION,
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event
            ) {
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);
                File file = fileChooser.showSaveDialog(primaryStage);
                if (file != null) {
//                    saveTextToFile(text, file);
                    try {
                        file.createNewFile();
                        String filecont = text.getText();
                        DataOutputStream dataout = new DataOutputStream(new FileOutputStream(file.getAbsolutePath()));
                        dataout.writeUTF(filecont);
dataout.close();
                    } catch (Exception ex) {
                    }
                }
            }
        }
        );

        SeparatorMenuItem sep = new SeparatorMenuItem();
        SeparatorMenuItem sep1 = new SeparatorMenuItem();

        MenuItem exitItem = new MenuItem("Exit");

        Menu edit = new Menu("Edit");

        MenuItem undoItem = new MenuItem("Undo");

        undoItem.addEventHandler(ActionEvent.ACTION,
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event
            ) {
                text.undo();
            }
        }
        );

        MenuItem cutItem = new MenuItem("cut");

        cutItem.addEventHandler(ActionEvent.ACTION,
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event
            ) {
                text.cut();
            }
        }
        );

        MenuItem copyItem = new MenuItem("copy");

        copyItem.addEventHandler(ActionEvent.ACTION,
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event
            ) {
                text.copy();
            }
        }
        );

        MenuItem pasteItem = new MenuItem("paste");

        pasteItem.addEventHandler(ActionEvent.ACTION,
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event
            ) {
                text.paste();
            }
        }
        );

        MenuItem DeleteItem = new MenuItem("Delete");

        DeleteItem.addEventHandler(ActionEvent.ACTION,
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event
            ) {
                IndexRange di = text.getSelection();
                text.deleteText(di.getStart(),
                        di.getEnd()
                );
            }
        }
        );

        MenuItem SelectItem = new MenuItem("Select All");

        SelectItem.addEventHandler(ActionEvent.ACTION,
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event
            ) {
                text.selectAll();
            }
        }
        );

        Menu help = new Menu("Help");

        MenuItem aboutItem = new MenuItem("About NoePad");
        aboutItem.addEventHandler(ActionEvent.ACTION,
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event
            ) {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("about Dialog");
                alert.setHeaderText("this is my notepad project \nFdate 1/13/2022\nAyman Ibrahim");
                alert.setContentText("Are you ok with this?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    // ... user chose OK
                } else {
                    // ... user chose CANCEL or closed the dialog
                }
            }
        }
        );

        Text cpyrit = new Text("  copy rights 'Ayman Ibrahim' ");

        file.getItems()
                .addAll(newItem, openItem, saveItem, sep, exitItem);

        edit.getItems()
                .addAll(undoItem, cutItem, copyItem, pasteItem, DeleteItem, sep1, SelectItem);

        help.getItems()
                .addAll(aboutItem);

        bar.getMenus()
                .addAll(file, edit, help);

        BorderPane pane = new BorderPane();

        pane.setTop(bar);

        pane.setCenter(text);

        pane.setBottom(cpyrit);

        Scene scene = new Scene(pane, 400, 300);

        primaryStage.setScene(scene);  //stage

        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
