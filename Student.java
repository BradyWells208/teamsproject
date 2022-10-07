import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    private int gradeLevel; 
    private String Name; 
    private ArrayList<Course> Courses;
    public Student(String Name, int gradeLevel){
        this.gradeLevel = gradeLevel;
        this.Name = Name;
        Courses = new ArrayList<>();
    }
    public void setgradeLevel(int gL){
        gradeLevel = gL;
    }
    public int getgradeLevel(){
        return gradeLevel;
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public String getName(){
        return Name;
    }
    public ArrayList<Course> getCourses(){
        return Courses;
    }
}