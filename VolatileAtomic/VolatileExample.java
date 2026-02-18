package VolatileAtomic;

class SharedObj{
    private volatile boolean flag = false;

    public void setFlagTrue(){
        System.out.println("flag true");
        flag = true;
    }
    public void printifFlagTrue(){
        while(!flag){
            // do nothing
        }
        System.out.println("Flag is true! ");
    }
}
public class VolatileExample {
    public static void main(String[] args) {
        SharedObj sharedObj = new SharedObj();
        Thread writerThread = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            sharedObj.setFlagTrue();
        });

        Thread readerThread = new Thread(()->{
            sharedObj.printifFlagTrue();
        });
        writerThread.start();
        readerThread.start();
    }
}
