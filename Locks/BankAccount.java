package Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;

    //Lock
    private final Lock lock = new ReentrantLock();




    public synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
        if (balance>= amount){
            System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal ");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName()+ " Completed Withdrawl ");
        }else{
            System.out.println(Thread.currentThread().getName() + "insufficient balance");
        }
    }
}
