package cs3500.pyramidsolitaire.model.hw04;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.Gamestate;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import java.util.List;

/**
 * Creates a pyramid solitaire game with relaxed rules. This class extends a basic pyramid
 * solitaire and implements the PyramidSolitaireModel interface. This class acts as the model to
 * play a relaxed pyramid solitaire game.
 */
public class RelaxedPyramidSolitaire extends BasicPyramidSolitaire implements
    PyramidSolitaireModel<Card> {

  /**
   * Constructs a relaxed pyramid solitaire.
   *
   * @param deck         deck of cards
   * @param pyramid      pyramid of cards
   * @param drawCards    the cards that can be drawn
   * @param discardCards cards that are discarded
   * @param stockPile    cards that are left in the deck
   * @param gamestate    state of the game
   */
  public RelaxedPyramidSolitaire(List<Card> deck, List<List<Card>> pyramid,
      List<Card> drawCards, List<Card> discardCards, List<Card> stockPile, Gamestate gamestate) {
    super(deck, pyramid, drawCards, discardCards, stockPile, gamestate);
  }

  /**
   * This is an empty constructor.
   */
  public RelaxedPyramidSolitaire() {
    super();
  }

  /**
   * Checks if a card is uncovered using the relaxed rules.
   *
   * @param row1 row of first card
   * @param card1 column of first card
   * @param row2 row of second card
   * @param card2 column of second card
   * @return returns a boolean showing whether a card is uncovered using relaxed rules
   */
  private boolean isCardUncoveredRelaxed(int row1, int card1, int row2, int card2) {
    Card c1 = this.pyramid.get(row1).get(card1);
    Card c1covering1 = this.pyramid.get(row1 + 1).get(card1);
    Card c1covering2 = this.pyramid.get(row1 + 1).get(card1 + 1);
    Card c2 = this.pyramid.get(row2).get(card2);
    Card c2covering1 = this.pyramid.get(row2 + 1).get(card2);
    Card c2covering2 = this.pyramid.get(row2 + 1).get(card2 + 1);

    return (c1covering1 == null && c1.getValue() + c1covering2.getValue() == 13
        && c2.equals(c1covering2)) ||
        (c1covering2 == null && c1.getValue() + c1covering1.getValue() == 13
            && c2.equals(c1covering1)) ||
        (c2covering1 == null && c2.getValue() + c2covering2.getValue() == 13
            && c1.equals(c2covering2)) ||
        (c2covering2 == null && c2.getValue() + c2covering1.getValue() == 13
            && c1.equals(c2covering1));
  }

  /**
   * Determines if removing two cards is valid.
   *
   * @param row1  Card1 row
   * @param card1 Card1 index in row
   * @param row2  Card2 row
   * @param card2 Card2 index in row
   * @return whether a remove is valid or not
   */
  @Override
  protected boolean isRemove2Valid(int row1, int card1, int row2, int card2) {
    Card c1 = pyramid.get(row1).get(card1);
    Card c2 = pyramid.get(row2).get(card2);
    if (this.gamestate.equals(Gamestate.NOT_STARTED)) {
      return false;
    }
    if (row1 >= this.pyramid.size()) {
      return false;
    } else if (row2 >= this.pyramid.size()) {
      return false;
    } else if (card1 >= this.pyramid.get(row1).size()) {
      return false;
    } else if (card2 >= this.pyramid.get(row2).size()) {
      return false;
    } else if (c1.equals(c2)) {
      return false;
    } else if (!isCardUncovered(row1, card1)) {
      return false;
    } else if (!isCardUncovered(row2, card2)) {
      return false;
    } else if (isCardUncoveredRelaxed(row1, card1, row2, card2)) {
      return true;
    } else {
      return c1.getValue() + c2.getValue() == 13;
    }
  }
}