public class Material extends Entity {

    private double Level1 = 0.0;
    private double Level2 = 0.0;
    private double Level3 = 0.0;

    public Material(double Level1,double Level2,double Level3){
        this.Level1 = Level1;
        this.Level2 = Level2;
        this.Level3 = Level3;
    }

    public double getLevel1(){
        return Level1;
    }

    public double getLevel2(){
        return Level2;
    }

    public double getLevel3(){
        return Level3;
    }

    public String getType() {
        String res="";
        if(this instanceof Material){
            res = "material";
        }else{
            res = "not material";
        }
        return res;
    }

    public String getEntityInfo() {
        return getId() + " " + getName() + " " + getDescription();
    }

    public String getDetails() {
        return getLevel1() + " " + getLevel2() + " " + getLevel3();
    }

    @Override
    public String toString() {
      return getEntityInfo() + " " + getDetails();
    }
}
