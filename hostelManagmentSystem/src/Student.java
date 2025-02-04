import javax.swing.*;
import java.util.*;

class Student {
    String id;
    String name;
    String department;
    int room;

    public Student(String id, String name, String department, int room) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.room = room;
    }
    public Student(){}

    public String getInfo() {
        return "ID: " + id + "\nNAME: " + name + "\nDEPARTMENT: " + department + "\nROOM: " + room;
    }
}
