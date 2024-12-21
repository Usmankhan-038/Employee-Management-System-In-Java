package Controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javafx.scene.image.ImageView;
//import java.lang.classfile.Label;
import java.beans.Statement;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.*;

import static Model.database.connectDb;
import static java.lang.Integer.parseInt;

public class EmployeeDashboardController implements Initializable {
    @FXML
    private Button EmployeeHolidaysBtn;

    @FXML
    private Button addEmployeeBtn;

    @FXML
    private AnchorPane add_emp;

//    @FXML
//    private Button add_emp_btn;

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
    private Button updateButton;

    @FXML
    private Label dashboard_totalEmployee_Count;

    @FXML
    private Label dashboard_totalInactiveEmpolyee_Count;

    @FXML
    private Label dashboard_totalPresent_Count;

    @FXML
    private TableColumn<EmployeeData, String> emp_action_col;

    @FXML
    private TextField emp_email;

    @FXML
    private TextField emp_phone;

    @FXML
    private TableColumn<EmployeeData, String> emp_email_col;

    @FXML
    private TableColumn<EmployeeData, String> emp_empName_col;

    @FXML
    private TableColumn<EmployeeData, String> emp_employeeID_col;

    @FXML
    private ComboBox<String> emp_gender;

    @FXML
    private TextField emp_name;

    @FXML
    private TextField emp_phoneNo;

    @FXML
    private TableColumn<EmployeeData, String> emp_phoneNumber_col;

    @FXML
    private ComboBox<String> emp_leave_type;

    @FXML
    private ComboBox<String> emp_sal_name;

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
    private TableView<EmployeeData> emp_tableview;

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

    @FXML
    private Label emp_view_email;

    @FXML
    private Label emp_view_gender;

    @FXML
    private Label emp_view_name;

    @FXML
    private Label emp_view_phone;

    @FXML
    private Label emp_view_position;

    @FXML
    private DatePicker emp_leave_date;


    @FXML
    private TextArea emp_reason_leave;

    @FXML
    private Button emp_request_for_leave;

    @FXML
    private AnchorPane request_for_leave;



    private Image image;

    private Connection connect;
    private Statement statement;
    private PreparedStatement prepare;
    private ResultSet result;



//    public void addEmployeeAdd() {
//        String sql = "INSERT INTO employeesdata(name, email, phone, gender, position) VALUES(?,?,?,?,?)";
//        connect = connectDb();
//
//        try {
//            Alert alert;
//
//
//                alert = new Alert(Alert.AlertType.ERROR);
//                alert.setHeaderText("Error Message");
//                alert.setContentText("Please fill in all fields");
//                alert.showAndWait();
//                return;
//            }
//
//            String check = "SELECT * FROM employeesdata WHERE email = ?";
//            PreparedStatement preparedStatement = connect.prepareStatement(check);
//            preparedStatement.setString(1, emp_email.getText());
//            ResultSet result = preparedStatement.executeQuery();
//
//            if (result.next()) {
//                alert = new Alert(Alert.AlertType.ERROR);
//                alert.setHeaderText("Error Message");
//                alert.setContentText("Employee with email already exists");
//                alert.showAndWait();
//                return;
//            }
//
//            // Saving the employee details
//            prepare = connect.prepareStatement(sql);
//            prepare.setString(1, emp_name.getText());
//            prepare.setString(2, emp_email.getText());
//            prepare.setString(3, emp_phoneNo.getText());
//            prepare.setString(4, (String) emp_gender.getSelectionModel().getSelectedItem());
//            prepare.setString(5, (String) emp_position.getSelectionModel().getSelectedItem());
//            prepare.executeUpdate();
//
//            // Fetching the id of the employee
//            sql = "SELECT id FROM employeesdata WHERE email = ?";
//            prepare = connect.prepareStatement(sql);
//            prepare.setString(1, emp_email.getText());
//            result = prepare.executeQuery();
//
//            int id = 0;
//            if (result.next()) {
//                id = result.getInt("id");
//            } else {
//                throw new SQLException("Employee ID not found after insertion");
//            }
//
//            // Saving the image of the employee
//            String uri = getData.path.replace("\\", "\\\\");
//            String imageSql = "INSERT INTO documents(belong_id, belong_name, original_file_link, belong_type) VALUES(?,?,?,?)";
//            prepare = connect.prepareStatement(imageSql);
//            prepare.setInt(1, id);
//            prepare.setString(2, "employee");
//            prepare.setString(3, uri);
//            prepare.setString(4, "image");
//            prepare.executeUpdate();
//
//            alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setHeaderText("Information Message");
//            alert.setContentText("Employee added successfully");
//            alert.showAndWait();
////            addEmployeeshowList();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    private String[] leaveType = {"Annual Leave", "Sick Leave", "Casual Leave", "Maternity Leave", "Paternity Leave", "Study Leave", "Unpaid Leave", "Medical Leave","Compensatory Leave", "Other"};

