public class Admin extends User{

    private boolean isAdmin = true;

    public Admin(Boolean isAdmin) {
        this.isAdmin=isAdmin;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
}