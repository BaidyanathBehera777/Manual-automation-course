package edusmart.app;

interface ProgressTrackable {
    void trackProgress();
}

abstract class User {
    private String name;
    private String email;
    private String userId;

    public User(String name, String email, String userId) {
        this.name = name;
        this.email = email;
        this.userId = userId;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getUserId() { return userId; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setUserId(String userId) { this.userId = userId; }

    public abstract void viewProfile();

    public final void displayWelcome() {
        System.out.println("Welcome to EduSmart, " + name + "!");
    }
}

class Student extends User implements ProgressTrackable {
    private String enrolledCourse1;
    private String enrolledCourse2;

    public Student(String name, String email, String userId) {
        super(name, email, userId);
        this.enrolledCourse1 = null;
        this.enrolledCourse2 = null;
    }

    public void enrollCourse(String courseName) {
        if (this.enrolledCourse1 == null) {
            this.enrolledCourse1 = courseName;
        } else if (this.enrolledCourse2 == null) {
            this.enrolledCourse2 = courseName;
        } else {
            System.out.println(getName() + " has already enrolled in 2 courses.");
        }
    }

    public void enrollCourse() {
        System.out.println("No course name provided.");
    }

    @Override
    public void viewProfile() {
        System.out.println("📘 Student Profile");
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("ID: " + getUserId());
        System.out.println("Courses: " + enrolledCourse1 + ", " + enrolledCourse2);
    }

    @Override
    public void trackProgress() {
        System.out.println(getName() + " is tracking progress in their enrolled courses...");
    }
}

class Instructor extends User {
    private String createdCourse1;
    private String createdCourse2;

    public Instructor(String name, String email, String userId) {
        super(name, email, userId);
    }

    public void createCourse(String courseName) {
        if (createdCourse1 == null) {
            createdCourse1 = courseName;
        } else if (createdCourse2 == null) {
            createdCourse2 = courseName;
        } else {
            System.out.println(getName() + " has already created 2 courses.");
        }
    }

    public String getCreatedCourse1() { return createdCourse1; }
    public String getCreatedCourse2() { return createdCourse2; }

    @Override
    public void viewProfile() {
        System.out.println("📘 Instructor Profile");
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("ID: " + getUserId());
        System.out.println("Courses Created: " + createdCourse1 + ", " + createdCourse2);
    }
}

class Admin extends User {
    public Admin(String name, String email, String userId) {
        super(name, email, userId);
    }

    public void removeUser(User user) {
        System.out.println("✅ Admin removed user: " + user.getName());
    }

    @Override
    public void viewProfile() {
        System.out.println("📘 Admin Profile");
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("ID: " + getUserId());
    }
}

class Course {
    private String title;
    private int durationInHours;
    private final int maxStudents;

    public Course(String title, int durationInHours, int maxStudents) {
        this.title = title;
        this.durationInHours = durationInHours;
        this.maxStudents = maxStudents;
    }

    public Course(String title) {
        this(title, 0, 50); // Default values
    }

    public void showCourseDetails() {
        System.out.println("\n📚 Course Details");
        System.out.println("Title: " + title);
        System.out.println("Duration: " + durationInHours + " hours");
        System.out.println("Max Students: " + maxStudents);
    }
}

public class EduSmartApp {
    public static void main(String[] args) {
        Student s1 = new Student("Alice", "alice@example.com", "S001");
        Student s2 = new Student("Bob", "bob@example.com", "S002");

        Instructor i1 = new Instructor("Emma", "emma@edusmart.com", "I001");
        Instructor i2 = new Instructor("Liam", "liam@edusmart.com", "I002");

        Admin admin = new Admin("Raj", "admin@edusmart.com", "A001");

        i1.createCourse("Java Basics");
        i1.createCourse("OOP Concepts");

        i2.createCourse("Data Structures");
        i2.createCourse("Web Development");

        s1.enrollCourse("Java Basics");
        s1.enrollCourse("Web Development");

        s2.enrollCourse("OOP Concepts");
        s2.enrollCourse("Data Structures");

        System.out.println("\n=== User Profiles ===");
        s1.viewProfile();
        s2.viewProfile();
        i1.viewProfile();
        i2.viewProfile();
        admin.viewProfile();

        System.out.println("\n=== Progress Tracking ===");
        s1.trackProgress();
        s2.trackProgress();

        System.out.println("\n=== Admin Action ===");
        admin.removeUser(s2);

        System.out.println("\n=== Course Catalog ===");
        Course c1 = new Course("Machine Learning", 40, 100);
        Course c2 = new Course("Python");

        c1.showCourseDetails();
        c2.showCourseDetails();
    }
}

