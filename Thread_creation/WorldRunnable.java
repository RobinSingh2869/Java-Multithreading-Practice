package Thread_creation;

public class WorldRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <=5; i++) {
            System.out.println("World Runnabl:" + i);
        }
    }
}
