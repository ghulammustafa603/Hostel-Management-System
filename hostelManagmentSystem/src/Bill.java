public class Bill
{
    int id2;
    String name2;

    int days;
    double totalBill;

    public Bill(int id2,int days, String name2, int totalBill)
    {
        this.id2 = id2;

        this.days = days;

        this.name2 = name2;
        this.totalBill=totalBill;
    }

    public String getInfo() {
        return "ID: " + id2 + "\nNAME: " + name2  + "\nDays: " + days+"\ntotalBill"+totalBill;
    }
}
