package CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main1 {
    public static void main(String[] args) {
        try {
            String Future1 = CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(5000);
                    System.out.println("Worker");
                } catch (Exception e) {

                }
                return "ok";
            }).get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main");
    }
}
