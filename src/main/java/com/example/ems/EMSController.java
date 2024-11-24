package com.example.ems;

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

import java.lang.classfile.Label;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EMSController {
//    @FXML
//    private Label forgetpasswordbtn;

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

    public void loginAdmin(){
        String name = username.getText();
        String pass = password.getText();
        String sql = "select * from users where username = ? and password = ? where role_id = 1";

        try{
            con = database.connectDb();
            prepare = con.prepareStatement(sql);
            prepare.setString(1,name);
            prepare.setString(2,pass);
            result = prepare.executeQuery();

            if(name.isEmpty() || pass.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Error Message");
                alert.setContentText("Please fill all the fields");
                alert.showAndWait();
            }
            else
            {
                if(result.next()){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Success Message");
                    alert.setContentText("Successfully Login");
                    alert.showAndWait();

                    signinbtn.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.initStyle(StageStyle.TRANSPARENT);
                    stage.setScene(scene);

                    root.setOnMousePressed((javafx.scene.input.MouseEvent event) -> {
                        x = event.getSceneX();
                        y = event.getSceneY();
                    });

                    root.setOnMouseDragged((MouseEvent event) -> {
                        stage.setX(event.getScreenX() - x);
                        stage.setY(event.getScreenY() - y);
                        stage.setOpacity(0.8);
                    });
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Error Message");
                    alert.setContentText("Wrong Username or Password");
                    alert.showAndWait();
                }
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }


    }
}
