package cs3500.pyramidsolitaire.model.hw02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * BasicPyramidSolitaire contains a deck, a pyramid. It extends the pyramid solitaire model
 * interface and contains all methods from the model needed to play a pyramid solitaire game.
 */

public class BasicPyramidSolitaire implements PyramidSolitaireModel<Card> {

  protected List<Card> deck;
  protected List<List<Card>> pyramid;
  protected List<Card> drawCards;
  protected List<Card> discardCards;
  protected List<Card> stockPile;
  protected Gamestate gamestate;

  /**
   * Constructs a basic pyramid solitaire.
   *
   * @param deck         deck of cards
   * @param pyramid      pyramid of cards
   * @param drawCards    the cards that can be drawn
   * @param discardCards cards that are discarded
   * @param stockPile    cards that are left in the deck
   * @param gamestate    state of the game
   */

  public BasicPyramidSolitaire(List<Card> deck, List<List<Card>> pyramid,
      List<Card> drawCards, List<Card> discardCards, List<Card> stockPile, Gamestate gamestate) {
    this.deck = deck;
    this.pyramid = pyramid;
    this.drawCards = drawCards;
    this.discardCards = discardCards;
    this.stockPile = stockPile;
    this.gamestate = gamestate;
  }

  /**
   * This is an empty constructor.
   */
  public BasicPyramidSolitaire() {

    // This is an empty constructor used to start the game.
    this.deck = new ArrayList<Card>();
    this.pyramid = new ArrayList<List<Card>>();
    this.drawCards = new ArrayList<Card>();
    this.discardCards = new ArrayList<Card>();
    this.stockPile = new ArrayList<Card>();
    this.gamestate = Gamestate.NOT_STARTED;
  }

  /**
   * Return a valid and complete deck of cards for a game of Pyramid Solitaire. There is no
   * restriction imposed on the ordering of these cards in the deck. The validity of the deck is
   * determined by the rules of the specific game in the classes implementing this interface.
   *
   * @return the deck of cards as a list
   */
  @Override
  public List<Card> getDeck() {
    deck = new ArrayList<Card>();
    deck.add(0, new Card("A", '♣'));
    deck.add(1, new Card("2", '♣'));
    deck.add(2, new Card("3", '♣'));
    deck.add(3, new Card("4", '♣'));
    deck.add(4, new Card("5", '♣'));
    deck.add(5, new Card("6", '♣'));
    deck.add(6, new Card("7", '♣'));
    deck.add(7, new Card("8", '♣'));
    deck.add(8, new Card("9", '♣'));
    deck.add(9, new Card("10", '♣'));
    deck.add(10, new Card("J", '♣'));
    deck.add(11, new Card("Q", '♣'));
    deck.add(12, new Card("K", '♣'));
    deck.add(13, new Card("A", '♦'));
    deck.add(14, new Card("2", '♦'));
    deck.add(15, new Card("3", '♦'));
    deck.add(16, new Card("4", '♦'));
    deck.add(17, new Card("5", '♦'));
    deck.add(18, new Card("6", '♦'));
    deck.add(19, new Card("7", '♦'));
    deck.add(20, new Card("8", '♦'));
    deck.add(21, new Card("9", '♦'));
    deck.add(22, new Card("10", '♦'));
    deck.add(23, new Card("J", '♦'));
    deck.add(24, new Card("Q", '♦'));
    deck.add(25, new Card("K", '♦'));
    deck.add(26, new Card("A", '♥'));
    deck.add(27, new Card("2", '♥'));
    deck.add(28, new Card("3", '♥'));
    deck.add(29, new Card("4", '♥'));
    deck.add(30, new Card("5", '♥'));
    deck.add(31, new Card("6", '♥'));
    deck.add(32, new Card("7", '♥'));
    deck.add(33, new Card("8", '♥'));
    deck.add(34, new Card("9", '♥'));
    deck.add(35, new Card("10", '♥'));
    deck.add(36, new Card("J", '♥'));
    deck.add(37, new Card("Q", '♥'));
    deck.add(38, new Card("K", '♥'));
    deck.add(39, new Card("A", '♠'));
    deck.add(40, new Card("2", '♠'));
    deck.add(41, new Card("3", '♠'));
    deck.add(42, new Card("4", '♠'));
    deck.add(43, new Card("5", '♠'));
    deck.add(44, new Card("6", '♠'));
    deck.add(45, new Card("7", '♠'));
    deck.add(46, new Card("8", '♠'));
    deck.add(47, new Card("9", '♠'));
    deck.add(48, new Card("10", '♠'));
    deck.add(49, new Card("J", '♠'));
    deck.add(50, new Card("Q", '♠'));
    deck.add(51, new Card("K", '♠'));
    return this.deck;
  }

