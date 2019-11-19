import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Classe produtor com ArrayBlockingQueue.
 *
 * @maralucilg
 */
public class Consumidor extends Thread {

    ArrayBlockingQueue<Integer> queue;

    public Consumidor(ArrayBlockingQueue<Integer> queue) {

      this.queue = queue;

    }

    @Override
    public void run(){

      try{
      System.out.println(queue.take());
      }
      catch(Exception e) {

      }
    }

    
}