    public void addLeaveType ()
    {
        List<String> listP = new ArrayList<String>();

        for(String text : leaveType)
        {
            listP.add(text);
        }
        ObservableList<String> observableList = FXCollections.observableList(listP);
        emp_leave_type.setItems(observableList);
    }
    private ArrayList<String> name;
    public void requestForLeave() {
        connect = connectDb();

        String selectQuery = "SELECT id FROM employeesdata WHERE name = ?";
        try {
            // Debugging: Check if emp_leave_date is initialized
            if (emp_leave_date == null) {
                System.out.println("emp_leave_date is not initialized");
                showAlert(Alert.AlertType.ERROR, "Error Message", "DatePicker is not properly connected.");
                return;
            }

            // Check if DatePicker value is null
            LocalDate leaveDate = emp_leave_date.getValue();
            if (leaveDate == null) {
                showAlert(Alert.AlertType.ERROR, "Error Message", "Please select a valid leave date.");
                return;
            }

            // Fetch employee ID
            PreparedStatement preparedStatement = connect.prepareStatement(selectQuery);
            preparedStatement.setString(1, getData.username.trim());
            result = preparedStatement.executeQuery();

            if (!result.next()) {
                showAlert(Alert.AlertType.ERROR, "Error Message", "Employee not found in the database.");
                return;
            }

            String employeeId = result.getString("id");

            // Insert leave details
            String salaryQuery = "INSERT INTO leaves (employee_id, leave_type, leave_date, reason) VALUES(?, ?, ?, ?)";
            preparedStatement = connect.prepareStatement(salaryQuery);
            preparedStatement.setString(1, employeeId);

            // Check if leave type is selected
            if (emp_leave_type.getSelectionModel().getSelectedItem() == null) {
                showAlert(Alert.AlertType.ERROR, "Error Message", "Please select a leave type.");
                return;
            }
            preparedStatement.setString(2, emp_leave_type.getSelectionModel().getSelectedItem().trim());

            // Set leave date
            preparedStatement.setString(3, leaveDate.toString());

            // Check if reason is valid
            String reason = emp_reason_leave.getText();
            if (reason == null || reason.trim().isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Error Message", "Please provide a reason for the leave.");
                return;
            }
            preparedStatement.setString(4, reason.trim());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                showAlert(Alert.AlertType.INFORMATION, "Information Message", "Employee leave added successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error Message", "Failed to add employee leave.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error Message", "An error occurred: " + e.getMessage());
        } finally {
            try {
                if (result != null) result.close();
                if (connect != null) connect.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }


    private void showAlert(Alert.AlertType alertType, String headerMessage, String contentMessage) {
        Alert alert = new Alert(alertType);
        alert.setHeaderText(headerMessage);
        alert.setContentText(contentMessage);
        alert.showAndWait();
    }


    public void addEmployeeSearch() {

//        FilteredList<EmployeeData> filter = new FilteredList<>(addEmployeeList, e -> true);
//        emp_sal_search1.textProperty().addListener((Observable, oldValue, newValue) -> {
//
//            filter.setPredicate(predicateEmployeeData -> {
//
//                if (newValue == null || newValue.isEmpty()) {
//                    return true;
//                }
//
//                String searchKey = newValue.toLowerCase();
//
//                if (predicateEmployeeData.getId().contains(searchKey)) {
//                    System.out.println(predicateEmployeeData.getId());
//
//                    return true;
//                } else if (predicateEmployeeData.getName().toLowerCase().contains(searchKey)) {
//                    return true;
//                } else if (predicateEmployeeData.getEmail().toLowerCase().contains(searchKey)) {
//                    return true;
//
//                } else if (predicateEmployeeData.getPhone().toLowerCase().contains(searchKey)) {
//                    return true;
//                }else {
//                    System.out.println("No match found");
//                    return false;
//
//                }
//            });
//        });
//        System.out.println(filter);
//        filter.forEach(System.out::println);
//
//        SortedList<EmployeeData> sortList = new SortedList<>(filter);
//
//        sortList.comparatorProperty().bind(emp_tableview.comparatorProperty());
//        emp_tableview.setItems(sortList);
    }
    private final String[] gender = {"male", "female"};
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
    public void updateProfile() {
        connect = connectDb(); // Assuming `connectDb()` establishes the DB connection

        try {
            // Fetch the current user (assuming username is stored in `getData.username`)
            String query = "SELECT * FROM employeesdata WHERE name = ?";
            PreparedStatement preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, getData.username.trim());
            result = preparedStatement.executeQuery();

            if (result.next()) {
                // Display the data in the form fields
                emp_name.setText(result.getString("name")); // Assuming TextField for Name
                emp_email.setText(result.getString("email")); // Assuming TextField for Email
                emp_phone.setText(result.getString("phone")); // Assuming TextField for Phone
                emp_gender.getSelectionModel().select(result.getString("gender")); // Assuming ComboBox for Gender
            } else {
                showAlert(Alert.AlertType.ERROR, "Error Message", "Employee not found.");
                return;
            }

            // Update logic
            updateButton.setOnAction(event -> {
                try {
                    String updateQuery = "UPDATE employeesdata SET name = ?, email = ?, phone = ?, gender = ? WHERE name = ?";
                    PreparedStatement updateStatement = connect.prepareStatement(updateQuery);

                    // Get updated data from the form fields
                    String updatedName = emp_name.getText().trim();
                    String updatedEmail = emp_email.getText().trim();
                    String updatedPhone = emp_phone.getText().trim();
                    String updatedGender = emp_gender.getSelectionModel().getSelectedItem();

                    // Validate inputs
                    if (updatedName.isEmpty() || updatedEmail.isEmpty() || updatedPhone.isEmpty() || updatedGender == null) {
                        showAlert(Alert.AlertType.ERROR, "Error Message", "All fields must be filled.");
                        return;
                    }

                    // Bind parameters
                    updateStatement.setString(1, updatedName);
                    updateStatement.setString(2, updatedEmail);
                    updateStatement.setString(3, updatedPhone);
                    updateStatement.setString(4, updatedGender);
                    updateStatement.setString(5, getData.username.trim()); // Match the original username

                    int rowsUpdated = updateStatement.executeUpdate();
                    if (rowsUpdated > 0) {
                        showAlert(Alert.AlertType.INFORMATION, "Success", "Profile updated successfully.");
                    } else {
                        showAlert(Alert.AlertType.ERROR, "Error Message", "Failed to update profile.");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    showAlert(Alert.AlertType.ERROR, "Error Message", "An error occurred: " + e.getMessage());
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error Message", "An error occurred: " + e.getMessage());
        } finally {
            try {
                if (result != null) result.close();
                if (connect != null) connect.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }


    public void close()
    {
        System.exit(0);
    }

    public void minimize()
    {

        Stage stage = (Stage) mainForm.getScene().getWindow();
        stage.setIconified(true);
    }

    public void switchForm(ActionEvent event) {
        // Reset visibility for all sections
        request_for_leave.setVisible(false);
        add_emp_salary.setVisible(false);
        emp_salary_list.setVisible(false);
        view_emp.setVisible(false);
        admin_dashboard.setVisible(false);
        emp_list.setVisible(false);

        // Reset 'active' class for all buttons
        resetActiveClasses();

        // Switch visibility and activate the appropriate button
        if (event.getSource() == addEmployeeBtn) {
            request_for_leave.setVisible(true);
            activateButton(addEmployeeBtn);

            addLeaveType();
            addEmployeeGender();



        } else if (event.getSource() == employeeSalariesBtn) {
            add_emp_salary.setVisible(true);
            activateButton(employeeSalariesBtn);
        } else if (event.getSource() == dashboarbbtn) {
            admin_dashboard.setVisible(true);
            activateButton(dashboarbbtn);
        } else if (event.getSource() == EmployeeHolidaysBtn) {
            activateButton(EmployeeHolidaysBtn);
        } else if (event.getSource() == employeesalListBtn)
        {
            emp_salary_list.setVisible(true);
            activateButton(employeesalListBtn);


        }
        else if (event.getSource() == employeeListBtn) {
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
        username.setText(getData.username);
        addLeaveType();
        addEmployeeGender();


    }



}
