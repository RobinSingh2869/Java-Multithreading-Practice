package LambdaExpression;

public class Example {
    public static void main(String[] args) {
//        Runnable runnable = () -> System.out.println("Hello");
//        Thread t1 = new Thread(runnable);
//        t1.start();
            Thread t1 = new Thread(() -> System.out.println("Hello"));
            t1.start();
    }
}
