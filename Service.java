public class Service extends Entity {

    public Service() {
    }


    public String getEntityInfo() {
        return getName() + " " + getId();
    }

    public String getDetails() {
        return getDescription() + " and " + getType();
    }

    public String getType() {
        String res="";
        if(this instanceof Service) {
            res = "service";
        }else{
            res = "not service";
        }
        return res;
    }

    @Override
    public String toString() {
        return getEntityInfo() + " " + getDetails();
    }
}
