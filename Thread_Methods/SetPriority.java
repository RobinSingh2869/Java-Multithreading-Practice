package Thread_Methods;

public class SetPriority extends Thread {

    public SetPriority(String name){
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i <=5 ; i++) {
            System.out.println(Thread.currentThread().getName() +" - Priority: " + Thread.currentThread().getPriority() + "-count" + i);
            try{
                Thread.sleep(1000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        SetPriority s1 = new SetPriority("Robin");
        s1.setPriority(Thread.MIN_PRIORITY);
        s1.start();
        //5:34
    }
}
