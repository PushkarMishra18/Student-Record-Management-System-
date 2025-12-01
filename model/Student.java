package model;

public class Student extends Person {
    public int roll;
    public String course;
    public double marks;

    public Student(int roll, String name, String email, String course, double marks) {
        this.roll = roll;
        this.name = name;
        this.email = email;
        this.course = course;
        this.marks = marks;
    }

    @Override
    public void displayInfo() {
        System.out.println("Roll : " + roll);
        System.out.println("Name : " + name);
        System.out.println("Email: " + email);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
    }

    public String toFile() {
        return roll + "," + name + "," + email + "," + course + "," + marks;
    }

    public static Student fromFile(String line) {
        String[] x = line.split(",");
        return new Student(Integer.parseInt(x[0]), x[1], x[2], x[3], Double.parseDouble(x[4]));
    }
}
