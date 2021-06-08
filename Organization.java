import java.util.ArrayList;
import java.util.Iterator;

public class Organization {
    private String name;
    private Admin admin;
    private ArrayList<Entity> entityList = new ArrayList<Entity>();
    private ArrayList<Donator> donatorList = new ArrayList<Donator>();
    private ArrayList<Beneficiary> beneficiaryList = new ArrayList<Beneficiary>();
    private RequestDonationList currentDonations;
    public String current_user_phone;

    public Organization(String name) {
        this.name = name;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addEntity (Entity ent) {
        if(!entityList.contains(ent)) {
            entityList.add(ent);
            //System.out.println("Entity added to list");
        } else{
            System.out.println("Entity already exists in list");
        }
    }

    public void removeEntity (Entity ent) {
        if(entityList.contains(ent)) { 
            entityList.remove(ent);
            System.out.println("Entity removed from list");
        } else{
            System.out.println("Entity not found in list");
        }
    }

    public void insertDonator (Donator don) {
        if(!donatorList.contains(don)) {
            donatorList.add(don);
            //System.out.println("Donator added to list");
        } else{
            System.out.println("Donator already exists in list");
        }
    }

    public void removeDonator (Donator don) {
        if(donatorList.contains(don)) {
            donatorList.remove(don);
            System.out.println("Donator removed from list");
        } else{
            System.out.println("Donator not found in list");
        }
    }

    public void insertBeneficiary (Beneficiary ben) {
        if(!beneficiaryList.contains(ben)) {
            beneficiaryList.add(ben);
            //System.out.println("Beneficiary added in list");
        } else{
            System.out.println("Beneficiary already exits in list");
        }

    }

    public void removeBeneficiary (Beneficiary ben) {
        if(beneficiaryList.contains(ben)) {
            beneficiaryList.remove(ben);
            System.out.println("Beneficiary removed from list");
        } else{
            System.out.println("Beneficiary not found in list");
        }
    }

    public void listEntities() {
        Iterator ent_iter = entityList.iterator();

        System.out.println("List of Entities:");
        System.out.println("------------------------------------------");
        System.out.println("A. Materials:");       
        while(ent_iter.hasNext()) {
            Entity ent = (Entity) ent_iter.next();
            if ((ent.getType()).compareTo("material")==0) { 
                System.out.println(ent.getId() + " " + ent.getName() + " " + ent.getDescription() + " " + getEntityOfferedQuantity(ent.getId()));
            }
        }
        System.out.println("------------------------------------------");         
        System.out.println("B. Services:");
        ent_iter = entityList.listIterator();      
        while(ent_iter.hasNext()) {
            Entity ent = (Entity) ent_iter.next();
            if ((ent.getType()).compareTo("service")==0) { 
                System.out.println(ent.getId() + " " + ent.getName() + " " + ent.getDescription() + " " + getEntityOfferedQuantity(ent.getId()));
            }
        }          
        System.out.println("------------------------------------------");       
    }
    
    public Entity getEntityDetails(int ent_id) {
        Iterator ent_iter = entityList.iterator();

        while(ent_iter.hasNext()) {
            Entity ent = (Entity) ent_iter.next();
            if (ent.getId()==ent_id) { 
                System.out.println(ent.getId() + " " + ent.getName() + " " + ent.getDescription() + " " + getEntityOfferedQuantity(ent.getId()));
                return ent;
            }
        }
        return null;
    }


    public double  getEntityOfferedQuantity(int ent_id) {
        double quant = 0;
           
        Iterator don_iter = donatorList.iterator();
        while(don_iter.hasNext()) {
            Donator don = (Donator) don_iter.next();
            for (int i = 0; i < don.offerList.rdEntities.size(); i++) {
                if (don.offerList.rdEntities.get(i).getEntity().getId()==ent_id) {
                    quant= quant+don.offerList.rdEntities.get(i).getQuantity();
                }
            }                
        }
        return quant;        
    }
        
    public void listBeneficiaries() {
        Iterator ben_iter = beneficiaryList.iterator();

        System.out.println("List of Beneficiaries:");
        System.out.println("------------------------------------------");
        while(ben_iter.hasNext()) {            
            Beneficiary ben = (Beneficiary) ben_iter.next();
            System.out.println("Name: " + ben.getName() + " Phone: " + ben.getPhone());
        }
        System.out.println("------------------------------------------");
    }

    public void listDonators() {
        Iterator don_iter = donatorList.iterator();

        System.out.println("List of Donators:");
        System.out.println("------------------------------------------");
        while(don_iter.hasNext()) {
            Donator don = (Donator) don_iter.next();
            System.out.println("Name: " + don.getName() + " Phone: " + don.getPhone());
        }
        System.out.println("------------------------------------------");        
    }
    
    public Beneficiary PhoneCheckBeneficiaries(String phone) {
        Iterator ben_iter = beneficiaryList.iterator();

        while(ben_iter.hasNext()) {            
            Beneficiary ben = (Beneficiary) ben_iter.next();
            if (phone.compareTo(ben.getPhone())==0)
                return ben;
        }
        return null;
    }

    public Donator PhoneCheckDonators(String phone) {
        Iterator don_iter = donatorList.iterator();

        while(don_iter.hasNext()) {            
            Donator don = (Donator) don_iter.next();
            if (phone.compareTo(don.getPhone())==0)
                return don;
        }
        return null;
    }

    public void resetBeneficiariesList() {
        Iterator ben_iter = beneficiaryList.iterator();
        while(ben_iter.hasNext()) {            
            Beneficiary ben = (Beneficiary) ben_iter.next();
            ben.receivedList.reset();
        }
    }    
}
