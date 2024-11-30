package Controllers;


import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javafx.scene.image.ImageView;
import javafx.stage.StageStyle;
//import java.lang.classfile.Label;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private Button EmployeeHolidaysBtn;

    @FXML
    private Button addEmployeeBtn;

    @FXML
    private AnchorPane add_emp;

    @FXML
    private Button add_emp_btn;

    @FXML
    private AnchorPane add_emp_image;

    @FXML
    private ImageView add_emp_image_view;

    @FXML
    private AnchorPane add_emp_salary;

    @FXML
    private Button add_employee_sal;

    @FXML
    private AnchorPane admin_dashboard;

    @FXML
    private Button dashboarbbtn;

    @FXML
    private Label dashboard_totalEmployee_Count;

    @FXML
    private Label dashboard_totalInactiveEmpolyee_Count;

    @FXML
    private Label dashboard_totalPresent_Count;

    @FXML
    private TableColumn<?, ?> emp_action_col;

    @FXML
    private TextField emp_email;

    @FXML
    private TableColumn<?, ?> emp_email_col;

    @FXML
    private TableColumn<?, ?> emp_empName_col;

    @FXML
    private TableColumn<?, ?> emp_employeeID_col;

    @FXML
    private ComboBox<?> emp_gender;

    @FXML
    private TextField emp_name;

    @FXML
    private TextField emp_phoneNo;

    @FXML
    private TableColumn<?, ?> emp_phoneNumber_col;

    @FXML
    private ComboBox<?> emp_position;

    @FXML
    private TableColumn<?, ?> emp_sal_empName_col;

    @FXML
    private TableColumn<?, ?> emp_sal_employeeID_col;

    @FXML
    private TableColumn<?, ?> emp_sal_phoneNumber_col;

    @FXML
    private TableColumn<?, ?> emp_sal_position_col;

    @FXML
    private TableColumn<?, ?> emp_sal_salary_col;

    @FXML
    private TextField emp_sal_search;

    @FXML
    private TextField emp_sal_search1;

    @FXML
    private TableColumn<?, ?> emp_sal_sno_col;

    @FXML
    private TableView<?> emp_sal_tableview;

    @FXML
    private TableView<?> emp_sal_tableview1;

    @FXML
    private AnchorPane emp_salary_list;

    @FXML
    private AnchorPane emp_salary_list1;

    @FXML
    private TableColumn<?, ?> emp_sno_col;

    @FXML
    private Button emp_upload_photo;

    @FXML
    private Button employeesalListBtn;

    @FXML
    private Button employeeListBtn;

    @FXML
    private Button logout;

    @FXML
    private Button employeeSalariesBtn;

    @FXML
    private TextField employee_sal_email;

    @FXML
    private TextField employee_sal_name;

    @FXML
    private TextField employee_sal_phone;

    @FXML
    private TextField employee_sal_salary;

    @FXML
    private Button taskLListBtn;

    @FXML
    private AnchorPane view_emp;

    @FXML
    private Button closeBtn;

    @FXML
    private Button minimizeBtn;

    @FXML
    private AnchorPane mainForm;

    public void close() {

        System.exit(0);
    }


    public void minimize()
    {

        Stage stage = (Stage) mainForm.getScene().getWindow();
        stage.setIconified(true);
    }

    public void switchForm(javafx.event.ActionEvent event) {
        // Reset visibility for all sections
        add_emp.setVisible(false);
        add_emp_salary.setVisible(false);
        emp_salary_list.setVisible(false);
        view_emp.setVisible(false);
        admin_dashboard.setVisible(false);

        // Reset 'active' class for all buttons
        resetActiveClasses();

        // Switch visibility and activate the appropriate button
        if (event.getSource() == addEmployeeBtn) {
            add_emp.setVisible(true);
            activateButton(addEmployeeBtn);
        } else if (event.getSource() == add_employee_sal) {
            add_emp_salary.setVisible(true);
            activateButton(employeeSalariesBtn);
        } else if (event.getSource() == dashboarbbtn) {
            admin_dashboard.setVisible(true);
            activateButton(dashboarbbtn);
        } else if (event.getSource() == EmployeeHolidaysBtn) {
            activateButton(EmployeeHolidaysBtn);
        } else if (event.getSource() == employeesalListBtn) {
            emp_salary_list.setVisible(true);
            activateButton(employeesalListBtn);
        } else if (event.getSource() == employeeListBtn) {
            view_emp.setVisible(true);
            activateButton(employeeListBtn);
        } else if (event.getSource() == employeeSalariesBtn) {
            emp_salary_list.setVisible(true);
            activateButton(employeeSalariesBtn);
        } else if (event.getSource() == taskLListBtn) {
            activateButton(taskLListBtn);
        }
    }

    // Helper Method: Reset 'active' classes for all buttons
    private void resetActiveClasses() {
        dashboarbbtn.getStyleClass().remove("active");
        addEmployeeBtn.getStyleClass().remove("active");
        EmployeeHolidaysBtn.getStyleClass().remove("active");
        employeesalListBtn.getStyleClass().remove("active");
        employeeListBtn.getStyleClass().remove("active");
        employeeSalariesBtn.getStyleClass().remove("active");
        taskLListBtn.getStyleClass().remove("active");
    }

    // Helper Method: Activate a specific button
    private void activateButton(Button button) {
        if (!button.getStyleClass().contains("active")) {
            button.getStyleClass().add("active");
        }
    }
    private double x = 0;
    private double y = 0;

    public void logout()
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");
        Optional<ButtonType> action = alert.showAndWait();
        try {
            if(action.get().equals(ButtonType.OK))
            {
                logout.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ems/View/Login.fxml"));
                Parent root = loader.load();  // Ensure root is correctly set in FXML
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }



}
