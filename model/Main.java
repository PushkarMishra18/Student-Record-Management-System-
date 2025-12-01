package mainapp;

import manager.StudentManager;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager sm = new StudentManager();

        while (true) {
            System.out.println("\n===== Student Menu =====");
            System.out.println("1. Add");
            System.out.println("2. View");
            System.out.println("3. Search");
            System.out.println("4. Delete");
            System.out.println("5. Sort by Marks");
            System.out.println("6. Save & Exit");
            System.out.print("Enter choice: ");

            int ch = Integer.parseInt(sc.nextLine());
            if (ch == 1) sm.add(sc);
            else if (ch == 2) sm.view();
            else if (ch == 3) { System.out.print("Enter Name: "); sm.search(sc.nextLine()); }
            else if (ch == 4) { System.out.print("Enter Name: "); sm.delete(sc.nextLine()); }
            else if (ch == 5) sm.sort();
            else if (ch == 6) { sm.save(); System.out.println("Saved & Exit"); break; }
            else System.out.println("Invalid Choice");
        }
    }
}
