/* Implementation of Strategy Pattern */

import java.util.ArrayList;
import java.util.Scanner;

public class BasicRule implements GameStrategy{
    int cnt;
    Deck deckObj = Deck.getObject();

    @Override
    public ArrayList<String> checkRule(ArrayList<String> deck, ArrayList<String> hand, int nextMove) {
        CardOperation cardoperation = new CardOperation();
        Scanner sc= new Scanner(System.in);
        System.out.println("Deck Size at Start");
        System.out.println(deck.size());
        if(deck.isEmpty()){
            cnt+=1;
        }
        if (nextMove == 1) {
            String suit_1 = hand.get(hand.size() - 4).substring(hand.get(hand.size() - 4).length() - 1);
            String suit_4 = hand.get(hand.size() - 1).substring(hand.get(hand.size() - 1).length() - 1);
//            String suit_4 = hand[hand.size()-1]->name()[hand[hand.size()-1]->name().size()-1];
            if (suit_1.equals(suit_4)) {
//                System.out.println(suit_1 + suit_4);
                cnt = 0;
                int numRemoveCards[] = {1, 2};
                int numRemoveCardsDeck[] = {0, 1};
                int numDrawCards = 2;

                Command drawCard = new DrawCard(deck, hand, numDrawCards);
                Command removeCardDeck = new RemoveCard(deck, numRemoveCardsDeck, false);
                Command removeCardHand = new RemoveCard(hand, numRemoveCards, true);

                cardoperation.setCommand(removeCardHand);
                hand = cardoperation.cardEvent();

                cardoperation.setCommand(drawCard);
                hand = cardoperation.cardEvent();
                return hand;

            }
            else{
                System.out.println("Take valid move.");
                return hand;
            }
        } else if (nextMove == 2) {
            String rank_1 = hand.get(hand.size() - 4).substring(0, hand.get(hand.size() - 4).length() - 1);
            String rank_4 = hand.get(hand.size() - 1).substring(0, hand.get(hand.size() - 1).length() - 1);
            if (rank_1.equals(rank_4)) {
                System.out.println(rank_1 + rank_4);
                cnt = 0;
                int numRemoveCards[] = {0, 3};  //{0, 1, 2, 3};
                int numDrawCards = 4;
                Command drawCard = new DrawCard(deck, hand, numDrawCards);
                Command removeCardHand = new RemoveCard(hand, numRemoveCards, true);

                cardoperation.setCommand(removeCardHand);
                hand = cardoperation.cardEvent();

                cardoperation.setCommand(drawCard);
                hand = cardoperation.cardEvent();

                return hand;
            }
            else{
                System.out.println("Take valid move.");
                return hand;
            }
        } else if(nextMove==9){
            int numDrawCards = 1;
            int numRemoveCardsDeck[] = {0, 0};

            Command drawCard = new DrawCard(deck, hand, numDrawCards);

            cardoperation.setCommand(drawCard);
            hand = cardoperation.cardEvent();
            return hand;
        }
        else{
            System.out.println("Take valid move.");
            return hand;
        }
    }
}
