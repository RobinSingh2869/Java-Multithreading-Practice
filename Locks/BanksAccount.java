package Locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BanksAccount {
    private int balance = 100;

    //Lock
    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
        try {
//            lock.lock(); keep waiting
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                if(balance>=amount){
                    try{
                    System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal ");
                    Thread.sleep(3000);
                    balance -=amount;
                    System.out.println(Thread.currentThread().getName()+ " Completed Withdrawl ");
                }catch (Exception e){
                    Thread.currentThread().interrupt();
                    }
                    finally {
                        lock.unlock();
                    }
                } else{
                    System.out.println(Thread.currentThread().getName() + "insufficient balance");
                }
            }else {
                System.out.println(Thread.currentThread().getName() + "could not acquire the lock, will try later");
            }
        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
            Thread.currentThread().interrupt();
        }
    }
}
