package Lab12;
import java.util.List;

public class CookingTasks extends Thread {
    private List<String> tasks;
    public CookingTasks(List<String> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        long t1 = System.currentTimeMillis();
        Restaurant.getRestaurant().washHands();

        int length = tasks.size();
        for (int i = 0; i < length-1; i++) {
            doTask(tasks.get(i));
            try{
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        long t2 = System.currentTimeMillis();
        String lastTask = tasks.get(length-1) + "time:"+ (t2-t1)+"ms";
        doTask(lastTask);
    }
    private void doTask(String task) {
        System.out.println("["+Thread.currentThread().getName()+"] "+task);
        Restaurant.getRestaurant().washDishes();
    }
}