package manager;

import model.Student;
import java.io.*;
import java.util.*;

public class StudentManager implements RecordActions {
    ArrayList<Student> list = new ArrayList<>();
    String FILE = "students.txt";

    public StudentManager() { load(); }

    private void load() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = br.readLine()) != null) list.add(Student.fromFile(line));
        } catch (Exception e) {}
    }

    public void save() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))) {
            for (Student s : list) bw.write(s.toFile() + "\n");
        } catch (Exception e) {}
    }

    private void effect() {
        Thread t = new Thread(new Loader());
        t.start();
        try { t.join(); } catch(Exception e){}
    }

    public void add(Scanner sc) {
        try {
            System.out.print("Enter Roll: "); int r = Integer.parseInt(sc.nextLine());
            System.out.print("Enter Name: "); String n = sc.nextLine();
            System.out.print("Enter Email: "); String e = sc.nextLine();
            System.out.print("Enter Course: "); String c = sc.nextLine();
            System.out.print("Enter Marks: "); double m = Double.parseDouble(sc.nextLine());
            list.add(new Student(r, n, e, c, m));
            effect();
            System.out.println("Added Successfully");
        } catch (Exception ex) { System.out.println("Invalid Input!"); }
    }

    public void view() {
        if (list.isEmpty()) System.out.println("No Records!");
        else for (Student s : list) { s.displayInfo(); System.out.println(); }
    }

    public void search(String name) {
        for (Student s : list)
            if (s.name.equalsIgnoreCase(name)) { s.displayInfo(); return; }
        System.out.println("Not Found");
    }

    public void delete(String name) {
        Iterator<Student> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().name.equalsIgnoreCase(name)) {
                it.remove();
                System.out.println("Deleted");
                return;
            }
        }
        System.out.println("Not Found");
    }

    public void sort() {
        list.sort((a, b) -> Double.compare(b.marks, a.marks));
        System.out.println("Sorted by Marks");
        view();
    }
}
