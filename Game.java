import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        while (true) {
            GameRules rules = GameRules.getObject(); // Use of Singleton Pattern
            rules.displayGameRules();
            System.out.println();
            Scanner sc = new Scanner(System.in);
            int gameRule = sc.nextInt();

            Deck deck = Deck.getObject(); // Use of Singleton Pattern
            ArrayList<String> cardDeck = new ArrayList<>();
            ArrayList<String> hand = new ArrayList<>();
            ArrayList<String> new_hand = new ArrayList<>();
            cardDeck = deck.createDeck();
            cardDeck = deck.shuffleDeck(cardDeck);
//            deck.printDeck(cardDeck);

            CardOperation cardoperation = new CardOperation(); // Use of Command Pattern
            Command handCommand = new Hand(cardDeck, hand);
            cardoperation.setCommand(handCommand);
            hand = cardoperation.cardEvent();

            int numRemoveCardsDeck[] = {0, 3}; // Use of Command Pattern
            Command removeCardDeck = new RemoveCard(cardDeck, numRemoveCardsDeck, false);
            cardoperation.setCommand(removeCardDeck);
            cardDeck = cardoperation.cardEvent();
            System.out.println();
//            deck.printDeck(cardDeck);
//            System.out.println(cardDeck.size());

            Hand handOperation = new Hand(cardDeck, hand); // Use of Command Pattern
            System.out.print("\nYour Hand: ");
            handOperation.printHand(hand);
            int cnt = 0;
            while (true) {
                if (cardDeck.isEmpty()) {
                    cnt += 1;
                }
                if (gameRule == 1) {
                    System.out.println();
                    rules.displayBasicMoves();
                    int nextMove = sc.nextInt();
                    StrategyController strategy = new StrategyController(new BasicRule()); // Use of Strategy Pattern
                    new_hand = strategy.executeStrategy(cardDeck, hand, nextMove);
                    hand = new_hand;
                    System.out.print("\nYour Hand: ");
                    handOperation.printHand(hand);
                    if (!cardDeck.isEmpty()) {
                        if (nextMove == 1) {
                            int numRemoveCardsDeckRule[] = {0, 1};
                            Command removeCardDeckRule = new RemoveCard(cardDeck, numRemoveCardsDeckRule, false); // Use of Command Pattern
                            cardoperation.setCommand(removeCardDeckRule);
                            cardDeck = cardoperation.cardEvent();
                        } else if (nextMove == 2) {
                            int numRemoveCardsDeckRule[] = {0, 3};
                            Command removeCardDeckRule = new RemoveCard(cardDeck, numRemoveCardsDeckRule, false); // Use of Command Pattern
                            cardoperation.setCommand(removeCardDeckRule);
                            cardDeck = cardoperation.cardEvent();
                        } else if (nextMove == 9) {
                            int numRemoveCardsDeckRule[] = {0, 0};
                            Command removeCardDeckRule = new RemoveCard(cardDeck, numRemoveCardsDeckRule, false); // Use of Command Pattern
                            cardoperation.setCommand(removeCardDeckRule);
                            cardDeck = cardoperation.cardEvent();
                        }
                    }
//                }
                } else if (gameRule == 2) {
                    System.out.println();
                    rules.displayIntermediateMoves();
                    int nextMove = sc.nextInt();
                    StrategyController strategy = new StrategyController(new IntermediateRule()); // Use of Strategy Pattern
                    new_hand = strategy.executeStrategy(cardDeck, hand, nextMove);
                    hand = new_hand;
                    System.out.print("\nYour Hand: ");
                    handOperation.printHand(hand);
                    if (!cardDeck.isEmpty()) {
                        if (nextMove == 1) {
                            int numRemoveCardsDeckRule[] = {0, 1};
                            Command removeCardDeckRule = new RemoveCard(cardDeck, numRemoveCardsDeckRule, false); // Use of Command Pattern
                            cardoperation.setCommand(removeCardDeckRule);
                            cardDeck = cardoperation.cardEvent();
                        } else if (nextMove == 2) {
                            int numRemoveCardsDeckRule[] = {0, 3};
                            Command removeCardDeckRule = new RemoveCard(cardDeck, numRemoveCardsDeckRule, false); // Use of Command Pattern
                            cardoperation.setCommand(removeCardDeckRule);
                            cardDeck = cardoperation.cardEvent();
                        } else if (nextMove == 3) {
                            int numRemoveCardsDeckRule[] = {0, 1};
                            Command removeCardDeckRule = new RemoveCard(cardDeck, numRemoveCardsDeckRule, false); // Use of Command Pattern
                            cardoperation.setCommand(removeCardDeckRule);
                            cardDeck = cardoperation.cardEvent();
                        } else if (nextMove == 9) {
                            int numRemoveCardsDeckRule[] = {0, 0};
                            Command removeCardDeckRule = new RemoveCard(cardDeck, numRemoveCardsDeckRule, false); // Use of Command Pattern
                            cardoperation.setCommand(removeCardDeckRule);
                            cardDeck = cardoperation.cardEvent();
                        }
                    }
                } else if (gameRule == 3) {
                    System.out.println();
                    rules.displayHouseMoves();
                    int nextMove = sc.nextInt();
                    StrategyController strategy = new StrategyController(new HouseRule()); // Use of Strategy Pattern
                    new_hand = strategy.executeStrategy(cardDeck, hand, nextMove);
                    hand = new_hand;
                    System.out.print("\nYour Hand: ");
                    handOperation.printHand(hand);
                    if (!cardDeck.isEmpty()) {
                        if (nextMove == 1) {
                            int numRemoveCardsDeckRule[] = {0, 1};
                            Command removeCardDeckRule = new RemoveCard(cardDeck, numRemoveCardsDeckRule, false); // Use of Command Pattern
                            cardoperation.setCommand(removeCardDeckRule);
                            cardDeck = cardoperation.cardEvent();
                        } else if (nextMove == 2) {
                            int numRemoveCardsDeckRule[] = {0, 3};
                            Command removeCardDeckRule = new RemoveCard(cardDeck, numRemoveCardsDeckRule, false); // Use of Command Pattern
                            cardoperation.setCommand(removeCardDeckRule);
                            cardDeck = cardoperation.cardEvent();
                        } else if (nextMove == 3) {
                            int numRemoveCardsDeckRule[] = {0, 1};
                            Command removeCardDeckRule = new RemoveCard(cardDeck, numRemoveCardsDeckRule, false); // Use of Command Pattern
                            cardoperation.setCommand(removeCardDeckRule);
                            cardDeck = cardoperation.cardEvent();
                        } else if (nextMove == 4) {
                            int numRemoveCardsDeckRule[] = {0, 1, 2};
                            Command removeCardDeckRule = new RemoveCard(cardDeck, numRemoveCardsDeckRule, false); // Use of Command Pattern
                            cardoperation.setCommand(removeCardDeckRule);
                            cardDeck = cardoperation.cardEvent();
                        } else if (nextMove == 5) {
                            int numRemoveCardsDeckRule[] = {0, 1, 2};
                            Command removeCardDeckRule = new RemoveCard(cardDeck, numRemoveCardsDeckRule, false); // Use of Command Pattern
                            cardoperation.setCommand(removeCardDeckRule);
                            cardDeck = cardoperation.cardEvent();
                        } else if (nextMove == 9) {
                            int numRemoveCardsDeckRule[] = {0, 0};
                            Command removeCardDeckRule = new RemoveCard(cardDeck, numRemoveCardsDeckRule, false); // Use of Command Pattern
                            cardoperation.setCommand(removeCardDeckRule);
                            cardDeck = cardoperation.cardEvent();
                        }
                    }
                }

                CheckWin checkWin = new CheckWin(); // Use of Observer Pattern
                ResultObserver resultObserver = new ResultObserver();
                checkWin.attach(resultObserver);
                checkWin.setState(cardDeck, hand, cnt);
                boolean flag = checkWin.getState();
                if (!flag) {
                    break;
                }
//            else {
//                System.out.println("Select Valid Rules");
//            }
            }

        }
    }
}
