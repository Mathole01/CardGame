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
        assertEquals("C13", deck.getDeck('C', 13).getAsString());
        assertEquals("S11", deck.getDeck('S', 11).getAsString());
        assertEquals("H12", deck.getDeck('H', 12).getAsString());
      } catch (Exception e) {
        fail("An exception was thrown with the message: " + e.getMessage());
      }
    }


  }

  @Nested
  @DisplayName("Negative tests")
  class NegativeTests {

      @Test
      @DisplayName("getDeck throws IllegalArgumentException when given invalid suit.")
      void getDeckThrowsExceptionOnInvalidSuit() {
        try {
          DeckOfCards deck = new DeckOfCards();
          deck.getDeck('K',10);
          fail("An exception was not thrown");
        } catch (Exception e) {
          assertEquals(e.getMessage(), "Parameter suit must be one of H, D, C or S");
        }
      }

      @Test
      @DisplayName("getDeck throws IllegalArgumentException when given invalid face.")
      void getDeckThrowsExceptionOnInvalidFace() {
        try {
          DeckOfCards deck = new DeckOfCards();
          deck.getDeck('H',15);
          fail("An exception was not thrown");
        } catch (Exception e) {
          assertEquals(e.getMessage(), "Parameter face must be a number between 1 to 13");
        }
      }
  }
}
