import java.io.Serializable;

public class Course implements Serializable, Cloneable{
    private String Subject;
    private Teacher Teacher;
    private int Grade;
    private Boolean Current;
    public Course(Teacher Teacher, String Subject){
        this.Teacher = Teacher;
        this.Subject = Subject;
    }
    public Course(int Grade, Boolean Current){
        this.Grade = Grade;
        this.Current = Current;
    }
    public Course clone() {
        try {
            return (Course) super.clone();
        } catch (Exception e) {
        }
        return null;
    }
    public void setSubject(String Subject){
        this.Subject = Subject;
    }
    public String getSubject(){
        return Subject;
    }
    public void setTeacher(Teacher Teacher){
        this.Teacher = Teacher;
    }
    public Teacher getTeacher(){
        return Teacher;
    }
    public void setGrade(int Grade){
        this.Grade = Grade;
    }
    public int getGrade(){
        return Grade;
    }
    public void setCurrent(Boolean Current){
        this.Current = Current;
    }
    public Boolean getCurrent(){
        return Current;
    }
    public String toString(){
        return Subject+" by "+Teacher+"Grade: "+Grade;
    }
}