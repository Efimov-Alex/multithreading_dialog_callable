import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static int mValue = 0;

    public static void main(String[] args) throws InterruptedException, ExecutionException {


        List<Callable<Integer>> callableList = new ArrayList<>();

        MyCallable callable1 = new MyCallable("Поток 1");
        MyCallable callable2 = new MyCallable("Поток 2");
        MyCallable callable3 = new MyCallable("Поток 3");
        MyCallable callable4 = new MyCallable("Поток 4");

        callableList.add(callable1);
        callableList.add(callable2);
        callableList.add(callable3);
        callableList.add(callable4);

        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Future<Integer> task1 = threadPool.submit(callable1);
        Future<Integer> task2 = threadPool.submit(callable2);
        Future<Integer> task3 = threadPool.submit(callable3);
        Future<Integer> task4 = threadPool.submit(callable4);

        try {
            System.out.println(callable1 + "колличество запусков - " + task1.get());
            System.out.println(callable2 + "колличество запусков - " + task2.get());
            System.out.println(callable3 + "колличество запусков - " + task3.get());
            System.out.println(callable4 + "колличество запусков - " + task4.get());

            Integer result = threadPool.invokeAny(callableList);
            System.out.println("Результат одной из задач " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        threadPool.shutdown();

    }

}
