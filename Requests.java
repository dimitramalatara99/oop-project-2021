import java.util.ArrayList;

public class Requests extends RequestDonationList {
    
    public Requests() {
    }
    
    @Override  
    public void add(RequestDonation n) {
        boolean entityfound = false;
        
        //System.out.println("Override add of Requests class ");
        // ****TODO extra conditions checks:
        // εφόσον επιτύχουν και οι δύο έλεγχοι παρακάτω: 
        // α) η ποσότητα του entity είναι διαθέσιμη στον οργανισμό και 
        // β) o Beneficiary τη δικαιούται (validRequestDonation()). 
        //Αν δεν ισχύει το α) θα δημιουργηθεί κατάλληλη εξαίρεση, ενώ αν δεν ισχύει το 
        // β) θα εγερθεί κατάλληλη εξαίρεση διαφορετικού τύπου.�
        
            
        
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
    
    public void validRequestDonation() {
        //TODO validRequestDonation
    }
    
    public void commit(){
        //TODO commit
    }
}