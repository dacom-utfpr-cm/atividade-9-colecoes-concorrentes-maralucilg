import java.util.Random;
import java.util.concurrent.*;

/**
 * Classe consumidor com LinkedBlockingQueue.
 *
 * @maralucilg
 */

public class ConsumidorLBQ extends Thread {

  LinkedBlockingQueue<Integer> queue;

    public ConsumidorLBQ(LinkedBlockingQueue<Integer> queue) {

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