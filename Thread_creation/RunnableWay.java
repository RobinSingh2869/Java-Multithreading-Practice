package Thread_creation;

public class RunnableWay {
    public static void main(String[] args) {
        WorldRunnable wr = new WorldRunnable();
        Thread t = new Thread(wr);
        t.run();

        for (int i = 0; i <=10 ; i++) {
            System.out.println(Thread.currentThread().getName() + ":"+ i);
        }
    }
}
