package CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        CompletableFuture<String> Future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Worker");
            } catch (Exception e) {

            }
            return "ok";
        });
        CompletableFuture<String> Future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Worker");
            } catch (Exception e) {

            }
            return "ok";
        });
        CompletableFuture<Void> f = CompletableFuture.allOf(Future1, Future2);
        f.join();
        System.out.println("main");
    }
}
