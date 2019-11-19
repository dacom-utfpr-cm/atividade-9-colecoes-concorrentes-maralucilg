
package Ex2;

import java.util.Random;

/**
 * Essa classe representa a estrutura de dados carta de jogo.
 *
 * @maralucilg
 */
public class PlayingCard implements Comparable<PlayingCard> {

String suits; // naipe
String face; // tipo de cartas
int number;
static String[] suits_array = new String[] {"diamonds", "clubs", "hearts", "spades" };
static String[] faces = new String[] {"Q", "J", "K"};


public PlayingCard(int number, String suits, String face) {

  this.suits = suits;
  this.face = face;
  this.number = number;
}

static int getGreater(PlayingCard Playingcard) {

		if (Playingcard.face.equals("K")) {
			return 13;
		} else if (Playingcard.face.equals("J")) {
			return 12;
		} else if (Playingcard.face.equals("Q")) {
			return 11;
		} 
                
                else {
                    
                    return Playingcard.number;
                }
                    
    
	}

static PlayingCard roullete() {


  Random r = new Random();

  int number = r.nextInt(13) + 1;
  int suits = r.nextInt(4);

  if (number > 10) {
			return new PlayingCard(number, suits_array[suits], faces[(number-1) % 10]);
		} else {
			return new PlayingCard(number,suits_array[suits], "");
		}
}

@Override

public String toString(){
    
    if (this.number > 10) {
        
	return this.face+ " " + this.suits;
		}
	return Integer.toString(this.number) + " " + this.suits;
    
}


@Override
public int compareTo(PlayingCard Playingcard) {

  if(PlayingCard.getGreater(this) > PlayingCard.getGreater(Playingcard)){
    return -1;
  }
  else if(PlayingCard.getGreater(this) < PlayingCard.getGreater(Playingcard)){
    return 1;
  }
  else {
    return 0;
  }
}

}