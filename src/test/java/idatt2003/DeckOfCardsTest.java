package idatt2003;

import idatt2003.data.DeckOfCards;
import idatt2003.data.PlayingCard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    @DisplayName("dealHand method returns the correct amount of cards.")
    void dealHandMethodReturnsCorrectAmountOfCards() {
      try {
        DeckOfCards deck = new DeckOfCards();
        assertEquals(5, deck.dealHand(5).size());
      } catch (Exception e) {
        fail("An exception was thrown with the message: " + e.getMessage());
      }
    }

    @Test
    @DisplayName("hasFlush method returns true when given a flush.")
    void hasFlushMethodReturnsTrueOnFlush() {
      try {
        DeckOfCards deck = new DeckOfCards();
        List<PlayingCard> hand = List.of(
          new PlayingCard('H', 2),
          new PlayingCard('H', 3),
          new PlayingCard('H', 4),
          new PlayingCard('H', 5),
          new PlayingCard('H', 6)
        );
        assertTrue(deck.hasFlush(hand));
      } catch (Exception e) {
        fail("An exception was thrown with the message: " + e.getMessage());
      }
    }

    @Test
    @DisplayName("hasFlush method returns false when not given a flush.")
    void hasFlushMethodReturnsFalseOnNoFlush() {
      try {
        DeckOfCards deck = new DeckOfCards();
        List<PlayingCard> hand = List.of(
                new PlayingCard('S', 2),
                new PlayingCard('H', 3),
                new PlayingCard('H', 4),
                new PlayingCard('H', 5),
                new PlayingCard('H', 6)
        );
        assertFalse(deck.hasFlush(hand));
      } catch (Exception e) {
        fail("An exception was thrown with the message: " + e.getMessage());
      }
    }

    @Test
    @DisplayName("getSum method returns the correct sum.")
    void getSumMethodReturnsCorrectSum() {
      try {
        DeckOfCards deck = new DeckOfCards();
        List<PlayingCard> hand = List.of(
                new PlayingCard('H', 2),
                new PlayingCard('H', 3),
                new PlayingCard('H', 4),
                new PlayingCard('H', 5),
                new PlayingCard('H', 6)
        );
        assertEquals(20, deck.getSum(hand));
      } catch (Exception e) {
        fail("An exception was thrown with the message: " + e.getMessage());
      }
    }

    @Test
    @DisplayName("hasQueenOfSpades method returns true when given a queen of spades.")
    void hasQueenOfSpadesMethodReturnsTrueOnQueenOfSpades() {
      try {
        DeckOfCards deck = new DeckOfCards();
        List<PlayingCard> hand = List.of(
                new PlayingCard('H', 2),
                new PlayingCard('H', 3),
                new PlayingCard('H', 4),
                new PlayingCard('H', 5),
                new PlayingCard('S', 12)
        );
        assertTrue(deck.hasQueenOfSpades(hand));
      } catch (Exception e) {
        fail("An exception was thrown with the message: " + e.getMessage());
      }
    }

    @Test
    @DisplayName("hasQueenOfSpades method returns false when not given a queen of spades.")
    void hasQueenOfSpadesMethodReturnsFalseOnNoQueenOfSpades() {
      try {
        DeckOfCards deck = new DeckOfCards();
        List<PlayingCard> hand = List.of(
                new PlayingCard('H', 2),
                new PlayingCard('H', 3),
                new PlayingCard('H', 4),
                new PlayingCard('H', 5),
                new PlayingCard('H', 6)
        );
        assertFalse(deck.hasQueenOfSpades(hand));
      } catch (Exception e) {
        fail("An exception was thrown with the message: " + e.getMessage());
      }
    }

    @Test
    @DisplayName("getCardsOfHearts method returns the correct cards.")
    void getCardsOfHeartsMethodReturnsCorrectCards() {
      try {
        DeckOfCards deck = new DeckOfCards();
        List<PlayingCard> hand = List.of(
                new PlayingCard('H', 2),
                new PlayingCard('H', 3),
                new PlayingCard('H', 4),
                new PlayingCard('H', 5),
                new PlayingCard('H', 6)
        );
        assertEquals("H2 H3 H4 H5 H6", deck.getCardsOfHearts(hand));
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

      @Test
      @DisplayName("verifySize throws IllegalArgumentException when given invalid size.")
      void verifySizeThrowsExceptionOnInvalidSize() {
        try {
          DeckOfCards deck = new DeckOfCards();
          deck.verifySize(53);
          fail("An exception was not thrown");
        } catch (Exception e) {
          assertEquals(e.getMessage(), "Parameter n must be a number between 1 to 52");
        }
      }

      @Test
      @DisplayName("dealHand throws IllegalArgumentException when given invalid size.")
      void dealHandThrowsExceptionOnInvalidSize() {
        try {
          DeckOfCards deck = new DeckOfCards();
          deck.dealHand(53);
          fail("An exception was not thrown");
        } catch (Exception e) {
          assertEquals(e.getMessage(), "Parameter n must be a number between 1 to 52");
        }
      }

      @Test
      @DisplayName("hasFlush throws IllegalArgumentException when given invalid hand.")
      void hasFlushThrowsExceptionOnInvalidHand() {
        try {
          DeckOfCards deck = new DeckOfCards();
          List<PlayingCard> hand = List.of(
                  new PlayingCard('H', 2),
                  new PlayingCard('H', 3),
                  new PlayingCard('H', 4),
                  new PlayingCard('H', 5)
          );
          deck.hasFlush(hand);
          fail("An exception was not thrown");
        } catch (Exception e) {
          assertEquals(e.getMessage(), "Given hand must be a list of 5 cards");
        }
      }

      @Test
      @DisplayName("getSum throws IllegalArgumentException when given invalid hand.")
      void getSumThrowsExceptionOnInvalidHand() {
        try {
          DeckOfCards deck = new DeckOfCards();
          List<PlayingCard> hand = List.of(
                  new PlayingCard('H', 2),
                  new PlayingCard('H', 3),
                  new PlayingCard('H', 4),
                  new PlayingCard('H', 5)
          );
          deck.getSum(hand);
          fail("An exception was not thrown");
        } catch (Exception e) {
          assertEquals(e.getMessage(), "Given hand must be a list of 5 cards");
        }
      }

      @Test
      @DisplayName("hasQueenOfSpades throws IllegalArgumentException when given invalid hand.")
      void hasQueenOfSpadesThrowsExceptionOnInvalidHand() {
        try {
          DeckOfCards deck = new DeckOfCards();
          List<PlayingCard> hand = List.of(
                  new PlayingCard('H', 2),
                  new PlayingCard('H', 3),
                  new PlayingCard('H', 4),
                  new PlayingCard('H', 5)
          );
          deck.hasQueenOfSpades(hand);
          fail("An exception was not thrown");
        } catch (Exception e) {
          assertEquals(e.getMessage(), "Given hand must be a list of 5 cards");
        }
      }

      @Test
      @DisplayName("getCardsOfHearts throws IllegalArgumentException when given invalid hand.")
      void getCardsOfHeartsThrowsExceptionOnInvalidHand() {
        try {
          DeckOfCards deck = new DeckOfCards();
          List<PlayingCard> hand = List.of(
                  new PlayingCard('H', 2),
                  new PlayingCard('H', 3),
                  new PlayingCard('H', 4),
                  new PlayingCard('H', 5)
          );
          deck.getCardsOfHearts(hand);
          fail("An exception was not thrown");
        } catch (Exception e) {
          assertEquals(e.getMessage(), "Given hand must be a list of 5 cards");
        }
      }

  }
}
