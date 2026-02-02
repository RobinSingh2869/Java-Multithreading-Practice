package Thread_creation;

public class MainThread {
    public static void main(String[] args) {
        NumberThread Nt = new NumberThread();
        Thread t1 = new Thread(Nt);
        t1.start();
        for (char c = 'A'; c <= 'E'; c++) {
            System.out.println("MainThread:" + c);
        }
    }
}