  /**
   * <p>Deal a new game of Pyramid Solitaire.
   * The cards to be used and their order are specified by the the given deck, unless the {@code
   * shuffle} parameter indicates the order should be ignored.</p>
   *
   * <p>This method first verifies that the deck is valid. It deals cards in rows
   * (left-to-right, top-to-bottom) into the characteristic pyramid shape with the specified number
   * of rows, followed by the specified number of draw cards. When {@code shuffle} is {@code false},
   * the 0th card in {@code deck} is used as the first card dealt.</p>
   *
   * <p>This method should have no other side effects, and should work for any valid arguments.</p>
   *
   * @param deck    the deck to be dealt
   * @param shuffle if {@code false}, use the order as given by {@code deck}, otherwise use a
   *                randomly shuffled order
   * @param numRows number of rows in the pyramid
   * @param numDraw number of draw cards available at a time
   * @throws IllegalArgumentException if the deck is null or invalid, the number of pyramid rows is
   *                                  non-positive, the number of draw cards available at a time is
   *                                  negative, or a full pyramid and draw pile cannot be dealt with
   *                                  the number of given cards in deck
   */

  @Override
  public void startGame(List<Card> deck, boolean shuffle, int numRows, int numDraw)
      throws IllegalArgumentException {
    BasicPyramidSolitaire empty = new BasicPyramidSolitaire();
    Set<Card> set = new HashSet<Card>(deck);
    List<Card> duplicateDeck = new ArrayList<Card>(deck);
    Collection<Card> validDeck = new ArrayList<Card>(empty.getDeck());

    if (deck == null) {
      throw new IllegalArgumentException("Deck cannot be null");
    }
    if (deck.size() != 52) {
      throw new IllegalArgumentException("Deck is not valid");
    }
    if (set.size() < deck.size()) {
      throw new IllegalArgumentException("Deck is not valid");
    }
    if (!(deck.containsAll(validDeck) && validDeck.containsAll(deck))) {
      throw new IllegalArgumentException("Deck is not valid");
    }
    if (numRows < 1) {
      throw new IllegalArgumentException("There must be a positive number of rows");
    }
    if (numDraw < 0) {
      throw new IllegalArgumentException("The number of draw cards cannot be negative");
    }
    int numCards = 0;
    numCards = (int) (0.5 * numRows * (numRows + 1));
    if (deck.size() < numCards + numDraw) {
      throw new IllegalArgumentException("Not enough cards for a proper game");
    }
    if (shuffle) {
      Collections.shuffle(duplicateDeck);
    }
    int j = 0;
    for (int i = 1; i <= numRows; i++) {
      List<Card> singleRow = duplicateDeck.subList(j, i * (i + 1) / 2);
      this.pyramid.add(singleRow);
      j = i * (i + 1) / 2;
    }
    for (int i = numCards; i < numCards + numDraw; i++) {
      this.drawCards.add(duplicateDeck.get(i));
    }
    for (int i = numCards + numDraw; i < 52; i++) {
      this.stockPile.add(duplicateDeck.get(i));
    }
    this.gamestate = Gamestate.STARTED;
  }

