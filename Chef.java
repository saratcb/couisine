package week6.threads.couisine;

import java.util.Random;

public class Chef implements Runnable {

    private Container<DishType> queue ;
    int numberOfDishesProduced;

    public Chef(Container<DishType> queue, int numberOfDishes) {
        this.queue = queue;
        this.numberOfDishesProduced = numberOfDishes;
    }

    @Override
    public void run() {

        for (int i = 0; i < numberOfDishesProduced; i++) {
            Random random = new Random();
            DishType dishType = DishType.values()[random.nextInt(DishType.values().length)];

            System.out.println("Chef " + Thread.currentThread().getName()+ " just cooked " + dishType);
            queue.add(dishType);
        }

    }
}
