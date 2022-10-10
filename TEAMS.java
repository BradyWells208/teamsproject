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
    static String checkname;


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
            }else if(choice == 4){
                editStudent();
            }else if(choice == 5){
                listStudents();
            }else if(choice == 6){
                listCourses();
            }else if(choice == 7){
                SearchforStudent();
            }else if(choice == 0){
                try{
                    saveData();
                }catch(Exception e){}
            }
        }
    }
    public static void AddStudent(){
        System.out.print("Name: ");
        String n = sc.nextLine();
        sc.nextLine();
        System.out.print("Grade Level: ");
        int gl = sc.nextInt();
        sc.nextLine();
        students.add(new Student(n,gl));
    }
    public static void AddTeacher(){
        System.out.print("Teacher Name: ");
        String n = sc.nextLine();
        sc.nextLine();
        System.out.print("Years of Experience: ");
        int yoe = sc.nextInt();
        sc.nextLine();
        teachers.add(new Teacher(n,yoe));
    }
    public static void AddCourse(){
        System.out.print("Subject ");
        String n = sc.nextLine();
        sc.nextLine();
        System.out.print("Teacher: ");
        for(Teacher i : teachers){
            System.out.println(i);
        }
        int a = sc.nextInt();
        Teacher ans = teachers.get(a);
        sc.nextLine();
        courses.add(new Course(ans,n));
    }
    public static void editStudent(){
        System.out.println("Student");
        listStudents();
        System.out.println();
        System.out.println("Choice: ");
        int n = sc.nextInt();
        sc.nextLine();
        Student s = students.get(n);
        System.out.println("Change Name: ");
        String sn = sc.nextLine();
        s.setName(sn);
        System.out.println("Change Grade level: ");
        int v = sc.nextInt();
        s.setgradeLevel(v);
        System.out.println("Pick a class");
        listCourses();
        System.out.println();
        System.out.println("Choice: ");
        int ans = sc.nextInt();
        sc.nextLine();
        if(ans > -1 && ans < courses.size()){
            Course c = courses.get(ans).clone();
            System.out.println("Enter Grade");
            int grade = sc.nextInt();
            c.setGrade(grade);
            sc.nextLine();
            System.out.println("Currently being taken (y/n)?");
            String yesNo = sc.nextLine();
            if(yesNo.equals("y")){
                c.setCurrent(true);
            }
            Student.addCourse(c);
        }

    }
    public static void listStudents(){
        System.out.println(students);
    }
    public static void listCourses(){
        System.out.println(courses);
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