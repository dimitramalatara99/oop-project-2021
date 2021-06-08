abstract class Entity {

    private String name;
    private String Description;
    private int id;

    public void setName(String name){
       this.name = name;
    }
    
    public void setId(int setid){
       //this.name = name;
       this.id = setid;
    }    

    public String getName(){
       return name;
    }

    public void setDescription(String description){
        this.Description = description;
    }

    public String getDescription(){
        return Description;
    }

    public int getId(){
        return id;
    }

    public String getType() {
        return "";
    }

}
