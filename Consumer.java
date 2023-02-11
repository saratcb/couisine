package week6.threads.couisine;

public class Consumer implements Runnable{

    int numberOfDishesAsked;

    private Container<DishType> queue;

    public Consumer(Container<DishType> queue, int numberOfDishesAsked) {
        this.queue = queue;
        this.numberOfDishesAsked = numberOfDishesAsked;
    }

    @Override
    public void run() {
        for (int i = 0; i < numberOfDishesAsked; i++) {
            DishType dish = queue.remove();
            System.out.println("Client " + Thread.currentThread().getName() + " just ate " + dish);
        }
    }
}
