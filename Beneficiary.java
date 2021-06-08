import java.util.ArrayList;

public class Beneficiary extends User {

    private String name = "";
    private String phone = "";
    private int noPersons = 1;
    RequestDonationList receivedList = new RequestDonationList();
    Requests requestsList = new Requests();
    
    public Beneficiary(String name,String phone,int noPersons) {
        this.name=name;
        this.phone=phone;
        this.noPersons=noPersons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getNoPersons() {
        return noPersons;
    }

    public void setNoPersons(int noPersons) {
        this.noPersons= noPersons;
    }

    public ArrayList<RequestDonationList> getReceivedList(ArrayList<RequestDonationList> receivedList) {
        return receivedList;
    }
    
    public ArrayList<Requests> getRequestsList(ArrayList<Requests> requestsList) {
        return requestsList;
    }
    
    public void setReceivedList() {
        this.receivedList = receivedList;
    }
}
