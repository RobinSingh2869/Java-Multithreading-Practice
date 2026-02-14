package Executor_Framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main5 {
    public static void main(String[] args) {
        Executors.newFixedThreadPool(2 );
        ExecutorService executorService = Executors.newCachedThreadPool();
        // cached dynamically creates new thread as per requirement
        //used when load is variable , and load should be not time-consuming
        //after 60 second  thread get killed ?
    }
}
