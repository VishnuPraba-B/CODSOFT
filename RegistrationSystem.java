import java.util.ArrayList;
import java.util.List;

class RegistrationSystem {
    private List<Course> courses;
    private List<Student> students;

    public RegistrationSystem() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println(course.getCourseCode() + " - " + course.getTitle() +
                    " (" + course.getSchedule() + "), Capacity: " + (course.getCapacity() - course.getRegisteredStudents().size()) + " spots available");
        }
    }

    public void displayStudents() {
        System.out.println("Registered Students:");
        for (Student student : students) {
            System.out.println(student.getStudentId() + " - " + student.getName() +
                    " (" + student.getRegisteredCourses().size() + " courses registered)");
        }
    }

    public static void main(String[] args) {
        RegistrationSystem registrationSystem = new RegistrationSystem();

        Course course1 = new Course("CSC101", "Introduction to Programming", "Basic programming concepts", 30, "MWF 10:00 AM - 11:00 AM");
        Course course2 = new Course("MAT202", "Linear Algebra", "Fundamentals of linear algebra", 25, "TTh 2:00 PM - 3:30 PM");

        Student student1 = new Student(1, "Alice");
        Student student2 = new Student(2, "Bob");

        registrationSystem.addCourse(course1);
        registrationSystem.addCourse(course2);

        registrationSystem.addStudent(student1);
        registrationSystem.addStudent(student2);

        registrationSystem.displayCourses();
        registrationSystem.displayStudents();

        // Example: Student registration for courses
        student1.registerForCourse(course1);
        student2.registerForCourse(course2);

        registrationSystem.displayStudents(); // Display updated student information after registration

        // Example: Drop a course
        student1.dropCourse(course1);

        registrationSystem.displayStudents(); // Display updated student information after dropping a course
    }
}
