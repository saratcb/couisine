package week6.threads.couisine;

public class Main {

    public static void main(String[] args) {

        Container<DishType> queue = new Container<>(10);

        Chef alberto = new Chef(queue, 80);
        Thread t1 = new Thread(alberto);
        t1.setName("alberto");

        Chef clara = new Chef(queue, 4);
        Thread t2 = new Thread(clara);
        t2.setName("clara");

        Consumer c1 = new Consumer(queue, 17);
        Thread t3 = new Thread(c1);
        t3.setName("c1");

        Consumer c2 = new Consumer(queue, 40);
        Thread t4 = new Thread(c2);
        t4.setName("c2");

        t3.start();
        t4.start();

        t1.start();
        t2.start();

    }

}
