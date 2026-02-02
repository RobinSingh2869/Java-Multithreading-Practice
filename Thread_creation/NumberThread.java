package Thread_creation;

public class NumberThread implements Runnable{
    @Override
    public void run() {
        for (int i =0; i<=5; i++){
            System.out.println("Number Thread:" + i);
        }
    }
}
