
package Ex2;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * Thread produtor.
 *
 * @maralucilg
 */
public class Prod extends Thread {

  PriorityBlockingQueue<PlayingCard> playingCard;
  CyclicBarrier  prod_barrier;
  CyclicBarrier  con_barrier;
  static Semaphore semaphore = new Semaphore(1);

  public Prod(PriorityBlockingQueue<PlayingCard> playingCard, CyclicBarrier  prod_barrier, CyclicBarrier  con_barrier) {

    this.playingCard = playingCard;
    this.prod_barrier = prod_barrier;
    this.con_barrier = con_barrier;


  }
  
  @Override
  public void run() {

    try{
    while(true) {
      Thread.sleep(500);
      semaphore.acquire();
      if(playingCard.size() < 10){
        PlayingCard card = PlayingCard.roullete();
        playingCard.add(card);
        System.out.println("..." + card);
        semaphore.release();
      }
      else{
        semaphore.release();
        prod_barrier.await();
        con_barrier.await();
      }

    }
    } catch(Exception e){
      e.printStackTrace();
    }

  }
}