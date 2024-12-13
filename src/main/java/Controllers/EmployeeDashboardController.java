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
            String salaryQuery = "INSERT INTO salaries_and_taxes(employee_id, salary) VALUES(?, ?)";
            preparedStatement = connect.prepareStatement(salaryQuery);
            preparedStatement.setString(1, employeeId);
            preparedStatement.setString(2, employee_sal_salary.getText().trim());

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
        add_emp.setVisible(false);
        add_emp_salary.setVisible(false);
        emp_salary_list.setVisible(false);
        view_emp.setVisible(false);
        admin_dashboard.setVisible(false);
        emp_list.setVisible(false);

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
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addEmployeeshowList();
        displayUsername();
        addEmployeePosition();
        addEmployeeGender();
        addEmployeeName();
        addEmployeeSalAdd();
        addEmployeeSalaryshowList();

    }



}
