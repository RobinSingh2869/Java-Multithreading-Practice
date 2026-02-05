package Synchronization;

public class Counter {
    private int count = 0;

    public synchronized void increment() {
        // if we want to synchronize one block/ section of code then we can do :
        // synchronize(this){ //this means one instance in which method is calling
        //}
        count++;
        //Mutual Exclusion
        System.out.println(Thread.currentThread().getName());
    }

    public int getCount(){
        return count;
    }
}
