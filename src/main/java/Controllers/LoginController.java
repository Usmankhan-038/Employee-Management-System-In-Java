package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginController {

    @FXML
    private PasswordField password;

    @FXML
    private Button signinbtn;

    @FXML
    private TextField username;

    private Connection con;
    private PreparedStatement prepare;
    private ResultSet result;
    private double x = 0;
    private double y = 0;

    // Database connection method
    public static Connection connectDb() {
        try {
            String url = "jdbc:mysql://localhost:3306/ems"; // Replace 'ems' with your database name
            String user = "root"; // Replace with your MySQL username
            String pass = ""; // Replace with your MySQL password
            return DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void loginAdmin() {
        String name = username.getText();
        String pass = password.getText();

        // Fixed SQL query (removed extra 'where')
        String sql = "SELECT * FROM users WHERE username = ? AND password = ? AND role_id = 1";
        String employeelogin = "SELECT * FROM users WHERE username = ? AND password = ? AND role_id = 2";
        if (sql.isEmpty() && employeelogin.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error Message");
            alert.setContentText("SQL query is missing.");
            alert.showAndWait();
            return;
        }

        if (name.isEmpty() || pass.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error Message");
            alert.setContentText("Please fill all the fields.");
            alert.showAndWait();
            return;
        }

        String query = !sql.isEmpty() ? sql : employeelogin;
        String fxmlPath = !sql.isEmpty()
                ? "/com/example/ems/View/AdminDashboard.fxml"
                : "/com/example/ems/View/EmployeeDashboard.fxml";

        try {
            con = connectDb();

            if (con == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Error Message");
                alert.setContentText("Failed to connect to the database.");
                alert.showAndWait();
                return;
            }

            prepare = con.prepareStatement(query);
            prepare.setString(1, name);
            prepare.setString(2, pass);
            result = prepare.executeQuery();

            if (result.next()) {
                getData.username = name;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Success Message");
                alert.setContentText("Successfully Login");
                alert.showAndWait();

                signinbtn.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);

                root.setOnMouseReleased(event -> stage.setOpacity(1.0));
                stage.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Error Message");
                alert.setContentText("Wrong Username or Password");
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error Message");
            alert.setContentText("An unexpected error occurred.");
            alert.showAndWait();
        } finally {
            try {
                if (result != null) result.close();
                if (prepare != null) prepare.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