  /**
   * Remove two exposed cards on the pyramid, using the two specified card positions.
   *
   * @param row1  row of first card position, numbered from 0 from the top of the pyramid
   * @param card1 card of first card position, numbered from 0 from left
   * @param row2  row of second card position
   * @param card2 card of second card position
   * @throws IllegalArgumentException if the attempted remove is invalid
   * @throws IllegalStateException    if the game has not yet been started
   */
  @Override
  public void remove(int row1, int card1, int row2, int card2)
      throws IllegalArgumentException, IllegalStateException {
    if (this.gamestate.equals(Gamestate.NOT_STARTED)) {
      throw new IllegalStateException("Game has not been started yet");
    }
    /*
    if (row1 >= this.pyramid.size()) {
      throw new IllegalArgumentException("Attempted remove is invalid");
    }
    if (row2 >= this.pyramid.size()) {
      throw new IllegalArgumentException("Attempted remove is invalid");
    }
    if (card1 >= this.pyramid.get(row1).size()) {
      throw new IllegalArgumentException("Attempted remove is invalid");
    }
    if (card2 >= this.pyramid.get(row2).size()) {
      throw new IllegalArgumentException("Attempted remove is invalid");
    }
    Card c1 = pyramid.get(row1).get(card1);
    Card c2 = pyramid.get(row2).get(card2);
    if (c1.equals(c2)) {
      throw new IllegalArgumentException("Attempted remove is invalid");
    }
    if ((c1.getValue() + c2.getValue()) != 13) {
      throw new IllegalArgumentException("Attempted remove is invalid");
    }
    if (row1 != pyramid.size() - 1) {
      if (pyramid.get(row1 + 1).get(card1) != null &&
          pyramid.get(row1 + 1).get(card1 + 1) != null) {
        throw new IllegalArgumentException("Attempted remove is invalid");
      }
    }
    if (row2 != pyramid.size() - 1) {
      if (pyramid.get(row2 + 1).get(card2) != null &&
          pyramid.get(row2 + 1).get(card2 + 1) != null) {
        throw new IllegalArgumentException("Attempted remove is invalid");
      }
    }

     */
    if (!this.isRemove2Valid(row1, card1, row2, card2)) {
      throw new IllegalArgumentException("Attempted remove is invalid");
    }
    else {
      this.pyramid.get(row1).set(card1, null);
      this.pyramid.get(row2).set(card2, null);
    }
  }

  /**
   * Remove a single card on the pyramid, using the specified card position.
   *
   * @param row  row of the desired card position, numbered from 0 from the top of the pyramid
   * @param card card of the desired card position, numbered from 0 from left
   * @throws IllegalArgumentException if the attempted remove is invalid
   * @throws IllegalStateException    if the game has not yet been started
   */
  @Override
  public void remove(int row, int card) throws IllegalArgumentException, IllegalStateException {
    if (this.gamestate.equals(Gamestate.NOT_STARTED)) {
      throw new IllegalStateException("Game has not been started yet");
    }
    /*
    if (row >= this.pyramid.size()) {
      throw new IllegalArgumentException("Attempted remove is invalid");
    }
    if (card >= this.pyramid.get(row).size()) {
      throw new IllegalArgumentException("Attempted remove is invalid");
    }
    Card c1 = pyramid.get(row).get(card);
    if (c1.getValue() != 13) {
      throw new IllegalArgumentException("Attempted remove is invalid");
    }
    if (row != pyramid.size() - 1) {
      if (pyramid.get(row + 1).get(card) != null && pyramid.get(row + 1).get(card + 1) != null) {
        throw new IllegalArgumentException("Attempted remove is invalid");
      }
    }

     */
    if (!isRemove1Valid(row, card)) {
      throw new IllegalArgumentException("Attempted remove is invalid");
    }
    else {

      this.pyramid.get(row).set(card, null);
    }
  }

  /**
   * Remove two cards, one from the draw pile and one from the pyramid.
   *
   * @param drawIndex the card from the draw pile, numbered from 0 from left
   * @param row       row of the desired card position, numbered from 0 from the top of the pyramid
   * @param card      card of the desired card position, numbered from 0 from left
   * @throws IllegalArgumentException if the attempted remove is invalid
   * @throws IllegalStateException    if the game has not yet been started
   */
  @Override
  public void removeUsingDraw(int drawIndex, int row, int card)
      throws IllegalArgumentException, IllegalStateException {
    if (this.gamestate.equals(Gamestate.NOT_STARTED)) {
      throw new IllegalStateException("Game has not been started yet");
    }
    /*
    if (row >= this.pyramid.size()) {
      throw new IllegalArgumentException("Attempted remove is invalid");
    }
    if (card >= this.pyramid.get(row).size()) {
      throw new IllegalArgumentException("Attempted remove is invalid");
    }
    if (drawIndex >= this.drawCards.size()) {
      throw new IllegalArgumentException("Attempted remove is invalid");
    }
    Card c1 = pyramid.get(row).get(card);
    Card c2 = drawCards.get(drawIndex);
    if ((c1.getValue() + c2.getValue()) != 13) {
      throw new IllegalArgumentException("Attempted remove is invalid");
    }
    if (row != pyramid.size() - 1) {
      if (pyramid.get(row + 1).get(card) != null && pyramid.get(row + 1).get(card + 1) != null) {
        throw new IllegalArgumentException("Attempted remove is invalid");
      }
    }

     */
    if (!isRemoveWDValid(drawIndex, row, card)) {
      throw new IllegalArgumentException("Attempted remove is invalid");
    }
    else {
      this.pyramid.get(row).set(card, null);
      this.drawCards.remove(drawIndex);
    }
  }

