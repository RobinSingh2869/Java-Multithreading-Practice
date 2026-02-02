package Thread_creation;

public class TwoThreads {
    public static void main(String[] args) {
        System.out.println("Main Running");
        odd Odd = new odd();
        Thread t1 = new Thread(Odd);
        t1.start();

        even Even = new even();
        Thread t2 = new Thread(Even);
        t2.start();

    }
}
