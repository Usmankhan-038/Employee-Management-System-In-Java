module com.example.ems {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.ems to javafx.fxml;
    exports com.example.ems;
}