  /**
   * Discards an individual card from the draw pile.
   *
   * @param drawIndex the card from the draw pile to be discarded
   * @throws IllegalArgumentException if the index is invalid or no card is present there.
   * @throws IllegalStateException    if the game has not yet been started
   */
  @Override
  public void discardDraw(int drawIndex) throws IllegalArgumentException, IllegalStateException {
    if (this.gamestate.equals(Gamestate.NOT_STARTED)) {
      throw new IllegalStateException("Game has not been started yet");
    }
    if (drawIndex >= drawCards.size()) {
      throw new IllegalArgumentException("Attempted discard is invalid");
    }
    this.discardCards.add(this.drawCards.get(drawIndex));
    this.drawCards.remove(drawIndex);
    int stockPileSize = this.stockPile.size();
    if (stockPileSize > 0) {
      Card k = this.stockPile.remove(0);
      this.drawCards.add(k);
    }
  }

  /**
   * Returns the number of rows originally in the pyramid, or -1 if the game hasn't been started.
   *
   * @return the height of the pyramid, or -1
   */
  @Override
  public int getNumRows() {
    if (this.gamestate.equals(Gamestate.NOT_STARTED)) {
      return -1;
    } else {
      return this.pyramid.size();
    }
  }

  /**
   * Returns the maximum number of visible cards in the draw pile, or -1 if the game hasn't been
   * started.
   *
   * @return the number of visible cards in the draw pile, or -1
   */
  @Override
  public int getNumDraw() {
    if (this.gamestate.equals(Gamestate.NOT_STARTED)) {
      return -1;
    } else {
      int numDraw = 0;
      for (int i = 0; i < this.drawCards.size(); i++) {
        numDraw += 1;
      }
      return numDraw;
    }
  }

  /**
   * Returns the width of the requested row, measured from the leftmost card to the rightmost card
   * (inclusive) as the game is initially dealt.
   *
   * @param row the desired row (0-indexed)
   * @return the number of spaces needed to deal out that row
   * @throws IllegalArgumentException if the row is invalid
   * @throws IllegalStateException    if the game has not yet been started
   */
  @Override
  public int getRowWidth(int row) throws IllegalArgumentException, IllegalStateException {
    if (this.gamestate.equals(Gamestate.NOT_STARTED)) {
      throw new IllegalStateException("Game has not been started yet");
    }
    if (row > this.pyramid.size() || row < 0) {
      throw new IllegalArgumentException("Row coordinate is invalid ");
    }
    return this.pyramid.get(row).size();
  }

  /**
   * Signal if the game is over or not. A game is said to be over if there are no possible removes
   * or discards.
   *
   * @return true if game is over, false otherwise
   * @throws IllegalStateException if the game hasn't been started yet
   */
  @Override
  public boolean isGameOver() throws IllegalStateException {
    if (this.gamestate.equals(Gamestate.NOT_STARTED)) {
      throw new IllegalStateException("Game has not been started yet");
    }
    for (int i = 0; i < this.pyramid.size(); i++) {
      for (int j = 0; j < this.pyramid.get(i).size(); j++) {
        if (this.isCardUncovered(i, j) && this.pyramid.get(i).get(j) != null) {
          if (this.pyramid.get(i).get(j).getValue() == 13) {
            return false;
          }
          for (int k = 0; k < this.pyramid.get(i).size(); k++) {
            if (this.isCardUncovered(i, k) && j != k && this.pyramid.get(i).get(k) != null) {
              if (this.pyramid.get(i).get(j).getValue() +
                  this.pyramid.get(i).get(k).getValue() == 13) {
                return false;
              }
            }
          }
          for (int l = 0; l < this.getDrawCards().size(); l++) {
            if (this.pyramid.get(i).get(j).getValue() +
                this.getDrawCards().get(l).getValue() == 13) {
              return false;
            }
          }
        }
      }
    }
    return this.getNumDraw() == 0;
  }

