package Controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javafx.scene.image.ImageView;
//import java.lang.classfile.Label;
import java.beans.Statement;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static Model.database.connectDb;

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
    private TableColumn<?, String> emp_action_col;

    @FXML
    private TextField emp_email;

    @FXML
    private TableColumn<EmployeeData, String> emp_email_col;

    @FXML
    private TableColumn<EmployeeData, String> emp_empName_col;

    @FXML
    private TableColumn<?, ?> emp_employeeID_col;

    @FXML
    private ComboBox<String> emp_gender;

    @FXML
    private TextField emp_name;

    @FXML
    private TextField emp_phoneNo;

    @FXML
    private TableColumn<EmployeeData, String> emp_phoneNumber_col;

    @FXML
    private ComboBox<String> emp_position;

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
    private TableView<EmployeeData> emp_sal_tableview;

    @FXML
    private TableView<?> emp_tableview;

    @FXML
    private AnchorPane emp_salary_list;

    @FXML
    private AnchorPane emp_list;

    @FXML
    private TableColumn<EmployeeData, String> emp_sno_col;

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

    @FXML
    private Label username;

    private Image image;

    private Connection connect;
    private Statement statement;
    private PreparedStatement prepare;
    private ResultSet result;


    private String[] positions = {"Manager", "Supervisor", "Employee"};
    private String[] gender = {"male", "female"};

    public void addEmployeePosition ()
    {
        List<String> listP = new ArrayList<String>();

        for(String text : positions)
        {
            listP.add(text);
        }
        ObservableList<String> observableList = FXCollections.observableList(listP);
        emp_position.setItems(observableList);
    }

    public void addEmployeeGender ()
    {
        List<String> listG = new ArrayList<String>();

        for(String text : gender)
        {
            listG.add(text);
        }
        ObservableList<String> observableList = FXCollections.observableList(listG);
        emp_gender.setItems(observableList);

    }
    public void addEmployeeAdd() {
        String sql = "INSERT INTO employeesdata(name, email, phone, gender, position) VALUES(?,?,?,?,?)";
        connect = connectDb();

        try {
            Alert alert;
            if (emp_name.getText().isEmpty() || emp_email.getText().isEmpty() || emp_phoneNo.getText().isEmpty() ||
                    emp_gender.getSelectionModel().getSelectedItem() == null || emp_position.getSelectionModel().getSelectedItem() == null) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Error Message");
                alert.setContentText("Please fill in all fields");
                alert.showAndWait();
                return;
            }

            String check = "SELECT * FROM employeesdata WHERE email = ?";
            PreparedStatement preparedStatement = connect.prepareStatement(check);
            preparedStatement.setString(1, emp_email.getText());
            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Error Message");
                alert.setContentText("Employee with email already exists");
                alert.showAndWait();
                return;
            }

            // Saving the employee details
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, emp_name.getText());
            prepare.setString(2, emp_email.getText());
            prepare.setString(3, emp_phoneNo.getText());
            prepare.setString(4, (String) emp_gender.getSelectionModel().getSelectedItem());
            prepare.setString(5, (String) emp_position.getSelectionModel().getSelectedItem());
            prepare.executeUpdate();

            // Fetching the id of the employee
            sql = "SELECT id FROM employeesdata WHERE email = ?";
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, emp_email.getText());
            result = prepare.executeQuery();

            int id = 0;
            if (result.next()) {
                id = result.getInt("id");
            } else {
                throw new SQLException("Employee ID not found after insertion");
            }

            // Saving the image of the employee
            String uri = getData.path.replace("\\", "\\\\");
            String imageSql = "INSERT INTO documents(belong_id, belong_name, original_file_link, belong_type) VALUES(?,?,?,?)";
            prepare = connect.prepareStatement(imageSql);
            prepare.setInt(1, id);
            prepare.setString(2, "employee");
            prepare.setString(3, uri);
            prepare.setString(4, "image");
            prepare.executeUpdate();

            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Information Message");
            alert.setContentText("Employee added successfully");
            alert.showAndWait();
            addEmployeeshowList();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addEmployeeInsertImage(){
        FileChooser open = new FileChooser();
        open.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Images", "*.jpg", "*.png"));
        File file = open.showOpenDialog(mainForm.getScene().getWindow());

        if(file != null){
            getData.path = file.getAbsolutePath();
            image = new Image(file.toURI().toString(), 100, 150, true, true);
            add_emp_image_view.setImage(image);
        }

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
            emp_list.setVisible(true);
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


    public void displayUsername()
    {
        username.setText(getData.username);

    }

    public ObservableList<EmployeeData> addEmployeeListdata() {
        ObservableList<EmployeeData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM employees";
        connect = connectDb(); // Ensure connectDb() establishes a database connection

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                // Create a HashMap to store the employee data
                HashMap<String, String> employeeData = new HashMap<>();
                employeeData.put("name", result.getString("name"));
                employeeData.put("email", result.getString("email"));
                employeeData.put("phone", result.getString("phone"));
                employeeData.put("gender", result.getString("gender"));
                employeeData.put("position", result.getString("position"));

                // Create an EmployeeData object and populate it with the HashMap
                EmployeeData data = new EmployeeData();
                data.EmployeeData(employeeData); // Call the method to set employee data

                // Add the EmployeeData object to the list
                listData.add(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources to prevent memory leaks
            try {
                if (result != null) result.close();
                if (prepare != null) prepare.close();
                if (connect != null) connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listData;
    }
    public void close() {

        System.exit(0);
    }
    ObservableList<EmployeeData> addEmployeeList;
    public void addEmployeeshowList()
    {
        addEmployeeList = addEmployeeListdata();
        emp_sno_col.setCellValueFactory(new PropertyValueFactory<>("sno"));
        emp_empName_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        emp_email_col.setCellValueFactory(new PropertyValueFactory<>("email"));
        emp_phoneNumber_col.setCellValueFactory(new PropertyValueFactory<>("phone"));
        emp_action_col.setText("View");

    }

    public void addEmpoyeeSelect()
    {
        EmployeeData employeeData = emp_sal_tableview.getSelectionModel().getSelectedItem();
        int num = emp_tableview.getSelectionModel().getSelectedIndex();
        HashMap<String, String> employeeInfo =  employeeData.getEmployeeData();
        if((num -1)< -1)
        {
            return;
        }

        emp_name.setText(String.valueOf(employeeInfo.get("name")));
        emp_email.setText(String.valueOf(employeeInfo.get("email")));
        emp_phoneNo.setText(String.valueOf(employeeInfo.get("phone")));
        emp_email.setText(String.valueOf(employeeInfo.get("email")));

        String uri = "file:"+add_emp_image_view.getImage();
        image = new Image(uri,101,150,false,true);
        add_emp_image_view.setImage(image);
    }

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
        addEmployeeshowList();
        displayUsername();
        addEmployeePosition();
        addEmployeeGender();
    }



}
