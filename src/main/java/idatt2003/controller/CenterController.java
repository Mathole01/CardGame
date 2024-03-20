package idatt2003.controller;

import idatt2003.data.DeckOfCards;
import idatt2003.data.PlayingCard;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

import java.util.List;

public class CenterController {
  private DeckOfCards deck;
  public CenterController() {
    this.deck = new DeckOfCards();
  }
  public List<PlayingCard> handleDealButtonPressed() {
    return deck.dealHand(5);
  }
}
