package Controllers;


import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx. geometry. Insets;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import javafx.scene.image.ImageView;
//import java.lang.classfile.Label;
import java.beans.Statement;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

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
    private TableView<Attendence> view_attend;

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
    private ScrollPane notification_bar;

    @FXML
    private VBox notificationContainer;

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
    private AnchorPane view_attendence;

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
    private Label dashboard_totalLeaveApproved_Count1;


    @FXML
    private Label dashboard_totalLeave_Count;


    @FXML
    private Label dashboard_totalLeaveRejected_Count2;


    @FXML
    private Label dashboard_totalpendingRequestCount;

    @FXML
    private DatePicker emp_leave_date;


    @FXML
    private TextArea emp_reason_leave;

    @FXML
    private Button emp_request_for_leave;

    @FXML
    private AnchorPane request_for_leave_screen;

    @FXML
    private Button requestForLeaveBtn;

    @FXML
    private AnchorPane view_task_screen;

    @FXML
    private AnchorPane edit_profile_screen;

    @FXML
    private AnchorPane view_profile_screen;


    @FXML
    private Button viewAttendence;

    @FXML
    private AnchorPane employee_dashboard;

    @FXML
    private Button viewTaskBtn;

    @FXML
    private Button editProfileBtn;

    @FXML
    private Button viewProfileBtn;

    @FXML
    private TableColumn<?, ?> attend_comment;

    @FXML
    private TableColumn<?, ?> attend_date;

    @FXML
    private TableColumn<?, ?> attend_sno;

    @FXML
    private TableColumn<?, ?> attend_status;


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
            preparedStatement.setString(1, user.getUsername().trim());
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

    public void profile()
    {
        connect = connectDb(); // Establish DB connection

        try {
            // Fetch the current user (assuming username is stored in `getData.username`)
            String query = "SELECT * FROM employeesdata WHERE name = ?";
            PreparedStatement preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername().trim());
            result = preparedStatement.executeQuery();

            if (result.next()) {
                // Display the data in the form fields
                emp_view_name.setText(result.getString("name"));
                emp_view_email.setText(result.getString("email"));
                emp_view_phone.setText(result.getString("phone"));
                emp_view_gender.setText(result.getString("gender"));
                emp_view_position.setText(result.getString("position"));
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
        connect = connectDb(); // Establish DB connection

        try {
            // Fetch the current user (assuming username is stored in `getData.username`)
            String query = "SELECT * FROM employeesdata WHERE name = ?";
            PreparedStatement preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername().trim());
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
                try (PreparedStatement updateStatement = connect.prepareStatement(
                        "UPDATE employeesdata SET name = ?, email = ?, phone = ?, gender = ? WHERE name = ?")) {

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
                    updateStatement.setString(5, user.getUsername().trim()); // Match the original username

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
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            // Do NOT close `connect` here as it's needed for the update action
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

        profile();
        // Reset visibility for all sections
        request_for_leave_screen.setVisible(false);
        view_profile_screen.setVisible(false);
        edit_profile_screen.setVisible(false);
        employee_dashboard.setVisible(false);
        request_for_leave_screen.setVisible(false);
        view_attendence.setVisible(false);

        // Reset 'active' class for all buttons
        resetActiveClasses();

        // Switch visibility and activate the appropriate button
        if (event.getSource() == requestForLeaveBtn) {
            request_for_leave_screen.setVisible(true);
            activateButton(requestForLeaveBtn);

            addLeaveType();
            addEmployeeGender();

        } else if (event.getSource() == viewAttendence) {
             view_attendence.setVisible(true);
            activateButton(viewAttendence);
        } else if (event.getSource() == dashboarbbtn) {
            employee_dashboard.setVisible(true);
            activateButton(dashboarbbtn);
        } else if (event.getSource() == editProfileBtn) {
            edit_profile_screen.setVisible(true);
            activateButton(editProfileBtn);
        } else if (event.getSource() == viewProfileBtn) {
            view_profile_screen.setVisible(true);
            activateButton(viewProfileBtn);
        }


    }

    // Helper Method: Reset 'active' classes for all buttons
    private void resetActiveClasses() {
        dashboarbbtn.getStyleClass().remove("active");
        viewAttendence.getStyleClass().remove("active");
        requestForLeaveBtn.getStyleClass().remove("active");
        editProfileBtn.getStyleClass().remove("active");
        viewProfileBtn.getStyleClass().remove("active");

//        taskLListBtn.getStyleClass().remove("active");
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

    public ObservableList<Attendence> addMarkAttendence(String username) {
        ObservableList<Attendence> listData = FXCollections.observableArrayList();

        // SQL Queries
        String sqlAttendance = "SELECT id, date, comments FROM attendence ORDER BY date ASC"; // Order by date
        String sqlEmployeeAttendance = "SELECT attendence_id FROM employees_attendence WHERE employee_id = ? AND attendence_id = ?";
        String sqlEmployee = "SELECT id FROM employeesdata WHERE name = ?";

        Connection connect = connectDb(); // Assuming connectDb() establishes the connection
        PreparedStatement prepare = null;
        ResultSet result = null;

        try {
            // Fetch employee details based on the current username
            prepare = connect.prepareStatement(sqlEmployee);
            prepare.setString(1, username);
            ResultSet resultEmployee = prepare.executeQuery();

            String employeeId = null;

            if (resultEmployee.next()) {
                employeeId = resultEmployee.getString("id");
            } else {
                System.out.println("Employee not found!");
                return listData; // Return an empty list if the employee is not found
            }
            resultEmployee.close(); // Close the ResultSet

            // Fetch all attendance records
            prepare = connect.prepareStatement(sqlAttendance);
            result = prepare.executeQuery();

            int sno = 1; // Serial Number
            while (result.next()) {
                String attendanceId = result.getString("id");
                String attendanceDate = result.getString("date");
                String attendanceComments = result.getString("comments");

                // Check if the employee is present on this date
                boolean isPresent = false;
                try (PreparedStatement checkAttendance = connect.prepareStatement(sqlEmployeeAttendance)) {
                    checkAttendance.setString(1, employeeId);
                    checkAttendance.setString(2, attendanceId);

                    try (ResultSet resultEmpAttendance = checkAttendance.executeQuery()) {
                        isPresent = resultEmpAttendance.next(); // True if record exists
                    }
                }

                // Create a HashMap for attendance
                HashMap<String, String> attendance = new HashMap<>();
                attendance.put("sno", String.valueOf(sno++));
                attendance.put("id", attendanceId);
                attendance.put("date", attendanceDate);
                attendance.put("comments", attendanceComments); // Avoid null comments
                attendance.put("status", isPresent ? "Present" : "Absent");

                // Create an Attendence object
                Attendence attendence = new Attendence(attendance); // Assuming Attendence constructor accepts HashMap
                listData.add(attendence);
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

    public void markAttendenceList(String username) {
        attendenceList = addMarkAttendence(username);

        attend_sno.setCellValueFactory(new PropertyValueFactory<>("sno"));
        attend_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        attend_comment.setCellValueFactory(new PropertyValueFactory<>("comments"));
        attend_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        view_attend.setItems(attendenceList);
    }


    public List<String> fetchNotifications(String employeename) {
        List<String> notifications = new ArrayList<>();
        String employeeId = null;

        // Query to fetch employee_id from employeesdata based on employeename
        String fetchEmployeeIdSql = "SELECT id FROM employeesdata WHERE name = ?";

        // Query to fetch alerts from notifications based on employee_id
        String fetchNotificationsSql = "SELECT alerts FROM notifications WHERE employee_id = ? ORDER BY created_at DESC";

        connect = connectDb(); // Assuming connectDb() establishes the database connection

        try {
            // Fetch the employee_id based on employeename
            PreparedStatement fetchIdStatement = connect.prepareStatement(fetchEmployeeIdSql);
            fetchIdStatement.setString(1, employeename);
            ResultSet idResult = fetchIdStatement.executeQuery();

            if (idResult.next()) {
                employeeId = idResult.getString("id");
            }

            if (employeeId == null) {
                System.out.println("No employee found with the name: " + employeename);
                return notifications; // Return empty list if no employee_id is found
            }

            // Fetch notifications using the employee_id
            PreparedStatement fetchNotificationsStatement = connect.prepareStatement(fetchNotificationsSql);
            fetchNotificationsStatement.setString(1, employeeId);
            ResultSet notificationsResult = fetchNotificationsStatement.executeQuery();

            while (notificationsResult.next()) {
                notifications.add(notificationsResult.getString("alerts")); // Use the correct column name
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching notifications: " + e.getMessage(), e);
        } finally {
            try {
                if (connect != null) connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return notifications;
    }


//    @FXML
//    private ScrollPane notification_bar;

    public void populateNotificationBar(String employeename) {
        // Clear existing notifications
        notificationContainer.getChildren().clear();

        // Fetch notifications from the database
        List<String> notifications = fetchNotifications(employeename);

        // Add each notification as a card
        for (String notification : notifications) {
            // Create a VBox to hold the text
            VBox notificationCard = new VBox();
            notificationCard.setStyle(
                    "-fx-background-color: #f0f0f0;" +
                            "-fx-padding: 10;" +
                            "-fx-border-color: #ccc;" +
                            "-fx-border-radius: 5;" +
                            "-fx-background-radius: 5;"
            );

            // Add hover effect for the card
            notificationCard.setOnMouseEntered(event -> {
                notificationCard.setStyle(
                        "-fx-background-color: #e6e6e6;" + // Lighter background on hover
                                "-fx-padding: 10;" +
                                "-fx-border-color: #999;" + // Darker border on hover
                                "-fx-border-radius: 5;" +
                                "-fx-background-radius: 5;"
                );
            });

            notificationCard.setOnMouseExited(event -> {
                notificationCard.setStyle(
                        "-fx-background-color: #f0f0f0;" +
                                "-fx-padding: 10;" +
                                "-fx-border-color: #ccc;" +
                                "-fx-border-radius: 5;" +
                                "-fx-background-radius: 5;"
                );
            });

            // Add click event for the card (e.g., mark as read or open details)
            notificationCard.setOnMouseClicked(event -> {
                System.out.println("Notification clicked: " + notification);
                // Add your custom action here, like marking the notification as read
//                markNotificationAsRead(notification);
            });

            // Create text with proper wrapping
            Text notificationText = new Text(notification);
            notificationText.setWrappingWidth(380); // Slightly less than container to account for padding

            // Create a text flow to handle the text wrapping
            TextFlow textFlow = new TextFlow(notificationText);
            textFlow.setLineSpacing(1.5); // Add some line spacing for better readability

            // Add the text flow to the card
            notificationCard.getChildren().add(textFlow);

            // Set the preferred width for the card
            notificationCard.setPrefWidth(400);

            // Add margin around the card
            VBox.setMargin(notificationCard, new Insets(5));

            // Add the card to the notification container
            notificationContainer.getChildren().add(notificationCard);
        }
    }



    @FXML
    private FontAwesomeIcon notificationBtn;

    public void notification(){
        notification_bar.setVisible(false);
        notificationBtn.setOnMouseClicked(e -> {
            if (notification_bar.isVisible()) {
                notification_bar.setVisible(false);
            } else {
                notification_bar.setVisible(true);
            }
        });
    }

    public void dashboard() {
        connect = connectDb(); // Establish the database connection
        try {
            // Query for total leave count in employeesdata
            String query = "SELECT total_leave_count FROM employeesdata WHERE name = ?";
            PreparedStatement preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername()); // Set the username parameter
            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                dashboard_totalLeave_Count.setText(result.getString("total_leave_count"));
            }

            // Query for total approved leaves of the current user
            query = "SELECT COUNT(leaves.id) AS approved " +
                    "FROM leaves " +
                    "JOIN employeesdata ON leaves.employee_id = employeesdata.id " +
                    "WHERE employeesdata.name = ? AND leaves.approved = 1";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            result = preparedStatement.executeQuery();

            if (result.next()) {
                dashboard_totalLeaveApproved_Count1.setText(result.getString("approved"));
            }

            // Query for total rejected leaves of the current user
            query = "SELECT COUNT(leaves.id) AS rejected " +
                    "FROM leaves " +
                    "JOIN employeesdata ON leaves.employee_id = employeesdata.id " +
                    "WHERE employeesdata.name = ? AND leaves.approved = 0";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            result = preparedStatement.executeQuery();

            if (result.next()) {
                dashboard_totalLeaveRejected_Count2.setText(result.getString("rejected"));
            }

            // Query for total pending leaves of the current user
            query = "SELECT COUNT(leaves.id) AS pending " +
                    "FROM leaves " +
                    "JOIN employeesdata ON leaves.employee_id = employeesdata.id " +
                    "WHERE employeesdata.name = ? AND leaves.approved = 0 AND leaves.reject=0";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            result = preparedStatement.executeQuery();

            if (result.next()) {
                dashboard_totalpendingRequestCount.setText(result.getString("pending"));
            }

        } catch (Exception e) {
            e.printStackTrace(); // Handle any SQL or connection errors
        } finally {
            try {
                if (connect != null) {
                    connect.close(); // Ensure the connection is closed
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }






    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username.setText(user.getUsername());
        addLeaveType();
        addEmployeeGender();
        updateProfile();
        profile();
        markAttendenceList(user.getUsername());
        populateNotificationBar(user.getUsername());
        notification();
        dashboard();

    }



}
