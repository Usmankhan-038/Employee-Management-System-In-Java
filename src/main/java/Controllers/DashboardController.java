package Controllers;


import Model.database;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
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
import java.time.LocalDate;
import java.util.*;

import static Model.database.connectDb;
import static java.lang.Integer.parseInt;

public class DashboardController implements Initializable {

    @FXML
    private TextArea attend_comments;

    @FXML
    private DatePicker attend_date;

    @FXML
    private Button EmployeeHolidaysBtn;

    @FXML
    private Button addEmployeeBtn;

    @FXML
    private Button approve_request;

    @FXML
    private Button attendence;


    @FXML
    private Button reject_request;

    @FXML
    private Button markAttendenceBtn;

    @FXML
    private AnchorPane add_emp;

    @FXML
    private AnchorPane view_profile;

    @FXML
    private Button add_emp_btn;

    @FXML
    private AnchorPane leave_request_screen;



    @FXML
    private AnchorPane mark_attendence;

    @FXML
    private AnchorPane add_emp_image;

    @FXML
    private AnchorPane mark_attendence_list;

    @FXML
    private ImageView add_emp_image_view;

    @FXML
    private AnchorPane add_emp_salary;

    @FXML
    private Button add_employee_sal;

    @FXML
    private Button viewProfileBtn;

    @FXML
    private AnchorPane admin_dashboard;

    @FXML
    private BarChart<?, ?> admin_dashboard_cart;

    @FXML
    private AnchorPane view_leave_request;

    @FXML
    private Button dashboarbbtn;

    @FXML
    private Label dashboard_totalEmployee_Count;

    @FXML
    private Label dashboard_totalInactiveEmpolyee_Count;

    @FXML
    private Label dashboard_totalPresent_Count1;

    @FXML
    private Label dashboard_totalPendingRequest_Count;



    @FXML
    private TableColumn<EmployeeData, String> emp_action_col;

    @FXML
    private TextField emp_email;

    @FXML
    private TableColumn<EmployeeData, String> emp_email_col;

    @FXML
    private TableColumn<EmployeeData, String> emp_empName_col;

    @FXML
    private TableColumn<EmployeeData, String> emp_employeeID_col;


    @FXML
    private TableColumn<Attendence, String> attend_sno;

    @FXML
    private TableColumn<Attendence, String> attend_empID;

    @FXML
    private TableColumn<Attendence, String> attend_emp_name;

    @FXML
    private TableColumn<Attendence, String> attend_emp_phone;

    @FXML
    private TableColumn<Attendence, String> attend_onLeave;

    @FXML
    private TableColumn<Attendence, String> emp_action_col1;

    @FXML
    private TableColumn<Leave, String> leave_request_action;

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
    private TableColumn<Leave, String> emp_leaveID_col;


    @FXML
    private TableColumn<Leave, String> emp_emp_name_col;


    @FXML
    private TableColumn<Leave, String> emp_leaveType_col;


    @FXML
    private TableColumn<Leave, String> emp_leaveDate_col;

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
    private TableView<Attendence> attendanceTableView;

    @FXML
    private TableView<Leave> leave_request_tableview;
    @FXML
    private TableView<EmployeeData> emp_tableview;


    @FXML
    private TableColumn<Leave, String> leave_sno;
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
    private TextField medical_allownace;

    @FXML
    private TextField tax;

    @FXML
    private TextField employee_sal_name;

    @FXML
    private TextField employee_sal_phone;

    @FXML
    private TextField employee_sal_salary;



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
    private Label emp_leave_name;


    @FXML
    private Label emp_leave_email;

    @FXML
    private Label emp_leave_phone;

    @FXML
    private Label emp_leave_status;

    @FXML
    private Label emp_leave_gender;

    @FXML
    private Label emp_leave_position;

    @FXML
    private Label emp_leave_Type;

    @FXML
    private Label emp_leave_date;

    @FXML
    private Label emp_leave_reason;

    @FXML
    private Label total_leave_rejected;

    @FXML
    private Label total_leave_approved;

    @FXML
    private Label total_employee;


    @FXML
    private Label emp_view_name;

    @FXML
    private Label emp_view_phone;

    @FXML
    private Label emp_view_position;

    @FXML
    private Label emp_view_name1;

    @FXML
    private Label emp_view_phone1;

    @FXML
    private Label emp_view_position1;

    @FXML
    private Label emp_view_gender1;

    @FXML
    private Label emp_view_email1;

    @FXML
    private AnchorPane emp_pane;

    @FXML
    private AnchorPane total_leave_pane;

    @FXML
    private AnchorPane total_reject_pane;


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


