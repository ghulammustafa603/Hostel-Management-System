//import java.util.*;
import javax.swing.*;
public class main2 {
    static DB db;
    static HostelManager hostelManager;
    static MessManagement messManagement; // Declare MessManagement instance
    public static void main(String[] args) {
         hostelManager = new HostelManager();
        messManagement = new MessManagement();
        db = new DB();

        int option;

        do {
            String input = JOptionPane.showInputDialog("...... HOSTEL MANAGEMENT SYSTEM ......\n\n" +
                    "1. ENROLLED STUDENTS\n" +
                    "2. ENROLL NEW STUDENT\n" +
                    "3. SEARCH\n" +
                    "4. DELETE\n" +
                    "5. ROOM\n" +
                    "6. MESS SYSTEM\n" +
                    "0. EXIT\n\n" +
                    "SELECT THE ABOVE OPTION...");

            option = Integer.parseInt(input);

            switch (option) {
                case 1:
                    displayStudents();
                    break;
                case 2:
                    enrollStudent(hostelManager);
                    break;
                case 3:
                    searchStudent(hostelManager);
                    break;
                case 4:
                    deleteStudent(hostelManager);
                    break;
                case 5:
                    searchRoom(hostelManager);
                    break;
                case 6:
                    addStudentToMess(messManagement);
                    break;
            }

        } while (option != 0);
    }
    private static void displayStudents() {
        // Call displayStudentsFromDatabase method of HostelManager
        db.displayStudentsFromDatabase();
    }


    private static void enrollStudent(HostelManager hostelManager) {
        String id = (JOptionPane.showInputDialog("Enter the ID:"));
        String name = JOptionPane.showInputDialog("Enter the Name:");
        String department = JOptionPane.showInputDialog("Enter the Department:");
        String roomStr = JOptionPane.showInputDialog("Enter the Room:");
        int room = Integer.parseInt(roomStr);

        db.enrollStudent(id, name, department, room);

        hostelManager.enrollStudent(id, name, department, room);
    }

    private static void searchStudent(HostelManager hostelManager) {
        String query = JOptionPane.showInputDialog("Enter the Name/ID/Department:");
        db.searchStudent(query);
    }

    private static void deleteStudent(HostelManager hostelManager) {
        String query = JOptionPane.showInputDialog("Enter the ID of Student which you want to delete:");
        db.deleteStudent(query);
    }

    private static void searchRoom(HostelManager hostelManager) {
        String roomStr = JOptionPane.showInputDialog("Enter the Room Number:");
        int room = Integer.parseInt(roomStr);
        db.searchRoom(room);

    }


    public static void addStudentToMess(MessManagement messManagement) {
        String name2 = JOptionPane.showInputDialog("Enter the Name of enrolled Student:");
        int id2 = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of enrolled:"));
        JOptionPane.showMessageDialog(null, "Note: price per day 200");
        int days = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of consumed days"));
        int totalBill = days * 200;
        JOptionPane.showMessageDialog(null, "Total Bill=" + totalBill);
        db.addStudentToMess(id2, days, name2, totalBill);
        messManagement.addStudentToMess(id2,days,name2,totalBill); // Call a method on the MessManagement instance
    }
}