module clientapp.clientapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens clientapp.clientapp to javafx.fxml;
    exports clientapp.clientapp;
}