import java.util.*;
class Student {
    private int id;
    private String name;
    private String branch;
    private String email;
    private String phoneNumber;
    private double marks;
    private double attendance;
    //getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getBranch() {
        return branch;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public double getMarks() {
        return marks;
    }
    public double getAttendance() {
        return attendance;
    }
    //setters
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setMarks(double marks) {
        this.marks = marks;
    }
    public void setAttendance(double attendance) {
        this.attendance = attendance;
    }
    //constructor
    Student(int id, String name, String branch, String email, String phoneNumber, double marks, double attendance) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.marks = marks;
        this.attendance = attendance;
    }
}

class StudentService {
    //ds to store students
    private HashMap<Integer, Student> map = new HashMap<>();
    //add a student
    public void addStudent(Student student) {
        //get the student id
        int id = student.getId();
        //check if that student already exists in map
        if (map.containsKey(id)) {
            System.out.println("A student with this ID already exists!");
            return;
        }
        //add the student to the map
        map.put(id, student);
        System.out.println("Student added successfully!");
    }
    //view a student
    public Student viewStudent(int id) {
        if (map.containsKey(id)) {
            Student s = map.get(id);
            System.out.println("Id: " + s.getId());
            System.out.println("Name: " + s.getName());
            System.out.println("Branch: " + s.getBranch());
            System.out.println("Email: " + s.getEmail());
            System.out.println("Phone: " + s.getPhoneNumber());
            System.out.println("Marks: " + s.getMarks());
            System.out.println("Attendance: " + s.getAttendance());
            return s;
        } else {
            System.out.println("Student not found");
            return null;
        }
    }
    //update student details
    public void updateStudent(int id, Scanner sc) {
        if (map.containsKey(id)) {
            Student s = map.get(id);
            System.out.println("Updating details for student ID " + id);
            System.out.println("Current Name: " + s.getName());
            System.out.println("Current Branch: " + s.getBranch());
            System.out.println("Current Email: " + s.getEmail());
            System.out.println("Current Phone: " + s.getPhoneNumber());
            System.out.println("Current Marks: " + s.getMarks());
            System.out.println("Current Attendance: " + s.getAttendance());
            
            String name = Validation.validateName(sc);
            String branch = Validation.validateBranch(sc);
            String email = Validation.validateEmail(sc);
            String phone = Validation.validatePhone(sc);
            double marks = Validation.validateMarks(sc);
            double attendance = Validation.validateAttendance(sc);

            s.setName(name);
            s.setBranch(branch);
            s.setEmail(email);
            s.setPhoneNumber(phone);
            s.setMarks(marks);
            s.setAttendance(attendance);

            System.out.println("Student details updated successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }
    //delete a student
    public void deleteStudent(int id) {
        if (map.containsKey(id)) {
            map.remove(id);
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }
    //display all students
    public void displayAllStudents() {
        if (map.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student s : map.values()) {
                System.out.println("---------------------------");
                System.out.println("Id: " + s.getId() + ", Name: " + s.getName() + ", Branch: " + s.getBranch() +", Marks: "+s.getMarks()+", Attendance: "+s.getAttendance());
            }
        }
    }
}

class Validation {
    public static int validateId(Scanner sc) {
        int id;
        while (true) {
            System.out.print("Enter id(positive integer): ");
            if (sc.hasNextInt()) {
                id = sc.nextInt();
                if (id > 0) break;
                else System.out.println("Id must be positive!");
            } else {
                System.out.println("Invalid input! Enter a number.");
                sc.next(); 
            }
        }
        return id;
    }
    public static String validateName(Scanner sc) {
        String name;
        while (true) {
            System.out.print("Enter Name: ");
            name = sc.nextLine();
            if (name.matches("[A-Za-z ]+")){
                return name;
            }
            else System.out.println("Name can only contain letters and spaces!");
        }
    }
    public static String validateBranch(Scanner sc) {
        String branch;
        while (true) {
            System.out.print("Enter Branch: ");
            branch = sc.nextLine();
            if (branch.matches("[A-Za-z]+")) break;
            else System.out.println("Branch can only contain letters!");
        }
        return branch;
    }
    public static String validateEmail(Scanner sc) {
        String email;
        while (true) {
            System.out.print("Enter Email: ");
            email = sc.nextLine();
            if (email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) break;
            else System.out.println("Invalid email format!");
        }
        return email;
    }
    public static String validatePhone(Scanner sc) {
        String phone;
        while (true) {
            System.out.print("Enter Phone Number (10 digits): ");
            phone = sc.nextLine();
            if (phone.matches("\\d{10}")) break;
            else System.out.println("Phone number must be 10 digits!");
        }
        return phone;
    }
    public static double validateMarks(Scanner sc) {
        double marks;
        while (true) {
            System.out.print("Enter Marks (0-100): ");
            if (sc.hasNextDouble()) {
                marks = sc.nextDouble();
                if (marks >= 0 && marks <= 100){
                    return marks;
                }
                else System.out.println("Marks must be between 0 and 100!");
            } else {
                System.out.println("Invalid input! Enter a number.");
                sc.next();
            }
        }
    }
    public static double validateAttendance(Scanner sc) {
        double attendance;
        while (true) {
            System.out.print("Enter Attendance (0-100): ");
            if (sc.hasNextDouble()) {
                attendance = sc.nextDouble();
                if (attendance >= 0 && attendance <= 100) break;
                else System.out.println("Attendance must be between 0 and 100!");
            } else {
                System.out.println("Invalid input! Enter a number.");
                sc.next();
            }
        }
        return attendance;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();
        int choice; 
        do {
            System.out.println("\nWelcome to the Student Management System");
            System.out.println("=======Main Menu=======");
            System.out.println("1. Add a Student");
            System.out.println("2. View a Student");
            System.out.println("3. Update details of a Student");
            System.out.println("4. Delete a Student");
            System.out.println("5. Display all the Students");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        addStudent(service, sc);
                        break;
                    case 2:
                        viewStudent(service, sc);
                        break;
                    case 3:
                        updateStudent(service, sc);
                        break;
                    case 4:
                        deleteStudent(service, sc);
                        break;
                    case 5:
                        service.displayAllStudents();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                        break;
                }
            } else {
                System.out.println("Invalid input! Enter a number.");
                sc.next();
                choice = 0; 
            }
        } while (choice != 6);
        sc.close();
    }

    //add student
    public static void addStudent(StudentService service, Scanner sc) {
        int id = Validation.validateId(sc);
        String name = Validation.validateName(sc);
        String branch = Validation.validateBranch(sc);
        String email = Validation.validateEmail(sc);
        String phone = Validation.validatePhone(sc);
        double marks = Validation.validateMarks(sc);
        double attendance = Validation.validateAttendance(sc);
        Student s = new Student(id, name, branch, email, phone, marks, attendance);
        service.addStudent(s);
    }

    public static void viewStudent(StudentService service, Scanner sc) {
        System.out.println("Enter ID to view: ");
        if (sc.hasNextInt()) {
            int id = sc.nextInt();
            service.viewStudent(id);
        } else {
            System.out.println("Invalid ID format!");
            sc.next();
        }
    }

    public static void updateStudent(StudentService service, Scanner sc) {
        System.out.print("Enter ID to update: ");
        if (sc.hasNextInt()) {
            int id = sc.nextInt();
            service.updateStudent(id, sc);
        } else {
            System.out.println("Invalid ID format!");
            sc.next();
        }
    }

    public static void deleteStudent(StudentService service, Scanner sc) {
        System.out.print("Enter ID to delete: ");
        if (sc.hasNextInt()) {
            int id = sc.nextInt();
            service.deleteStudent(id);
        } else {
            System.out.println("Invalid ID format!");
            sc.next();
        }
    }
}