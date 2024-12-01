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
import static java.lang.Integer.parseInt;

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
        } else if (event.getSource() == add_employee_sal) {
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

            addEmployeePosition();
            addEmployeeGender();
            addEmployeeSearch();
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
            private final Button btn = new Button("View");

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    btn.setOnAction(e -> {
                        EmployeeData employee = getTableView().getItems().get(getIndex());
                        System.out.println("View details for: " + employee.getName());
                        emp_view_name.setText(employee.getName());
                        emp_view_email.setText(employee.getEmail());
                        emp_view_phone.setText(employee.getPhone());
                        emp_view_position.setText(employee.getPosition());
                        emp_view_gender.setText(employee.getGender());
                        view_emp.setVisible(true);
                        emp_list.setVisible(false);
                        // Add custom logic to view employee details.
                    });
                    btn.getStyleClass().add("view-button");
                    setGraphic(btn);
                }
            }
        });


        emp_tableview.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        emp_email_col.setPrefWidth(250);
        emp_employeeID_col.setPrefWidth(50);
        emp_tableview.setItems(addEmployeeList);

        System.out.println(addEmployeeList);
    }

//    public void addEmployeeSearch()
//    {
//        FilteredList<EmployeeData> filteredData = new FilteredList<>(addEmployeeList, b -> true);
//        emp_sal_search1.textProperty().addListener((observable, oldValue, newValue) -> {
//            filteredData.setPredicate(employee -> {
//                if (newValue == null || newValue.isEmpty()) {
//                    return true;
//                }
//
//                String lowerCaseFilter = newValue.toLowerCase();
//
//                if (employee.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
//                    return true;
//                } else if (employee.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1) {
//                    return true;
//                } else if (employee.getPhone().toLowerCase().indexOf(lowerCaseFilter) != -1) {
//                    return true;
//                } else if (employee.getPosition().toLowerCase().indexOf(lowerCaseFilter) != -1) {
//                    return true;
//                } else if (employee.getGender().toLowerCase().indexOf(lowerCaseFilter) != -1) {
//                    return true;
//                } else {
//                    return false;
//                }
//            });
//        });
//        SortedList<EmployeeData> sortedData = new SortedList<>(filteredData);
//        sortedData.comparatorProperty().bind(emp_tableview.comparatorProperty());
//        emp_tableview.setItems(sortedData);
//
//    }

    public void addEmployeeSearch() {

        FilteredList<EmployeeData> filter = new FilteredList<>(addEmployeeList, e -> true);

        emp_sal_search1.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateEmployeeData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateEmployeeData.getId().toString().contains(searchKey)) {
                    return true;
                } else if (predicateEmployeeData.getName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateEmployeeData.getEmail().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateEmployeeData.getPhone().toLowerCase().contains(searchKey)) {
                    return true;
                }  else {
                    return false;
                }
            });
        });

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
    }



}
