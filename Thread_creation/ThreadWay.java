package Thread_creation;

public class ThreadWay {
    public static void main(String[] args) {
        World w = new World();
        w.run();
        try{
            Thread.sleep(500);
        }
        catch (Exception e){};
        for (int i = 0; i <=5 ; i++) {
            System.out.println("Main Thread:"+ i);
        }
    }
}
