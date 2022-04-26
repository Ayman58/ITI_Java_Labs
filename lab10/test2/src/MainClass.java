import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class MainClass extends Application {
    ContactDAO contactDAO;
    List<ContactPerson> list= new ArrayList<>();
    GridPane gridPane;
    Button first,last,previous,next;
    int index;
    TextField idField,firstNameField,middleNameField,lastNameField,emailField,phoneField;
    @Override
    public void init() throws Exception {
        contactDAO=new ContactDAO();
        list = contactDAO.getContacts();

        idField=new TextField();
        idField.setEditable(false);
        firstNameField=new TextField();
        middleNameField=new TextField();
        lastNameField=new TextField();
        emailField=new TextField();
        phoneField=new TextField();


        first =new Button("First");
        last =new Button("Last");
        previous =new Button("Previous");
        next =new Button("Next");


        gridPane = new GridPane();
        gridPane.setVgap(5);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(5,5,5,5));

        gridPane.add(new Label("ID"),0,0);
        gridPane.add(idField,1,0);

        gridPane.add(new Label("Fist Name"),0,1);
        gridPane.add(firstNameField,1,1);

        gridPane.add(new Label("Middle Name"),0,2);
        gridPane.add(middleNameField,1,2);

        gridPane.add(new Label("Last Name"),0,3);
        gridPane.add(lastNameField,1,3);

        gridPane.add(new Label("Email"),0,4);
        gridPane.add(emailField,1,4);

        gridPane.add(new Label("Phone"),0,5);
        gridPane.add(phoneField,1,5);

        FlowPane flowPane = new FlowPane(first,previous,next,last);
        gridPane.add(flowPane,1,6);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(gridPane,600,400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("database app");
        primaryStage.show();


        first.addEventHandler(ActionEvent.ACTION, event -> {
            setFields(0);
        });
        last.addEventHandler(ActionEvent.ACTION, event -> {
            setFields(list.size()-1);
        });
        previous.addEventHandler(ActionEvent.ACTION, event -> {
            if (index>0){
                setFields(--index);
            }
        });
        next.addEventHandler(ActionEvent.ACTION, event -> {
            if (index<list.size()-1){
                setFields(++index);
            }
        });
    }

    private void setFields(int num){
        index=num;
        ContactPerson cp =list.get(num);
        idField.setText(String.valueOf(cp.getId()));
        firstNameField.setText(cp.getFirstName());
        lastNameField.setText(cp.getLastName());
        middleNameField.setText(cp.getMiddleName());
        emailField.setText(cp.getEmail());
        phoneField.setText(String.valueOf(cp.getPhone()));

    }
    public static void main(String[] args) {
        launch(args);
    }
}
