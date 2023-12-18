import java.util.*;

//class to store student management data
class StudentDetails {
    protected String name;
    protected String rollNumber;
    protected int age;
    protected String grade;

    public StudentDetails(String name, String rollNumber,int age, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }
    public int getAge(){
        return age;
    }

    public String getGrade() {
        return grade;
    }
}

class StudentManagementData {
    protected ArrayList<StudentDetails> students;

    public StudentManagementData() {
        students = new ArrayList<>();
    }

    public void addStudent(StudentDetails student) {
        students.add(student);
        System.out.println("\nStudent Details : " );
        System.out.println("Name : " + student.getName());
        System.out.println("Roll number : " + student.getRollNumber());
        System.out.println("Age : " + student.getAge());
        System.out.println("Grade : " + student.getGrade());
        System.out.println(" is added successfully.");
    }
    public void removeStudent(String rollNumber) {
        Iterator<StudentDetails> iterator = students.iterator();
        boolean studentFound = false;

        while (iterator.hasNext()) {
            StudentDetails student = iterator.next();
            String check = student.getRollNumber();

            if (rollNumber.equals(check)) {
                iterator.remove();
                System.out.println("Student with roll number " + rollNumber + " [ " + student.getName() + " ] " + " removed successfully.");
                studentFound = true;
                break;
            }
        }

        if (!studentFound) {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        }
    }


    public void find_a_Student(String rollNumber) {
        if (!students.isEmpty()) {
            for (StudentDetails student : students) {
                String check = student.getRollNumber();
                if (check.equals(rollNumber)) {
                    System.out.println("Student with Roll Number " + rollNumber + " is " + student.getName());
                    System.out.println( student.getName() + "'s Details:");
                    System.out.println();
                    System.out.println("Name : " + student.getName());
                    System.out.println("Roll number : " + student.getRollNumber());
                    System.out.println("Age : " + student.getAge());
                    System.out.println("Grade : " + student.getGrade()+"\n");

                } else {
                    System.out.println("Student with Roll Number " + rollNumber + " not found.");
                }
            }
        }
        else{
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        }
    }

    public void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students data is stored in the Student Management system.");
        } else {
            for (StudentDetails student : students) {
                System.out.println("\nStudent Details : " );
                System.out.println("Name : " + student.getName());
                System.out.println("Roll number : " + student.getRollNumber());
                System.out.println("Age : " + student.getAge());
                System.out.println("Grade : " + student.getGrade()+"\n");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentManagementData student_datafile = new StudentManagementData();

        while (true) {
            System.out.println("\nStudent Management Data Menu:");
            System.out.println("1 => Add Student");
            System.out.println("2 => Remove Student");
            System.out.println("3 => Search Student");
            System.out.println("4 => Display All Students");
            System.out.println("5 => Exit");
            System.out.print("Enter your choice: ");

            int input_choice = input.nextInt();
            input.nextLine();

            if(input_choice == 1) {
                System.out.print("Enter student name: ");
                String name = input.nextLine();
                System.out.print("Enter roll number: ");
                String rollNumber = input.nextLine();
                System.out.print("Enter age: ");
                int age = input.nextInt();
                input.nextLine();
                System.out.print("Enter grade: ");
                String grade = input.nextLine();

                student_datafile.addStudent(new StudentDetails(name, rollNumber, age, grade));
            }
            else if(input_choice == 2) {
                System.out.print("Enter roll number to remove: ");
                String removeRollNumber = input.nextLine();
                student_datafile.removeStudent(removeRollNumber);
            }
            else if(input_choice == 3) {
                System.out.print("Enter roll number to search: ");
                String searchRollNumber = input.nextLine();
                student_datafile.find_a_Student(searchRollNumber);
            }
            else if(input_choice == 4) {
                student_datafile.showAllStudents();
            }
            else if(input_choice == 5) {
                System.out.println("Thank you ! Come again.");
                input.close();
                System.exit(0);
            }
            else{
                    System.out.println("Invalid choice, Please enter a number between 1 and 5.");
            }
        }
    }
}
