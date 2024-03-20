package idatt2003.controller;

import idatt2003.data.DeckOfCards;
import idatt2003.data.PlayingCard;


import java.util.List;

public class CenterController {
  private final DeckOfCards deck;
  List<PlayingCard> hand;
  public CenterController() {
    this.deck = new DeckOfCards();
  }
  public List<PlayingCard> handleDealButtonPressedGenerateNewHand() {
    hand = deck.dealHand(5);
    return hand;
  }

  public List<PlayingCard> getHand() {
    return hand;
  }

}
