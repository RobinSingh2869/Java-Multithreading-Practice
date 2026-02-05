package Thread_Methods;

import java.util.Set;

public class SetPriority extends Thread {

    public SetPriority(String name){
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i <=5 ; i++) {
            String  a = "";
            for (int j = 0; j <10000 ; j++) {
                 a+='a';
            }
            System.out.println(Thread.currentThread().getName() +" - Priority: " + Thread.currentThread().getPriority() + "-count" + i);
            try{
                Thread.sleep(1000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        SetPriority s1 = new SetPriority("Low Priority Thread");
        SetPriority s2 = new SetPriority("Medium Priority Thread ");
        SetPriority s3 = new SetPriority("High Priority Thread");
        s1.setPriority(Thread.MIN_PRIORITY);
        s2.setPriority(Thread.NORM_PRIORITY);
        s3.setPriority(Thread.MAX_PRIORITY);
        s1.start();
        s2.start();
        s3.start();


    }
}
