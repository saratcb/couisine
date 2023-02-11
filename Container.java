package week6.threads.couisine;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Predicate;

public class Container<Dishes> {

    private Deque <Dishes> dishes = new ArrayDeque<>();
    int size;


    Container (int size) {
        this.size = size;

    }
    //boolean busy = true;

    //true if consumer should wait
    // false if chef should wait



    synchronized void add (Dishes dish){
        while (dishes.size() == size){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        dishes.add(dish);
        notifyAll();
    }

    synchronized Dishes remove (){
        while (dishes.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Dishes dishes1 = dishes.remove();
        notifyAll();
        return dishes1;
        }

    }
