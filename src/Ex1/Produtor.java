import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Classe produtor com ArrayBlockingQueue.
 *
 * @maralucilg
 */
public class Produtor extends Thread {

  ArrayBlockingQueue<Integer> queue;

  public Produtor(ArrayBlockingQueue<Integer> queue) {

    this.queue = queue;
  }

  @Override
  public void run() {

    Random r = new Random();

    try{

    queue.put(r.nextInt(10));

    } catch (Exception e) {
      
    System.out.println(e.getMessage());
    }
  }
    
}