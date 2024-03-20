package idatt2003.data;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class DeckOfCards {
  private final Map<String, PlayingCard> deck;
  private final char suits[] = {'H', 'D', 'C', 'S'};
  Random random = new Random();
  int handSize = 5;

  public DeckOfCards() {
    deck = new HashMap<>();
    for (char suit : suits) {
      for (int value = 1; value <= 13; value++) {
        String cardId = suit + String.valueOf(value);
        deck.put(cardId, new PlayingCard(suit, value));
      }
    }
  }

  public void verifyValidDeckId(char suit, int face) {
    if (suit != 'H' && suit != 'D' && suit != 'C' && suit != 'S') {
      throw new IllegalArgumentException("Parameter suit must be one of H, D, C or S");
    }

    if (face < 1 || face > 13) {
      throw new IllegalArgumentException("Parameter face must be a number between 1 to 13");
    }
  }

  public void verifySize(int n) {
    if (n < 1 || n > 52) {
      throw new IllegalArgumentException("Parameter n must be a number between 1 to 52");
    }
  }

  public void verifyValidHand(List<PlayingCard> hand, int size) {
    if (hand.size() != size) {
      throw new IllegalArgumentException("Given hand must be a list of 5 cards");
    }
  }

  public PlayingCard getDeck(char suit, int value) {
    verifyValidDeckId(suit, value);
    String cardId = suit + String.valueOf(value);
    return deck.get(cardId);
  }

  public int size() {
    return deck.size();
  }

  public List<PlayingCard> dealHand(int n) {
    verifySize(n);

    List<PlayingCard> hand = random.ints(n, 0, size())
      .limit(n)
      .mapToObj(i -> {
        int index = random.nextInt(deck.size());
        return new ArrayList<>(deck.values()).get(index);
      })
      .collect(Collectors.toList());

    return hand;
  }

  public boolean hasFlush(List <PlayingCard> hand){
    verifyValidHand(hand, handSize);
    PlayingCard firstSuit = hand.get(0);
    return hand.stream().allMatch(atHand -> atHand.getSuit() == firstSuit.getSuit());
  }

  public int getSum(List <PlayingCard> hand){
    verifyValidHand(hand, handSize);
    return hand.stream().mapToInt(PlayingCard::getFace).sum();
  }

  public boolean hasQueenOfSpades(List <PlayingCard> hand){
    verifyValidHand(hand, handSize);
    return hand.stream().anyMatch(atHand -> atHand.getSuit() == 'S' && atHand.getFace() == 12);
  }

  public String getCardsOfHearts(List <PlayingCard> hand) {
    verifyValidHand(hand, handSize);
    return hand.stream().filter(atHand -> atHand.getSuit() == 'H')
            .map(PlayingCard::getAsString).collect(Collectors.joining(" "));
  }
}
