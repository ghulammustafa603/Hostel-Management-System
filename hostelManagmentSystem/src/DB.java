import java.sql.*;
import javax.swing.*;

public class DB
{
    //Student s1=new Student();
    private Connection connection;

    public DB()
    {
        try {
            // Establish database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel_management_system", "root", "ghulam786@");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void displayStudentsFromDatabase() {
        StringBuilder result = new StringBuilder();
        try {
            // Create a statement to execute SQL query
            Statement statement = connection.createStatement();
            // Execute SQL query to retrieve all student records
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
            boolean isEmpty=true;
            // Iterate through the result set and append student information to the StringBuilder
            while (resultSet.next()) {
                String id = String.valueOf(resultSet.getInt("id"));
                String name = resultSet.getString("name");
                String department = resultSet.getString("dept_name");
                int room = resultSet.getInt("room_no");

                result.append("ID: ").append(id).append("\n");
                result.append("Name: ").append(name).append("\n");
                result.append("Department: ").append(department).append("\n");
                result.append("Room: ").append(room).append("\n\n");
                isEmpty=false;
            }

            // Check if no students are enrolled
            if (isEmpty) {
                result.append("* STUDENTS ARE NOT ENROLLED *");
            }

            // Close the result set and statement
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error displaying students: " + e.getMessage());
        }

        // Display student information using JOptionPane
        JOptionPane.showMessageDialog(null, result.toString());
    }


    // Method to enroll a student
    public void enrollStudent(String id, String name, String department, int room) {
        try {
            // Create a prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student (id, name, dept_name, room_no) VALUES (?, ?, ?, ?)");
            // Set parameters
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, department);
            preparedStatement.setInt(4, room);
            // Execute the query
            preparedStatement.executeUpdate();
            System.out.println("Student enrolled successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


        // Method to calculate the total bill and store it in the database
        public void addStudentToMess(int id, int days, String student_name, double totalBill) {
            try {
                // Insert the bill data into the database
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO bills (id, days, student_name, total_Bill) VALUES (?, ?, ?, ?)");
                preparedStatement.setInt(1, id);
                preparedStatement.setInt(2, days);
                preparedStatement.setString(3, student_name);
                preparedStatement.setDouble(4, totalBill);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Bill added successfully. Total Bill: " + totalBill);
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to add bill.");
                }
            } catch (SQLException e) {
                // Log or print the exception message for debugging
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error adding bill to database: " + e.getMessage());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid number format: " + e.getMessage());
            }
        }


    // Method to search for a student by name, ID, or department
    public void searchStudent(String query) {
        try {
            // Create a prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student WHERE id = ? OR name = ? OR dept_name = ?");
            // Set parameters
            preparedStatement.setString(1, query);
            preparedStatement.setString(2, query);
            preparedStatement.setString(3, query);
            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();
            StringBuilder str = new StringBuilder();
            // Process the result set
            boolean isEmpty = true;

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("dept_name");
                int room = resultSet.getInt("room_no");

                str.append("ID: ").append(id).append(", Name: ").append(name).append(", Department: ").append(department).append(", Room: ").append(room).append("\n");
                isEmpty=false;
            }
            if(!(str.toString().isEmpty()))
            {
                JOptionPane.showMessageDialog(null, str);
            }
                      if(isEmpty)
            {
                JOptionPane.showMessageDialog(null,"SORRY STUDENT DOESNOT FOUND");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a student by name, ID, or department
    public void deleteStudent(String query) {
        try {
            // Create a prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM student WHERE id = ? OR name = ? OR dept_name = ?");
            // Set parameters
            preparedStatement.setString(1, query);
            preparedStatement.setString(2, query);
            preparedStatement.setString(3, query);
            // Execute the query
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null,"Student(s) deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(null,"No student(s) found with the specified query.");
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    // Method to search for a room by room number
    public void searchRoom(int roomNumber) {
        try {

            // Create a prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student WHERE room_no = ?");
            // Set parameter
            preparedStatement.setInt(1, roomNumber);
            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();
            boolean isEmpty = true;
            StringBuilder str = new StringBuilder();

            // Process the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("dept_name");

                str.append("ID: ").append(id).append(", Name: ").append(name).append(", Department: ").append(department).append(", Room: ").append(roomNumber).append("\n");
                isEmpty = false;
            }
            if (!(str.toString().isEmpty())) {
                JOptionPane.showMessageDialog(null, str);
            }


            if (isEmpty) {
                JOptionPane.showMessageDialog(null, "STUDENT NOT FOUND");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
