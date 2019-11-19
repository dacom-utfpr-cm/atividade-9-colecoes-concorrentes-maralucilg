
package Ex2;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Thread consumidor.
 *
 * @maralucilg
 */
public class Cons extends Thread {

  PriorityBlockingQueue<PlayingCard> playingCard;
  CyclicBarrier  con_barrier;
  CyclicBarrier  prod_barrier;
  int qtd = 0;

  public Cons(PriorityBlockingQueue<PlayingCard> playingCard,
  CyclicBarrier  con_barrier,
  CyclicBarrier  prod_barrier) {

    this.playingCard = playingCard;
    this.con_barrier = con_barrier;
    this.prod_barrier = prod_barrier;
  }

  @Override
  public void run(){

    try {
    while(true) {

      if(qtd == 0){
        prod_barrier.await();
      }
      Thread.sleep(500);
      System.out.print(playingCard.take());
      qtd++;
      if(qtd == 3){
        qtd = 0;
        con_barrier.await();
      }

    }
    } catch(Exception e){
    }
    
  }

  
}