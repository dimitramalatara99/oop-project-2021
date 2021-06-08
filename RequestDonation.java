public class RequestDonation {
    Entity entity;
    double quantity;
    int id;
    
    public RequestDonation(Entity ent, double quan){
        this.entity = ent;
        this.quantity = quan;
        id = entity.getId();
    }    

    public void setEntity(Entity entity){
        this.entity=entity;
    }

    public Entity getEntity(){
        return entity;
    }

    public void setQuantity(double quantity){
        this.quantity=quantity;
    }

    public double getQuantity(){
        return quantity;
    }

    public double getEntityID(){
        return id;
    }


}