  /**
   * Return the current score, which is the sum of the values of the cards remaining in the
   * pyramid.
   *
   * @return the score
   * @throws IllegalStateException if the game hasn't been started yet
   */
  @Override
  public int getScore() throws IllegalStateException {
    if (this.gamestate.equals(Gamestate.NOT_STARTED)) {
      throw new IllegalStateException("Game has not been started yet");
    }
    int sum = 0;
    for (List<Card> row : this.pyramid) {
      for (Card card : row) {
        if (card == null) {
          sum += 0;
        } else {
          sum += card.getValue();
        }
      }
    }
    return sum;
  }

  /**
   * Returns the card at the specified coordinates.
   *
   * @param row  row of the desired card (0-indexed from the top)
   * @param card column of the desired card (0-indexed from the left)
   * @return the card at the given position, or <code>null</code> if no card is there
   * @throws IllegalArgumentException if the coordinates are invalid
   * @throws IllegalStateException    if the game hasn't been started yet
   */
  @Override
  public Card getCardAt(int row, int card)
      throws IllegalArgumentException, IllegalStateException {
    if (this.gamestate.equals(Gamestate.NOT_STARTED)) {
      throw new IllegalStateException("Game has not been started yet");
    }
    if (row > this.pyramid.size() || row < 0) {
      throw new IllegalArgumentException("Row coordinate is invalid ");
    }
    if (card > this.pyramid.get(row).size() || card < 0) {
      throw new IllegalArgumentException("Card coordinate is invalid ");
    }
    return this.pyramid.get(row).get(card);
  }

  /**
   * Returns the currently available draw cards. There should be at most {@link
   * PyramidSolitaireModel#getNumDraw} cards (the number specified when the game started) -- there
   * may be fewer, if cards have been removed.
   *
   * @return the ordered list of available draw cards
   * @throws IllegalStateException if the game hasn't been started yet
   */
  @Override
  public List<Card> getDrawCards() throws IllegalStateException {
    List<Card> getDrawCards = new ArrayList<Card>();
    if (this.gamestate.equals(Gamestate.NOT_STARTED)) {
      throw new IllegalStateException("Game has not been started yet");
    }
    for (int i = 0; i < drawCards.size(); i++) {
      getDrawCards.add(this.drawCards.get(i));
    }
    return getDrawCards;
  }

  /**
   * Determines if a card is uncovered.
   *
   * @param row  Card row
   * @param card Card index in row
   * @return whether a card is uncovered or not
   */
  protected boolean isCardUncovered(int row, int card) {
    if (row == this.pyramid.size() - 1) {
      return true;
    } else {
      return this.pyramid.get(row + 1).get(card) == null
          && this.pyramid.get(row + 1).get(card + 1) == null;
    }
  }

  /**
   * Determines if removing a single card is valid.
   *
   * @param row  Card row
   * @param card Card index in row
   * @return whether a remove is valid or not
   */
  protected boolean isRemove1Valid(int row, int card) {
    Card c1 = pyramid.get(row).get(card);
    if (this.gamestate.equals(Gamestate.NOT_STARTED)) {
      return false;
    } else if (row >= this.pyramid.size()) {
      return false;
    } else if (card >= this.pyramid.get(row).size()) {
      return false;
    } else if (!isCardUncovered(row, card)) {
      return false;
    } else {
      return c1.getValue() == 13;
    }
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
    } else {
      return c1.getValue() + c2.getValue() == 13;
    }
  }

  /**
   * Determines if removing a card with a draw card is valid.
   *
   * @param drawIndex index of draw
   * @param row card row
   * @param card card index in row
   * @return if a remove with draw is valid or not
   */
  protected boolean isRemoveWDValid(int drawIndex, int row, int card) {
    Card c1 = pyramid.get(row).get(card);
    Card c2 = drawCards.get(drawIndex);
    if (this.gamestate.equals(Gamestate.NOT_STARTED)) {
      return false;
    }
    else if (row >= this.pyramid.size()) {
      return false;
    }
    else if (card >= this.pyramid.get(row).size()) {
      return false;
    }
    else if (drawIndex >= this.drawCards.size()) {
      return false;
    }
    else if (!isCardUncovered(row, card)) {
      return false;
    }
    else {
      return c1.getValue() + c2.getValue() == 13;
    }
  }


}