// CLASS: DumbCpuPlayer
//
// Author: Dipesh Shah, 7882947
//
// REMARKS: This class defines a Dumb Cpu AI
//
//-----------------------------------------
public class DumbCpuPlayer extends Player {
    public DumbCpuPlayer() {
        super("Dumb Cpu");
    }

    @Override
    public void discardCards() {
        //generate a random number between 0 and the number of cards in hand
        for(int i = 0; i < Handable.HAND_SIZE; i++) {
          //generate a random number between 0 and 1
          double rand = Math.random();
          //if the random number is less than 0.5, discard the card
          if(rand < 0.5) {
              ((Card)(getPlayerHand().getCard(i))).setSelected(true);
          }
        }
        int random = (int) (Math.random() * Handable.HAND_SIZE);
        this.getPlayerHand().discard();

    }
}
