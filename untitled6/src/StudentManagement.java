import java.util.*;

class Student {
    private String fullName;
    private String lastName;
    private int age;
    private String course;

    // Constructor
    public Student(String fullName, int age, String course) {
        this.fullName = fullName;
        this.lastName = fullName.split(" ")[fullName.split(" ").length - 1];
        this.age = age;
        this.course = course;
    }

    // Getter and Setter methods
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
        this.lastName = fullName.split(" ")[fullName.split(" ").length - 1];
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Full Name: " + fullName + ", Age: " + age + ", Course: " + course;
    }
}

public class StudentManagement {
    private static List<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Enter student list");
            System.out.println("2. Find students by last name");
            System.out.println("3. Find and edit students by full name");
            System.out.println("4. End");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    enterStudentList();
                    break;
                case 2:
                    findStudentsByLastName();
                    break;
                case 3:
                    findAndEditStudentByFullName();
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Function to enter student list
    private static void enterStudentList() {
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter full name: ");
            String fullName = scanner.nextLine();
            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character
            System.out.print("Enter course: ");
            String course = scanner.nextLine();

            Student student = new Student(fullName, age, course);
            studentList.add(student);
            System.out.println("Student added: " + student);
        }
    }

    // Function to find students by last name
    private static void findStudentsByLastName() {
        System.out.print("Enter last name to search: ");
        String lastName = scanner.nextLine();

        boolean found = false;
        for (Student student : studentList) {
            if (student.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found with the last name " + lastName);
        }
    }

    // Function to find and edit students by full name
    private static void findAndEditStudentByFullName() {
        System.out.print("Enter full name to search and edit: ");
        String fullName = scanner.nextLine();

        Student studentToEdit = null;
        for (Student student : studentList) {
            if (student.getFullName().equalsIgnoreCase(fullName)) {
                studentToEdit = student;
                break;
            }
        }

        if (studentToEdit != null) {
            System.out.println("Student found: " + studentToEdit);
            System.out.println("1. Edit name");
            System.out.println("2. Edit age");
            System.out.println("3. Edit course");
            System.out.print("Choose option to edit: ");
            int editChoice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (editChoice) {
                case 1:
                    System.out.print("Enter new full name: ");
                    String newName = scanner.nextLine();
                    studentToEdit.setFullName(newName);
                    break;
                case 2:
                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    studentToEdit.setAge(newAge);
                    break;
                case 3:
                    System.out.print("Enter new course: ");
                    String newCourse = scanner.nextLine();
                    studentToEdit.setCourse(newCourse);
                    break;
                default:
                    System.out.println("Invalid option.");
            }

            System.out.println("Updated student: " + studentToEdit);
        } else {
            System.out.println("Student not found with full name " + fullName);
        }
    }
}
