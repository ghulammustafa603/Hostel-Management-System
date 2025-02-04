import java.util.*;
import javax.swing.*;
class MessManagement {
   // private Map<String, Integer> messData;
private ArrayList<Bill> bill;

    public MessManagement() {


            bill = new ArrayList<>();

    }

    /*private void initializeMessData() {
        messData.put("KASHIF", 4);
        messData.put("HAIDER ALI", 3);
    }*/

    public void addStudentToMess(int id2,int days,String name2,int totalBill)
    {
        if (bill.size() < 10)
        {

                bill.add(new Bill(id2,days,name2,totalBill));

        }
        else
            {
            JOptionPane.showMessageDialog(null, "* SORRY, Student exists in this hostel *");
            }
    }


   /* public void deleteStudentFromMess(String name) {
        if (messData.containsKey(name.toUpperCase())) {
            messData.remove(name.toUpperCase());
            JOptionPane.showMessageDialog(null, "* SUCCESSFULLY UNENROLLED FROM MESS *");
        } else {
            JOptionPane.showMessageDialog(null, "* STUDENT NOT ENROLLED IN THE MESS *");
        }
    }
*//*
    public void addBill()
    {
        addStudentToMess();

    }*/
}
