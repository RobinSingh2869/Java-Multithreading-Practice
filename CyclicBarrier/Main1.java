package CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main1 {
    public static void main(String[] args) {
        int numberofSubsystems = 4;
        CyclicBarrier barrier = new CyclicBarrier(numberofSubsystems, new Runnable() {
            @Override
            public void run() {
                System.out.println("All subsytems are up and running, system startup complete ");
            }
        });
        Thread webserverThread = new Thread(new Subsystem( " web server", 2000, barrier));
        Thread databaseThread = new Thread(new Subsystem( " Database ", 4000, barrier));
        Thread cacheThread = new Thread(new Subsystem( " cache", 3000, barrier));
        Thread messagingserviceThread = new Thread(new Subsystem( " Messaging server", 3500, barrier));

        webserverThread.start();
        databaseThread.start();
        cacheThread.start();
        messagingserviceThread.start();
    }
}
class Subsystem implements Runnable{
    private String name;
    private int initializationTime;
    private CyclicBarrier barrier;

    public Subsystem(String name, int initializatioTime, CyclicBarrier barrier ){
        this.name = name;
        this.initializationTime = initializatioTime;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try{
            System.out.println(name + " initialization started ");
            Thread.sleep(initializationTime);
            System.out.println(name + "initialization complete");
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}