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
    PlayingCard firstSuit = hand.get(0);
    return hand.stream().allMatch(atHand -> atHand.getSuit() == firstSuit.getSuit());
  }
}
