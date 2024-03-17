package idatt2003.data;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class DeckOfCards {
  private final Map<String, PlayingCard> deck;
  private final char suits[] = {'H', 'D', 'C', 'S'};

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

  public PlayingCard getDeck(char suit, int value) {
    verifyValidDeckId(suit, value);
    String cardId = suit + String.valueOf(value);
    return deck.get(cardId);
  }

  public int size() {
    return deck.size();
  }
}