    private ArrayList<String> name;
    public void addEmployeeSalAdd() {
        connect = connectDb();
        String selectQuery = "SELECT id FROM employeesdata WHERE name = ?";

        try {
            // Ensure an employee name is selected
            if (emp_sal_name.getSelectionModel().getSelectedItem() == null) {
                showAlert(Alert.AlertType.ERROR, "Error Message", "Please select an employee name.");
                return;
            }

            // Ensure all fields are filled
            if (employee_sal_phone.getText().isEmpty() ||
                    employee_sal_email.getText().isEmpty() ||
                    employee_sal_salary.getText().isEmpty()) {

                showAlert(Alert.AlertType.ERROR, "Error Message", "Please fill in all fields.");
                return;
            }

            // Fetch employee ID based on the selected name
            PreparedStatement preparedStatement = connect.prepareStatement(selectQuery);
            preparedStatement.setString(1, emp_sal_name.getSelectionModel().getSelectedItem().trim());
            ResultSet result = preparedStatement.executeQuery();

            if (!result.next()) {
                showAlert(Alert.AlertType.ERROR, "Error Message", "Employee not found in the database.");
                return;
            }

            String employeeId = result.getString("id");

            // Check if salary for the employee already exists
            String checkQuery = "SELECT * FROM salaries_and_taxes WHERE employee_id = ?";
            preparedStatement = connect.prepareStatement(checkQuery);
            preparedStatement.setString(1, employeeId);
            ResultSet resultCheck = preparedStatement.executeQuery();

            if (resultCheck.next()) {
                showAlert(Alert.AlertType.ERROR, "Error Message", "Employee salary already exists.");
                return;
            }

            // Insert salary and taxes for the employee
            String salaryQuery = "INSERT INTO salaries_and_taxes(employee_id, salary,tax_deduction,medical_allowance) VALUES(?, ?,?, ?)";
            preparedStatement = connect.prepareStatement(salaryQuery);
            preparedStatement.setString(1, employeeId);
            preparedStatement.setString(2, employee_sal_salary.getText().trim());
            preparedStatement.setString(3, tax.getText().trim() != null ? tax.getText().trim() : "0");
            preparedStatement.setString(4, medical_allownace.getText().trim() != null ? medical_allownace.getText().trim() : "0");

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                showAlert(Alert.AlertType.INFORMATION, "Information Message", "Employee salary added successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error Message", "Failed to add employee salary.");
            }

            // Refresh employee list
            addEmployeeSalaryshowList();

        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error Message", "Please Fill All the Fields ");
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

    public void addEmployeeName() {
        ObservableList<String> name = FXCollections.observableArrayList();

        try {
            String sql = "SELECT name FROM employeesdata";
            connect = connectDb();

            if (connect != null) {
                prepare = connect.prepareStatement(sql);
                result = prepare.executeQuery();

                while (result.next()) {
                    name.add(result.getString("name"));
                    System.out.println("Fetched Name: " + result.getString("name")); // Debug log
                }

                // Bind the list to the ComboBox.
                emp_sal_name.setItems(name);

                // Add listener to ComboBox to handle selection changes
                emp_sal_name.setOnAction(event -> {
                    addEmployeeSalaryData();
                });
            } else {
                System.err.println("Database connection failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) result.close();
                if (prepare != null) prepare.close();
                if (connect != null) connect.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void addEmployeeSalaryData() {
        try {
            connect = connectDb();
            String selectQuery = "SELECT * FROM employeesdata WHERE name = ?";
            PreparedStatement preparedStatement = connect.prepareStatement(selectQuery);
            preparedStatement.setString(1, emp_sal_name.getSelectionModel().getSelectedItem()); // Selected name from ComboBox
            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                employee_sal_phone.setText(result.getString("phone"));
                employee_sal_email.setText(result.getString("email"));
                employee_sal_email.setDisable(true);
                employee_sal_phone.setDisable(true);
            } else {
//                showAlert(Alert.AlertType.ERROR, "Error Message", "Employee not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
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
        resetSectionVisibility();

        // Reset 'active' class for all buttons
        resetActiveClasses();

        // Switch visibility and activate the appropriate button
        if (event.getSource() == addEmployeeBtn) {
            add_emp.setVisible(true);
            activateButton(addEmployeeBtn);
            addEmployeePosition();
            addEmployeeGender();
            addEmployeeSearch();
        } else if (event.getSource() == employeeSalariesBtn) {
            add_emp_salary.setVisible(true);
            activateButton(employeeSalariesBtn);
        } else if (event.getSource() == dashboarbbtn) {
            admin_dashboard.setVisible(true);
            activateButton(dashboarbbtn);
        } else if (event.getSource() == employeesalListBtn) {
            emp_salary_list.setVisible(true);
            activateButton(employeesalListBtn);
        } else if (event.getSource() == employeeListBtn) {
            emp_list.setVisible(true);
            activateButton(employeeListBtn);
            addEmployeeshowList();
        } else if (event.getSource() == EmployeeHolidaysBtn) {
            leave_request_screen.setVisible(true);
            activateButton(EmployeeHolidaysBtn);
            addLeaveRequestList();
        } else if (event.getSource() == viewProfileBtn) {
            System.out.println("View Profile button clicked"); // Debug statement
            view_profile.setVisible(true);
            activateButton(viewProfileBtn);
            profile();
        } else if (event.getSource() == attendence) {
            mark_attendence.setVisible(true);
            activateButton(attendence);
            markAttendenceList();
            // Uncomment if markAttendenceList() is needed
            // markAttendenceList();
        }
    }

    // Helper Method: Reset visibility for all sections
    private void resetSectionVisibility() {
        add_emp.setVisible(false);
        add_emp_salary.setVisible(false);
        emp_salary_list.setVisible(false);
        view_emp.setVisible(false);
        admin_dashboard.setVisible(false);
        emp_list.setVisible(false);
        leave_request_screen.setVisible(false);
        view_leave_request.setVisible(false);
        view_profile.setVisible(false);
        mark_attendence.setVisible(false);
        mark_attendence_list.setVisible(false);
    }

    // Helper Method: Reset 'active' classes for all buttons
    private void resetActiveClasses() {
        dashboarbbtn.getStyleClass().remove("active");
        addEmployeeBtn.getStyleClass().remove("active");
        EmployeeHolidaysBtn.getStyleClass().remove("active");
        employeesalListBtn.getStyleClass().remove("active");
        employeeListBtn.getStyleClass().remove("active");
        employeeSalariesBtn.getStyleClass().remove("active");
        viewProfileBtn.getStyleClass().remove("active");
        attendence.getStyleClass().remove("active");
    }

    // Helper Method: Activate a button




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

    public ObservableList<EmployeeData> addEmployeeSalListdata() {
        ObservableList<EmployeeData> listData = FXCollections.observableArrayList();

        // Correct SQL Query
        String sql = "SELECT S.employee_id, S.salary, E.name, E.phone, E.position " +
                "FROM salaries_and_taxes AS S " +
                "LEFT JOIN employeesdata AS E ON S.employee_id = E.id";

        connect = connectDb(); // Assuming connectDb() establishes the connection.

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            int sno = 1; // Serial Number
            while (result.next()) {
                HashMap<String, String> employee = new HashMap<>();

                // Format Employee ID
                String empId = "";
                String employeeId = result.getString("employee_id");
                if (employeeId != null && !employeeId.isEmpty()) {
                    empId = (Integer.parseInt(employeeId) < 10) ?
                            "EMP-0" + employeeId :
                            "EMP-" + employeeId;
                }

                // Populate Employee Data
                employee.put("sno", String.valueOf(sno++));
                employee.put("id", empId);
                employee.put("name", result.getString("name") != null ? result.getString("name") : "N/A");
                employee.put("phone", result.getString("phone") != null ? result.getString("phone") : "N/A");
                employee.put("position", result.getString("position") != null ? result.getString("position") : "N/A");
                employee.put("salary", String.format("%.2f", result.getDouble("salary")));


                // Add to EmployeeData object
                EmployeeData employeeD = new EmployeeData(employee);
                listData.add(employeeD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
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

    private ObservableList<EmployeeData> addEmployeeSalList = FXCollections.observableArrayList();
    public void addEmployeeSalaryshowList() {
        addEmployeeSalList = addEmployeeSalListdata();

        emp_sal_sno_col.setCellValueFactory(new PropertyValueFactory<>("sno"));
        emp_sal_employeeID_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        emp_sal_empName_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        emp_sal_phoneNumber_col.setCellValueFactory(new PropertyValueFactory<>("phone"));
        emp_sal_position_col.setCellValueFactory(new PropertyValueFactory<>("position"));
        emp_sal_salary_col.setCellValueFactory(new PropertyValueFactory<>("salary"));




        emp_sal_tableview.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        emp_email_col.setPrefWidth(250);
        emp_employeeID_col.setPrefWidth(50);
        emp_sal_tableview.setItems(addEmployeeSalList);

        System.out.println(addEmployeeList);
    }

    public ObservableList<EmployeeData> addEmployeeListdata() {
        ObservableList<EmployeeData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM employeesdata";
        connect = connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            int sno = 1;
            String empId = "";
            while (result.next()) {
                HashMap<String, String> employee = new HashMap<>();
                if(!(result.getString("id").isEmpty()))
                {
                    if (Integer.parseInt(result.getString("id")) < 10) {
                        empId = "EMP-0" + result.getString("id");
                    } else {
                        empId = "EMP-"+result.getString("id");
                    }
                }

                employee.put("sno", String.valueOf(sno++));
                employee.put("id", result.getString("id"));
                employee.put("name", result.getString("name"));
                employee.put("email", result.getString("email"));
                employee.put("phone", result.getString("phone"));
                employee.put("position", result.getString("position"));
                employee.put("gender", result.getString("gender"));
                employee.put("action", "View");

                EmployeeData employeeD = new EmployeeData(employee);
                listData.add(employeeD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
    private ObservableList<EmployeeData> addEmployeeList = FXCollections.observableArrayList();
    public void addEmployeeshowList() {
        addEmployeeList = addEmployeeListdata();

        emp_sno_col.setCellValueFactory(new PropertyValueFactory<>("sno"));
        emp_employeeID_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        emp_empName_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        emp_email_col.setCellValueFactory(new PropertyValueFactory<>("email"));
        emp_phoneNumber_col.setCellValueFactory(new PropertyValueFactory<>("phone"));
        emp_action_col.setCellFactory(tc -> new TableCell<EmployeeData, String>() {
            private final Button btnView = new Button("View");
            private final Button btnEdit = new Button("Edit");
            private final Button btndelete = new Button("Delete");
            private final HBox actionButtons = new HBox(12); // Adjust spacing between buttons

            {
                actionButtons.getChildren().addAll(btnView, btnEdit);
            }

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    EmployeeData employee = getTableView().getItems().get(getIndex());

                    btnView.setOnAction(e -> {
                        System.out.println("View details for: " + employee.getName());
                        emp_view_name.setText(employee.getName());
                        emp_view_email.setText(employee.getEmail());
                        emp_view_phone.setText(employee.getPhone());
                        emp_view_position.setText(employee.getPosition());
                        emp_view_gender.setText(employee.getGender());
                        view_emp.setVisible(true);
                        emp_list.setVisible(false);
                    });

                    btnEdit.setOnAction(e -> {
                        System.out.println("Edit details for: " + employee.getName());
                        // Add custom logic to edit employee details.
                    });

                    btnView.getStyleClass().add("view-button");
                    btnEdit.getStyleClass().add("view-button");
//                    btndelete.getStyleClass().add("view-button");

                    setGraphic(actionButtons);
                }
            }
        });


        emp_tableview.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        emp_tableview.setItems(addEmployeeSalList);

        System.out.println(addEmployeeSalList);
    }

    // Leave Request Screen Function

    public ObservableList<Leave> leaveRequest() {
        ObservableList<Leave> listData = FXCollections.observableArrayList();
        String sql = "SELECT empdata.id AS employee_id, empdata.name AS employee_name, empdata.phone, empdata.email, empdata.gender, empdata.position, " +
                "leaves.id AS leave_id, leaves.leave_type, leaves.leave_date, leaves.reason, leaves.approved, leaves.reject " +
                "FROM employeesdata AS empdata " +
                "RIGHT JOIN leaves ON empdata.id = leaves.employee_id";
        connect = connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            int sno = 1;
            while (result.next()) {
                HashMap<String, String> leaveData = new HashMap<>();
                leaveData.put("sno", String.valueOf(sno++));
                leaveData.put("leave_id", result.getString("leave_id"));
                leaveData.put("emp_id", result.getString("employee_id"));
                leaveData.put("emp_name", result.getString("employee_name"));
                leaveData.put("leave_type", result.getString("leave_type"));
                leaveData.put("leave_date", result.getString("leave_date"));
                leaveData.put("reason", result.getString("reason"));
                leaveData.put("email", result.getString("email"));
                leaveData.put("id", result.getString("employee_id"));
                leaveData.put("phone", result.getString("phone"));
                leaveData.put("gender", result.getString("gender"));
                leaveData.put("position", result.getString("position"));
                leaveData.put("isApproved", result.getString("approved"));
                leaveData.put("isRejected", result.getString("reject"));

                Leave leaveD = new Leave(leaveData);
                listData.add(leaveD);




                // Store or use empD as needed
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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

    private ObservableList<Leave> leaveRequestList = FXCollections.observableArrayList();

    public void addLeaveRequestList() {
        leaveRequestList = leaveRequest();

        // Map table columns to Leave object properties
        leave_sno.setCellValueFactory(new PropertyValueFactory<>("sno"));
        emp_leaveID_col.setCellValueFactory(new PropertyValueFactory<>("leaveId"));
        emp_emp_name_col.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        emp_leaveType_col.setCellValueFactory(new PropertyValueFactory<>("leaveType"));
        emp_leaveDate_col.setCellValueFactory(new PropertyValueFactory<>("leaveDate"));

        leave_request_action.setCellFactory(tc -> new TableCell<Leave, String>() {
            private final Button btnView = new Button("View");
            private final HBox actionButtons = new HBox(10); // Adjust spacing if needed

            {
                actionButtons.getChildren().addAll(btnView);
            }

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                } else {
                    Leave leave = getTableView().getItems().get(getIndex());
                    approve_request.setDisable(false);
                    reject_request.setDisable(false);


                    btnView.setOnAction(e -> {

                        String sqlQuery = "SELECT empdata.id AS employee_id, empdata.name AS employee_name, empdata.phone, empdata.email, empdata.gender, empdata.position, " +
                                "leaves.id AS leave_id, leaves.leave_type, leaves.leave_date, leaves.reason, leaves.approved, leaves.reject " +
                                "FROM employeesdata AS empdata " +
                                "RIGHT JOIN leaves ON empdata.id = leaves.employee_id WHERE leaves.id = ?";
                        connect = connectDb();

                        try {
                            prepare = connect.prepareStatement(sqlQuery);
                            prepare.setInt(1, leave.getLeaveId()); // Use parameterized query to prevent SQL injection
                            result = prepare.executeQuery();

                            if (result.next()) { // Check if a record is returned
                                // Set status based on "approved" and "rejected" fields
                                String approved = result.getString("approved");
                                String rejected = result.getString("reject");

                                if ("1".equals(approved)) {
                                    approve_request.setDisable(true);
                                    reject_request.setDisable(true);
                                    emp_leave_status.setText("Approved");
                                    emp_leave_status.setStyle("-fx-text-fill: green;");
                                } else if ("1".equals(rejected)) {
                                    approve_request.setDisable(true);
                                    reject_request.setDisable(true);
                                    emp_leave_status.setText("Rejected");
                                    emp_leave_status.setStyle("-fx-text-fill: red;");
                                } else {
                                    emp_leave_status.setText("Pending");
                                    emp_leave_status.setStyle("-fx-text-fill: orange;");
                                }
                            } else {
                                System.out.println("No record found for leave ID: " + leave.getLeaveId());
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        } finally {
                            try {
                                if (result != null) result.close();
                                if (prepare != null) prepare.close();
                                if (connect != null) connect.close();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                        // Bind approve and reject actions dynamically
                        approve_request.setOnAction(approveEvent -> {
                            approveLeave(leave.getLeaveId());
                            refreshLeaveRequestList(); // Refresh the table view after updating
                        });

                        reject_request.setOnAction(rejectEvent -> {
                            rejectLeave(leave.getLeaveId());
                            refreshLeaveRequestList(); // Refresh the table view after updating
                        });

                        System.out.println("Viewing details for: " + leave.getEmployeeName());

                        // Display leave details in the corresponding UI fields
                        emp_leave_name.setText(leave.getEmployeeName());
                        emp_leave_email.setText(leave.getEmail());
                        emp_leave_phone.setText(leave.getPhone());
                        emp_leave_gender.setText(leave.getGender());
                        emp_leave_position.setText(leave.getPosition());
                        emp_leave_Type.setText(leave.getLeaveType());
                        emp_leave_date.setText(leave.getLeaveDate());
                        emp_leave_reason.setText(leave.getLeaveReason());

                        // Show and hide panels
                        view_leave_request.setVisible(true);
                        leave_request_screen.setVisible(false);
                    });

                    // Optional: Style buttons
                    btnView.getStyleClass().add("view-button");

                    setGraphic(actionButtons);
                }
            }
        });

        leave_request_tableview.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        leave_request_tableview.setItems(leaveRequestList);

        System.out.println("Leave Request List: " + leaveRequestList);
    }


    // Update the status of a leave to "approved"
    public void approveLeave(int leaveId) {
        String updateQuery = "UPDATE leaves SET approved = 1, reject = 0 WHERE id = ?";
        String idQuery = "SELECT employee_id,leave_date FROM leaves WHERE id = ?";
        String notificationQuery = "INSERT INTO notifications (employee_id, alerts) VALUES (?, ?)";
        connect = connectDb();

        try {
            // Get employee_id associated with the leave
            PreparedStatement idStatement = connect.prepareStatement(idQuery);
            idStatement.setInt(1, leaveId);
            ResultSet resultSet = idStatement.executeQuery();

            if (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");

                // Update leave status
                PreparedStatement updateStatement = connect.prepareStatement(updateQuery);
                updateStatement.setInt(1, leaveId);
                updateStatement.executeUpdate();

                // Insert notification
                PreparedStatement notificationStatement = connect.prepareStatement(notificationQuery);
                notificationStatement.setInt(1, employeeId);
                notificationStatement.setString(2, "Your leave request (ID: LR-" + leaveId + ") for Date: "+resultSet.getString("leave_date")+" has been approved.");
                notificationStatement.executeUpdate();
                showAlert(Alert.AlertType.INFORMATION, "Request Approved", "Request Approved Successfully!");
                view_leave_request.setVisible(false);
                leave_request_screen.setVisible(true);
                System.out.println("Leave approved and notification added.");
            } else {
                System.out.println("No employee found for the given leave ID: " + leaveId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connect != null) connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    // Update the status of a leave to "rejected"
    public void rejectLeave(int leaveId) {
        String updateQuery = "UPDATE leaves SET approved = 0, reject = 1 WHERE id = ?";
        String idQuery = "SELECT employee_id,leave_date FROM leaves WHERE id = ?";
        String notificationQuery = "INSERT INTO notifications (employee_id, alerts) VALUES (?, ?)";
        connect = connectDb();

        try {
            // Get employee_id associated with the leave
            PreparedStatement idStatement = connect.prepareStatement(idQuery);
            idStatement.setInt(1, leaveId);
            ResultSet resultSet = idStatement.executeQuery();

            if (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");

                // Update leave status
                PreparedStatement updateStatement = connect.prepareStatement(updateQuery);
                updateStatement.setInt(1, leaveId);
                updateStatement.executeUpdate();

                // Insert notification
                PreparedStatement notificationStatement = connect.prepareStatement(notificationQuery);
                notificationStatement.setInt(1, employeeId);
                notificationStatement.setString(2, "Your leave request (ID: LR-" + leaveId + ") for Date: "+resultSet.getString("leave_date")+" has been rejected.");
                notificationStatement.executeUpdate();
                showAlert(Alert.AlertType.INFORMATION, "Request Rejected", "Request Rejected Successfully!");
                view_leave_request.setVisible(false);
                leave_request_screen.setVisible(true);
                System.out.println("Leave rejected and notification added.");
            } else {
                System.out.println("No employee found for the given leave ID: " + leaveId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connect != null) connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Refresh the leave request list
    public void refreshLeaveRequestList() {
        leaveRequestList.clear(); // Clear the current list
        leaveRequestList.addAll(leaveRequest()); // Add the updated data to the existing list
        leave_request_tableview.refresh(); // Refresh the TableView to reflect changes
    }


    public void profile()
    {
        connect = connectDb(); // Establish DB connection

        try {
            // Fetch the current user (assuming username is stored in `getData.username`)
            String query = "SELECT * FROM employeesdata WHERE name = ?";
            PreparedStatement preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, getData.username.trim());
            result = preparedStatement.executeQuery();

            if (result.next()) {
                // Display the data in the form fields
                emp_view_name1.setText(result.getString("name"));
                emp_view_email1.setText(result.getString("email"));
                emp_view_phone1.setText(result.getString("phone"));
                emp_view_gender1.setText(result.getString("gender"));
                emp_view_position1.setText(result.getString("position"));
            } else {
                showAlert(Alert.AlertType.ERROR, "Error Message", "Employee not found.");
                return;
            }

            // Update logic


        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error Message", "An error occurred: " + e.getMessage());
        } finally {
            try {
                if (result != null) result.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            // Do NOT close `connect` here as it's needed for the update action
        }
    }


    private void rejectLeave(String leaveId) {
        String sql = "UPDATE leaves SET reject" +
                " = 1 WHERE id = ?";
        try {
            connect = connectDb();
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, leaveId);
            int rowsAffected = prepare.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Leave ID " + leaveId + " rejected successfully.");
                // Disable the buttons after rejection
                approve_request.setDisable(true);
                reject_request.setDisable(true);

                // Optionally, show a status message
                emp_leave_status.setText("Rejected");
                emp_leave_status.setStyle("-fx-text-fill: red;"); // Change text color to red for rejection
            } else {
                System.out.println("Failed to reject leave ID " + leaveId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (prepare != null) prepare.close();
                if (connect != null) connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void addEmployeeSearch() {

        FilteredList<EmployeeData> filter = new FilteredList<>(addEmployeeList, e -> true);
        emp_sal_search1.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateEmployeeData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateEmployeeData.getId().contains(searchKey)) {
                    System.out.println(predicateEmployeeData.getId());

                    return true;
                } else if (predicateEmployeeData.getName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateEmployeeData.getEmail().toLowerCase().contains(searchKey)) {
                    return true;

                } else if (predicateEmployeeData.getPhone().toLowerCase().contains(searchKey)) {
                    return true;
                }else {
                    System.out.println("No match found");
                    return false;

                }
            });
        });
        System.out.println(filter);
        filter.forEach(System.out::println);

        SortedList<EmployeeData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(emp_tableview.comparatorProperty());
        emp_tableview.setItems(sortList);
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



//    private ArrayList<String> name;
public void markAttendence() {
    connect = connectDb();

    try {
        // Check if the date already exists in the database
        String checkQuery = "SELECT COUNT(*) FROM attendence WHERE date = ?";
        PreparedStatement checkStatement = connect.prepareStatement(checkQuery);
        checkStatement.setString(1, attend_date.getValue().toString());
        ResultSet result = checkStatement.executeQuery();

        if (result.next() && result.getInt(1) > 0) {
            // Attendance for the given date already exists
            showAlert(Alert.AlertType.WARNING, "Warning Message", "Attendance for this date is already marked.");
        } else {
            // Insert new attendance record
            String insertQuery = "INSERT INTO attendence (date, comments) VALUES(?, ?)";
            PreparedStatement insertStatement = connect.prepareStatement(insertQuery);
            insertStatement.setString(1, attend_date.getValue().toString());
            insertStatement.setString(2, attend_comments.getText().trim());

            int rowsInserted = insertStatement.executeUpdate();
            if (rowsInserted > 0) {
                showAlert(Alert.AlertType.INFORMATION, "Information Message", "Attendance marked successfully!");

                // Perform UI updates
                mark_attendence.setVisible(false);
                resetActiveClasses();
                mark_attendence_list.setVisible(true);
            } else {
                showAlert(Alert.AlertType.ERROR, "Error Message", "Failed to mark attendance.");
            }

            insertStatement.close();
        }

        checkStatement.close();
    } catch (Exception e) {
        e.printStackTrace();
        showAlert(Alert.AlertType.ERROR, "Error Message", "An error occurred: " + e.getMessage());
    } finally {
        try {
            if (connect != null) connect.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}



    public ObservableList<Attendence> addMarkAttendence() {
        ObservableList<Attendence> listData = FXCollections.observableArrayList();

        // Correct SQL Queries
        String sql = "SELECT * FROM attendence ORDER BY id DESC LIMIT 1";
        String sql2 = "SELECT emp.id AS emp_id, emp.name AS emp_name, emp.phone AS emp_phone, " +
                "l.leave_date AS leave_date, l.approved, l.reject " +
                "FROM employeesdata emp " +
                "LEFT JOIN ( " +
                "    SELECT employee_id, MAX(id) AS max_leave_id " +
                "    FROM leaves " +
                "    GROUP BY employee_id " +
                ") lm ON emp.id = lm.employee_id " +
                "LEFT JOIN leaves l ON lm.max_leave_id = l.id " +
                "ORDER BY emp.id";


        connect = connectDb(); // Assuming connectDb() establishes the connection.

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            // Check if the 'attendence' table has data
            String attendanceDate = null;
            if (result.next()) {
                attendanceDate = result.getString("date");
            }

            prepare = connect.prepareStatement(sql2);
            ResultSet result2 = prepare.executeQuery();

            int sno = 1; // Serial Number
            while (result2.next()) {
                boolean onLeave = attendanceDate != null && (attendanceDate.equals(result2.getString("leave_date"))&& (result2.getString("approved") == "1"));

                System.out.println("ID: " + result2.getString("emp_id"));
                System.out.println("Name: " + result2.getString("emp_name"));
                System.out.println("Phone: " + result2.getString("emp_phone"));
                System.out.println("On Leave: " + onLeave);

                HashMap<String, String> attendance = new HashMap<>();
                attendance.put("sno", String.valueOf(sno++));
                attendance.put("id", result2.getString("emp_id"));
                attendance.put("attendenceId", result.getString("id"));
                attendance.put("name", result2.getString("emp_name"));
                attendance.put("phone", result2.getString("emp_phone") != null ? result2.getString("emp_phone") : "N/A");
                attendance.put("onLeave", onLeave ? "Yes" :  "No");
                attendance.put("action", "Present");

                Attendence attendence1 = new Attendence(attendance);
                listData.add(attendence1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
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

    private ObservableList<Attendence> attendenceList = FXCollections.observableArrayList();
    public void markAttendenceList() {
        attendenceList = addMarkAttendence();

        attend_sno.setCellValueFactory(new PropertyValueFactory<>("sno"));
        attend_empID.setCellValueFactory(new PropertyValueFactory<>("id"));
        attend_emp_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        attend_emp_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        attend_onLeave.setCellValueFactory(new PropertyValueFactory<>("onLeave"));
        emp_action_col1.setCellFactory(tc -> new TableCell<Attendence, String>() {
//            Attendence attendence = getTableView().getItems().get(getIndex());
            private final Button presentBtn = new Button("Present");
//            if(attendence.getOnLeave().equals("Yes"))
//            {
//                presentBtn.setDisable(true);
//            }
            private final HBox actionButtons = new HBox(12); // Adjust spacing between buttons

            {
                actionButtons.getChildren().addAll(presentBtn);
            }

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {


                    presentBtn.setOnAction(e -> {
                        String updateSql = "INSERT INTO employees_attendence(employee_id, attendence_id, status, on_leave) VALUES(?, ?, ?, ?)";
                        connect = connectDb();

                        try {
                            // Prepare the SQL statement
                            prepare = connect.prepareStatement(updateSql);

                            // Set parameters
                            prepare.setString(1, getTableView().getItems().get(getIndex()).getId());
                            prepare.setString(2, getTableView().getItems().get(getIndex()).getAttendenceId());
                            prepare.setString(3, "1"); // Status set to "1"
                            prepare.setString(4, getTableView().getItems().get(getIndex()).getOnLeave().equals("Yes") ? "1" : "0");

                            // Execute the update
                            int rowsAffected = prepare.executeUpdate();

                            String updateSql2 = "INSERT INTO notifications(employee_id, alerts) VALUES(?, ?)";
                            prepare = connect.prepareStatement(updateSql2);

                            prepare.setString(1, getTableView().getItems().get(getIndex()).getId());
                            prepare.setString(2, "Your Attendence For "+attend_date.getValue().toString()+" has been marked");
                            int rowsAffected2 = prepare.executeUpdate();
                            if(rowsAffected > 0 && rowsAffected2 > 0) {
                                presentBtn.setDisable(true);
                                presentBtn.setStyle("-fx-background-color: grey; -fx-text-fill: white;");
                            } else {
                                System.out.println("No rows affected");
                            }
                            System.out.println("Rows affected: " + rowsAffected);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            throw new RuntimeException("Error inserting into employees_attendence", ex);
                        } finally {
                            // Close resources
                            try {
                                if (prepare != null) prepare.close();
                                if (connect != null) connect.close();
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }




                    });



                    presentBtn.getStyleClass().add("view-button");


                    setGraphic(actionButtons);
                }
            }
        });




        attendanceTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        attendanceTableView.setItems(attendenceList);

        System.out.println(addEmployeeList);
    }

    public void dashboard()
    {
        connect = connectDb();
        try {
            String sql = "SELECT COUNT(*) FROM employeesdata";
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            int totalEmployees;
            if (result.next()) {
                totalEmployees = result.getInt(1);
                dashboard_totalEmployee_Count.setText(result.getString(1));
            } else {
                totalEmployees = 0;
            }

            sql = "SELECT COUNT(*) FROM leaves  WHERE approved = 1";
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            if (result.next()) {
                dashboard_totalPresent_Count1.setText(result.getString(1));
            }


            sql = "SELECT COUNT(*) FROM leaves WHERE reject = 1";
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                dashboard_totalInactiveEmpolyee_Count.setText(result.getString(1));
            }


            sql = "SELECT COUNT(*) FROM leaves WHERE approved = 0 AND reject = 0";
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                dashboard_totalPendingRequest_Count.setText(result.getString(1));
            }
//
//            emp_pane.setOnMouseClicked(event -> {
//                admin_dashboard_cart.getData().clear();
//                XYChart.Series<String, Number> series = new XYChart.Series<>();
//                series.setName("Employees");
//                series.getData().add(new XYChart.Data<>("Total Employees", totalEmployees));
//
//                admin_dashboard_cart.getData().add(series);
//            });




        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addEmployeeshowList();
        displayUsername();
        addEmployeePosition();
        addEmployeeGender();
        addEmployeeName();
        addEmployeeSalAdd();
        addEmployeeSalaryshowList();
        addLeaveRequestList();
        profile();
        markAttendenceList();
        dashboard();

    }



}
