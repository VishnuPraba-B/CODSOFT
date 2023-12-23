import java.util.ArrayList;
import java.util.List;

class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private List<Student> registeredStudents;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.registeredStudents = new ArrayList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public List<Student> getRegisteredStudents() {
        return registeredStudents;
    }

    public void registerStudent(Student student) {
        if (registeredStudents.size() < capacity) {
            registeredStudents.add(student);
            System.out.println(student.getName() + " has been registered for " + title);
        } else {
            System.out.println("Course is full. Cannot register " + student.getName() + " for " + title);
        }
    }

    public void dropStudent(Student student) {
        registeredStudents.remove(student);
        System.out.println(student.getName() + " has been dropped from " + title);
    }
}
