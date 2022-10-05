import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TEAMS{
    static ArrayList<Student> students;
    static ArrayList<Teacher> teachers;
    static ArrayList<Course> courses;
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

        
        //Load the data if available ### DO NOT CHANGE THIS PART
        try{
            students =(ArrayList<Student>)loadData("students");

        }catch(Exception e){
            students = new ArrayList<>();
        }
        try{
            teachers =(ArrayList<Teacher>)loadData("teachers");
        }catch(Exception e){
            teachers = new ArrayList<>();
        }
        try{
            courses =(ArrayList<Course>)loadData("courses");
        }catch(Exception e){
            courses = new ArrayList<>();
        }


        //############## MAIN MENU STARTS HERE ##############
        


        System.out.println("##### WELCOME #####");
        int choice = 1;
        while(choice > 0){
            //Print the Menu
            System.out.println("1) Add Student"); 
            System.out.println("2) Add Teacher"); 
            System.out.println("3) Add Course"); 
            System.out.println("4) Edit Student"); 
            System.out.println("5) List Student"); 
            System.out.println("6) List Courses"); 
            System.out.println("7) Search for Student");
            System.out.println("0) Exit"); 

            System.out.println();//EMPTY LINE
            //get the choice
            System.out.println("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();//You have to do this
            if(choice  == 1){
                AddStudent();
            }else if(choice == 2){
                AddTeacher();
            }else if(choice == 3){
                AddCourse();
            }
        }
    }
    public static void AddStudent(){
        int choice = 1;
        while(choice > 0){
            //Print the Menu
            System.out.println("#### Add Student ####");
            System.out.println("1) Student Name"); 
            System.out.println("2) Grade Level");
            System.out.println("3) Courses");
            System.out.println("0) Exit");
            System.out.println();//EMPTY LINE
            //get the choice
            System.out.println("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();//You have to do this
            if(choice  == 1){
                AddStudent();
            }else if(choice == 2){
                AddTeacher();
            }else if(choice == 3){
                AddCourse();
            }
        }
        }
    }
    public static void AddTeacher(){
        int choice = 1;
        while(choice > 0){
            //Print the Menu
            System.out.println("#### Add Teacher ####");
            System.out.println("1) Teacher Name"); 
            System.out.println("2) Years of Experience");
            System.out.println("0) Exit");
            System.out.println();//EMPTY LINE
            //get the choice
            System.out.println("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();//You have to do this
        }
    }
    public static void AddCourse(){
        int choice = 1;
        while(choice > 0){
            //Print the Menu
            System.out.println("#### Add Course ####");
            System.out.println("1) Teacher"); 
            System.out.println("2) Subject");
            System.out.println("3) Grade Current");
            System.out.println("0) Exit");
            System.out.println();//EMPTY LINE
            //get the choice
            System.out.println("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();//You have to do this
        }
    }


    //#### DO NOT CHANGE THIS FUNCTION ####
    public static void saveData()throws Exception{
        FileOutputStream f1 = new FileOutputStream("students");
        ObjectOutputStream os = new ObjectOutputStream(f1);
        os.writeObject(students);
        os.close();
        f1.close();

        FileOutputStream f2 = new FileOutputStream("courses");
        os = new ObjectOutputStream(f2);
        os.writeObject(courses);
        os.close();
        f2.close();

        FileOutputStream f3 = new FileOutputStream("teachers");
        os = new ObjectOutputStream(f3);
        os.writeObject(teachers);
        os.close();
        f3.close();
    }

    //#### DO NOT CHANGE THIS FUNCTION ####
    public static Object loadData(String name) throws Exception{
        FileInputStream fis = new FileInputStream(name);
        ObjectInputStream ois = new  ObjectInputStream(fis);   
        Object o = ois.readObject();
        ois.close();
        fis.close();
        return o;
    }
}