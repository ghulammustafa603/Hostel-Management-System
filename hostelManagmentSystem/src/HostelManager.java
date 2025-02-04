    import java.util.*;
    import javax.swing.*;

    class HostelManager {
        private ArrayList<Student> students;

        public HostelManager() {
            students = new ArrayList<>();

        }
        public void displayStudents() {
            StringBuilder result = new StringBuilder();
            for (Student student : students) {
                result.append(student.getInfo()).append("\n\n");
            }
            if (students.isEmpty()) {
                result.append("* STUDENTS ARE NOT ENROLLED *");
            }
            JOptionPane.showMessageDialog(null, result.toString());
        }

        public void enrollStudent(String id, String name, String department, int room) {
            if (students.size() < 10) {
                students.add(new Student(id, name, department, room));
                JOptionPane.showMessageDialog(null, "* SUCCESSFULLY ENROLLED *");
            } else {
                JOptionPane.showMessageDialog(null, "* SORRY, NO VACANCY *");
            }
        }

        public void searchStudent(String query) {
            int count = 0;
            StringBuilder result = new StringBuilder();
            for (Student student : students) {
                if (query.equalsIgnoreCase(student.name) || query.equalsIgnoreCase(String.valueOf(student.id)) || query.equalsIgnoreCase(student.department)) {
                    result.append(student.getInfo()).append("\n\n");
                    count++;
                }
            }
            if (count == 0) {
                result.append("* STUDENT NOT FOUND *");
            }
            JOptionPane.showMessageDialog(null, result.toString());
        }

        public void deleteStudent(String query) {
            Iterator<Student> iterator = students.iterator();
            int count = 0;
            while (iterator.hasNext()) {
                Student student = iterator.next();
                if (query.equalsIgnoreCase(student.name) || query.equalsIgnoreCase(String.valueOf(student.id)) || query.equalsIgnoreCase(student.department)) {
                    iterator.remove();
                    JOptionPane.showMessageDialog(null, student.getInfo() + "\n\n* UNENROLLED SUCCESSFULLY *");
                    count++;
                    break;
                }
            }
            if (count == 0) {
                JOptionPane.showMessageDialog(null, "* STUDENT NOT FOUND *");
            }
        }

        public void searchRoom(int roomNumber) {
            StringBuilder result = new StringBuilder();
            for (Student student : students) {
                if (roomNumber == student.room) {
                    result.append(student.getInfo()).append("\n\n");
                }
            }
            JOptionPane.showMessageDialog(null, result.toString());
        }
    }
