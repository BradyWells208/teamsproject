import java.io.Serializable;

public class Teacher implements Serializable {
    private String TName;
    private int yearsofExperience;
    public Teacher(String TName, int yearsofExperience){
        this.TName = TName;
        this.yearsofExperience = yearsofExperience;
    }

    public void setyearsofExperience(int yoE){
        this.yearsofExperience = yoE;
    }
    public int getyearsofExperience(){
        return yearsofExperience;
    }
    public void setTName(String TName){
        this.TName = TName;
    }
    public String getTName(){
        return TName;
    }
    public String toString(){
        return TName;
    }
}