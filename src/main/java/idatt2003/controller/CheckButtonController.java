package idatt2003.controller;

import idatt2003.data.DeckOfCards;
import idatt2003.data.PlayingCard;

import java.util.List;

public class CheckButtonController {
  private DeckOfCards deck;
  public CheckButtonController() {
    this.deck = new DeckOfCards();
  }

  public boolean handleCheckHandButtonPressedFlush(List<PlayingCard> hand) {
    if (deck.hasFlush(hand)) {
      return true;
    } else {
      return false;
    }
  }

  public int handleCheckHandButtonPressedGetSum(List<PlayingCard> hand) {
    return deck.getSum(hand);
  }

  public boolean handleCheckHandButtonPressedQueenOfSpades(List<PlayingCard> hand) {
    return deck.hasQueenOfSpades(hand);
  }

  public String handleCheckHandButtonGetHearts(List<PlayingCard> hand) {
    return deck.getCardsOfHearts(hand);
  }
}
