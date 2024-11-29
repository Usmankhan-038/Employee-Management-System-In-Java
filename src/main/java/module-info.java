module com.example.ems {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;
    requires java.desktop;
    requires fontawesomefx;

    opens com.example.ems to javafx.fxml;
//    exports com.example.ems;
    exports Model;
    opens Model to javafx.fxml;
    exports Controllers;
    opens Controllers to javafx.fxml;
    exports App;
    opens App to javafx.fxml;
}