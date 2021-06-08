import java.util.ArrayList;

public class Donator extends User {
    private String name = "";
    private String phone = "";
    Offers  offerList = new Offers();
    
    public Donator(String name,String phone) {
        this.name=name;
        this.phone=phone;
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
    
    public ArrayList<Offers> getOfferList(ArrayList<Offers> offerList){
        return offerList;
    }

    public void setOfferList() {
        this.offerList = offerList;
    }
}

