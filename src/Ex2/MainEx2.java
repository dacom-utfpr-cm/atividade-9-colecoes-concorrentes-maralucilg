package Ex2;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.ArrayList;

/*
* 
2. Implemente o problema do produtor/consumidor para uma estrutura com os seguintes campos: 
número, simbolo, naipe, que representa uma carta de baralho. 
A implementação deve possibilitar que após 10 cartas produzidas por dois produtores,
outros dois consumidores pegarão somente as maiores cartas.
Os produtores somente devem produzir mais cartas após os consumidores removerem 3 cartas cada um.
As cartas remanescentes podem continuar na estrutura. 
Use a ordenação do baralho da menor para maior: A, 2, ..., 10, Q, J, K.

  @maralucilg
*/

public class MainEx2 {
    
    public static void main(String[] args) {
    
    PriorityBlockingQueue<PlayingCard> queue = new PriorityBlockingQueue<PlayingCard>(10);
    CyclicBarrier cons = new CyclicBarrier(4);
    CyclicBarrier prod = new CyclicBarrier(4);
    ArrayList<Thread> ths = new ArrayList<Thread>();
    final int SIZE = 2;

    for (int i = 0; i < SIZE; i++) {

      ths.add(new Prod(queue, prod, cons));
      ths.get(ths.size() - 1).start();
    }


     for (int i = 0; i < SIZE; i++) {

      ths.add(new Cons(queue, cons, prod));
      ths.get(ths.size() - 1).start();
     }
  }
    
}