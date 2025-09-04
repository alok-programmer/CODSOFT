  import java.io.*;
import java.util.*;


class Student implements Serializable {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNumber + ", Name: " + name + ", Grade: " + grade;
    }
}


class StudentManagementSystem {
    private List<Student> students;
    private final String FILE_NAME = "students.dat";

    public StudentManagementSystem() {
        students = new ArrayList<>();
        loadStudents();
    }

    
    public void addStudent(Student student) {
        students.add(student);
        saveStudents();
        System.out.println(" Student added successfully.");
    }


    public void removeStudent(int rollNumber) {
        students.removeIf(s -> s.getRollNumber() == rollNumber);
        saveStudents();
        System.out.println(" Student removed successfully.");
    }

    
    public Student searchStudent(int rollNumber) {
        for (Student s : students) {
            if (s.getRollNumber() == rollNumber) {
                return s;
            }
        }
        return null;
    }

    
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println(" No students found.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    
    private void saveStudents() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println(" Error saving data.");
        }
    }

    
    @SuppressWarnings("unchecked")
    private void loadStudents() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            students = new ArrayList<>();
        }
    }
}


public class StudentManagementApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Roll Number: ");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();

                    if (name.isEmpty() || grade.isEmpty()) {
                        System.out.println(" Fields cannot be empty!");
                    } else {
                        sms.addStudent(new Student(name, roll, grade));
                    }
                    break;

                case 2:
                    System.out.print("Enter Roll Number to remove: ");
                    int r = sc.nextInt();
                    sms.removeStudent(r);
                    break;

                case 3:
                    System.out.print("Enter Roll Number to search: ");
                    int sRoll = sc.nextInt();
                    Student s = sms.searchStudent(sRoll);
                    if (s != null) {
                        System.out.println(" Student Found: " + s);
                    } else {
                        System.out.println(" Student not found.");
                    }
                    break;

                case 4:
                    sms.displayStudents();
                    break;

                case 5:
                    System.out.println(" Exiting... Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println(" Invalid choice. Please try again.");
            }
        }
    }
}
