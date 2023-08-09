import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private String name;
    private int mValue = 0;

    public MyCallable(String name) {
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        Thread.currentThread().setName(name);
        try {
            for (int i = 0; i < 3; i++) {
                Thread.sleep(500);
                mValue++;
                System.out.println("Я " + Thread.currentThread().getName() + ". Всем привет!");
            }
        } catch (InterruptedException err) {

        } finally {
            System.out.printf("%s завершен\n", Thread.currentThread().getName());
            return mValue;
        }

    }

    @Override
    public String toString() {
        return name;
    }
}
