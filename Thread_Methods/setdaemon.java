package Thread_Methods;

public class setdaemon extends Thread{
    @Override
    public void run() {
        while (true){
            System.out.println("Hello World ! ");
        }
    }

    public static void main(String[] args) {
        setdaemon t1 = new setdaemon();
        t1.setDaemon(true);
        setdaemon t2 = new setdaemon();
        t2.start();
        t1.start();
        System.out.println("Main done  ");
    }
}
//Daemon Thread - works in background like Garbage collector
//user threads