package CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Main2 {
    public static void main(String[] args) {
//        CompletableFuture<String> Future1 = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(5000);
//                System.out.println("Worker");
//            } catch (Exception e) {
//
//            }
//            return "ok";
//        }).thenApply(x -> " x + x");
//        try {
//            System.out.println(Future1.get());
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//
            CompletableFuture<String> Future2 = CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(5000);
                    System.out.println("Worker");
                } catch (Exception f) {

                }
                return "ok";
            }).orTimeout(1, TimeUnit.SECONDS).exceptionally(s -> "Timeout occured");
            try {
                System.out.println(Future2.get());
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            } catch (ExecutionException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
