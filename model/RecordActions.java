package manager;

import java.util.Scanner;

public interface RecordActions {
    void add(Scanner sc);
    void view();
    void search(String name);
    void delete(String name);
    void sort();
}
