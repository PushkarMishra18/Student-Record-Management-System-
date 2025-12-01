package manager;

public class Loader implements Runnable {
    public void run() {
        System.out.print("Loading");
        try {
            for (int i = 0; i < 5; i++) { System.out.print("."); Thread.sleep(300); }
        } catch (Exception e) {}
        System.out.println();
    }
}
