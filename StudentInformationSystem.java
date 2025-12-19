import java.util.Scanner;

/**
 * Main class with menu-driven interface
 */
public class StudentInformationSystem {

    private static StudentManager manager = new StudentManager();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== STUDENT INFORMATION SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> addStudent();
                    case 2 -> viewStudents();
                    case 3 -> searchStudent();
                    case 4 -> updateStudent();
                    case 5 -> exit = true;
                    default -> System.out.println("❌ Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("❌ Please enter numbers only!");
            }
        }

        System.out.println("👋 Application closed.");
    }

    // ADD
    private static void addStudent() {
        System.out.print("Student ID: ");
        String id = sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Grade: ");
        double grade = Double.parseDouble(sc.nextLine());

        System.out.print("Contact: ");
        String contact = sc.nextLine();

        if (!ValidationUtils.isValidAge(age) ||
            !ValidationUtils.isValidGrade(grade) ||
            !ValidationUtils.isValidString(name)) {

            System.out.println("❌ Invalid input!");
            return;
        }

        manager.addStudent(new Student(id, name, age, grade, contact));
        System.out.println("✅ Student added successfully!");
    }

    // VIEW
    private static void viewStudents() {
        if (manager.getAllStudents().isEmpty()) {
            System.out.println("⚠ No students available!");
            return;
        }

        System.out.printf("%-10s %-20s %-5s %-6s %-15s%n",
                "ID", "Name", "Age", "Grade", "Contact");
        System.out.println("------------------------------------------------");

        for (Student s : manager.getAllStudents()) {
            System.out.printf("%-10s %-20s %-5d %-6.2f %-15s%n",
                    s.getStudentId(), s.getName(),
                    s.getAge(), s.getGrade(), s.getContact());
        }
    }

    // SEARCH
    private static void searchStudent() {
        System.out.print("Enter Student ID or Name: ");
        String key = sc.nextLine();

        Student s = manager.searchStudent(key);
        if (s == null) {
            System.out.println("❌ Student not found!");
        } else {
            System.out.println("✅ Student Found");
            System.out.println("ID      : " + s.getStudentId());
            System.out.println("Name    : " + s.getName());
            System.out.println("Age     : " + s.getAge());
            System.out.println("Grade   : " + s.getGrade());
            System.out.println("Contact : " + s.getContact());
        }
    }

    // UPDATE
    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        String id = sc.nextLine();

        Student s = manager.searchStudent(id);
        if (s == null) {
            System.out.println("❌ Student not found!");
            return;
        }

        System.out.print("New Name: ");
        String name = sc.nextLine();

        System.out.print("New Age: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("New Grade: ");
        double grade = Double.parseDouble(sc.nextLine());

        System.out.print("New Contact: ");
        String contact = sc.nextLine();

        if (manager.updateStudent(id, name, age, grade, contact)) {
            System.out.println("✅ Student updated successfully!");
        }
    }
}
