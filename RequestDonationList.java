import java.util.ArrayList;

public class RequestDonationList {

    ArrayList<RequestDonation> rdEntities = new ArrayList<RequestDonation>();

    public RequestDonationList() {
    }
    
    public RequestDonation get(int id) {
        RequestDonation res = null;
        for (int i = 0; i <= rdEntities.size(); i++) {
            if (rdEntities.get(i).getEntity().getId() == id) {
                res = rdEntities.get(i);
            }
        }
        return res;
    }

    public void add(RequestDonation n) {
        boolean entityfound = false;

        if (rdEntities.size() > 0) { //Check if List is empty - Check if already exists then update quantity
            for (int i = 0; i < rdEntities.size(); i++) {
                if (rdEntities.get(i).getEntityID() == n.getEntity().getId()) {
                   //System.out.println("Updating quantity of already existing entity");
                    rdEntities.get(i).setQuantity(n.getQuantity());
                    entityfound=true;
                }
            }
            if (entityfound==false) {
                    //System.out.println("Adding new entity to the list");                
                    rdEntities.add(n);
            }
        }
        else { //List is empty - Add First entity
            //System.out.println("Adding first entity to the list");                
            rdEntities.add(n);            
        }
    }

    public void remove(RequestDonation d) {
        for (int i = 0; i < rdEntities.size(); i++) {
            if (rdEntities.get(i).getEntityID() == d.getEntity().getId()) {
                rdEntities.remove(d);
            }
        }
    }

    public void modify( RequestDonation r, double quantity) {
        for (int i = 0; i < rdEntities.size(); i++) {
            if (rdEntities.get(i).getEntityID() == r.getEntity().getId()) {
                rdEntities.get(i).setQuantity(quantity);
            }
        }
    }

    public void monitor() {
        for (int i = 0; i < rdEntities.size(); i++) {
            System.out.println(rdEntities.get(i).getEntity().getId() + " " +rdEntities.get(i).getEntity().getName() + " " + rdEntities.get(i).getQuantity() );
        }
    }

    public void reset() { 
        rdEntities.clear();
    }
}
