import java.util.Date;
import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.*;

/*
* 1. Implemente duas versões do problema do produtor/consumidor com M produtores e N consumidores usando ArrayBlockingQueue e LinkedBlockingQueue. Compare o desempenho das duas implementações.

  @maralucilg
*/

public class MainEx1 {
  public static void main(String[] args) {
   ArrayBlockingQueue<Integer> q1 = new  ArrayBlockingQueue<Integer>(3);

   LinkedBlockingQueue<Integer> q2 = new  LinkedBlockingQueue<Integer>(3);

   ArrayList<Thread> t1 = new ArrayList<Thread>();

   ArrayList<Thread> t2 = new ArrayList<Thread>();

    final int SIZE = 10;

    Date d = new Date();

    for(int i = 0; i < SIZE; i++) {

      t1.add(new Produtor(q1));
      t1.get(t1.size() - 1).start();
    }

    for(int i = 0; i < SIZE; i++) {

       t1.add(new Consumidor(q1));
       t1.get(t1.size() - 1).start();
    }

    for(Thread i: t1) {
      try{
      i.join();
      }
      catch(Exception e){

      }
    }
  // O ArrayBlockingQueue é mais lento
    System.out.println("Tempo ArrayBlockingQueue: " + (new Date().getTime() - d.getTime()));


    d = new Date();

    for(int i = 0; i < SIZE; i++) {

      t2.add(new ProdutorLBQ(q2));
      t2.get(t2.size() - 1).start();
    }

    for(int i = 0; i < SIZE; i++) {

      t2.add(new ConsumidorLBQ(q2));
      t2.get(t2.size() - 1).start();
    }

    for(Thread i: t2){

       try{
      i.join();
      }
      catch(Exception e){

      }

    }

  System.out.println("Tempo LinkedBlockingQueue: " + (new Date().getTime() - d.getTime()));
  }
}
