package Thread_creation;

public class odd implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <=10 ; i++) {
            if(i%2!=0){
                System.out.println("odd:" + i);
            }
        }
    }
}
