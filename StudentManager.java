import java.util.ArrayList;

/**
 * Handles CRUD operations for students
 */
public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();

    // Add
    public void addStudent(Student student) {
        students.add(student);
    }

    // View all
    public ArrayList<Student> getAllStudents() {
        return students;
    }

    // Search
    public Student searchStudent(String key) {
        for (Student s : students) {
            if (s.getStudentId().equalsIgnoreCase(key) ||
                s.getName().equalsIgnoreCase(key)) {
                return s;
            }
        }
        return null;
    }

    // Update
    public boolean updateStudent(String id, String name, int age, double grade, String contact) {
        Student s = searchStudent(id);
        if (s != null) {
            s.setName(name);
            s.setAge(age);
            s.setGrade(grade);
            s.setContact(contact);
            return true;
        }
        return false;
    }
}
