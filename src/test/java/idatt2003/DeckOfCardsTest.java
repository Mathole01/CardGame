package idatt2003;

import idatt2003.data.DeckOfCards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeckOfCardsTest {

  @Nested
  @DisplayName("Positive tests")
  class PositiveTests {

    @Test
    @DisplayName("Constructor creates all cards.")
    void CreatesAllCards() {
      try {
        DeckOfCards deck = new DeckOfCards();
        assertEquals(52, deck.size());
      } catch (Exception e) {
        fail("An exception was thrown with the message: " + e.getMessage());
      }
    }

    @Test
    @DisplayName("getDeck returns the correct cards.")
    void getDeckReturnsCorrectCard() {
      try {
        DeckOfCards deck = new DeckOfCards();
        assertEquals("H2", deck.getDeck('H', 2).getAsString());
        assertEquals("D1", deck.getDeck('D', 1).getAsString());
      } catch (Exception e) {
        fail("An exception was thrown with the message: " + e.getMessage());
      }
    }
  }
}
