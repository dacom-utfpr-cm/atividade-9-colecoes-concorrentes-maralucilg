import java.util.Random;
import java.util.concurrent.*;

/**
 * Classe produtor com LinkedBlockingQueue.
 *
 * @maralucilg
 */
public class ProdutorLBQ extends Thread {

   LinkedBlockingQueue<Integer> queue;

  public ProdutorLBQ(LinkedBlockingQueue<Integer> queue) {

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