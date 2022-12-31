package cs3500.pyramidsolitaire.model.hw04;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.Gamestate;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Creates a pyramid solitaire game with multiple pyramids, extends a basic pyramid solitaire
 * and implements a pyramid solitaire model. Contains all methods in model needed to play a game.
 */
public class MultiPyramidSolitaire extends BasicPyramidSolitaire implements
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
  public MultiPyramidSolitaire(List<Card> deck, List<List<Card>> pyramid,
      List<Card> drawCards, List<Card> discardCards, List<Card> stockPile, Gamestate gamestate) {
    super(deck, pyramid, drawCards, discardCards, stockPile, gamestate);
  }

  /**
   * This is an empty constructor.
   */
  public MultiPyramidSolitaire() {
    super();
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
    deck =  new ArrayList<Card>();
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
    deck.add(52, new Card("A", '♣'));
    deck.add(53, new Card("2", '♣'));
    deck.add(54, new Card("3", '♣'));
    deck.add(55, new Card("4", '♣'));
    deck.add(56, new Card("5", '♣'));
    deck.add(57, new Card("6", '♣'));
    deck.add(58, new Card("7", '♣'));
    deck.add(59, new Card("8", '♣'));
    deck.add(60, new Card("9", '♣'));
    deck.add(61, new Card("10", '♣'));
    deck.add(62, new Card("J", '♣'));
    deck.add(63, new Card("Q", '♣'));
    deck.add(64, new Card("K", '♣'));
    deck.add(65, new Card("A", '♦'));
    deck.add(66, new Card("2", '♦'));
    deck.add(67, new Card("3", '♦'));
    deck.add(68, new Card("4", '♦'));
    deck.add(69, new Card("5", '♦'));
    deck.add(70, new Card("6", '♦'));
    deck.add(71, new Card("7", '♦'));
    deck.add(72, new Card("8", '♦'));
    deck.add(73, new Card("9", '♦'));
    deck.add(74, new Card("10", '♦'));
    deck.add(75, new Card("J", '♦'));
    deck.add(76, new Card("Q", '♦'));
    deck.add(77, new Card("K", '♦'));
    deck.add(78, new Card("A", '♥'));
    deck.add(79, new Card("2", '♥'));
    deck.add(80, new Card("3", '♥'));
    deck.add(81, new Card("4", '♥'));
    deck.add(82, new Card("5", '♥'));
    deck.add(83, new Card("6", '♥'));
    deck.add(84, new Card("7", '♥'));
    deck.add(85, new Card("8", '♥'));
    deck.add(86, new Card("9", '♥'));
    deck.add(87, new Card("10", '♥'));
    deck.add(88, new Card("J", '♥'));
    deck.add(89, new Card("Q", '♥'));
    deck.add(90, new Card("K", '♥'));
    deck.add(91, new Card("A", '♠'));
    deck.add(92, new Card("2", '♠'));
    deck.add(93, new Card("3", '♠'));
    deck.add(94, new Card("4", '♠'));
    deck.add(95, new Card("5", '♠'));
    deck.add(96, new Card("6", '♠'));
    deck.add(97, new Card("7", '♠'));
    deck.add(98, new Card("8", '♠'));
    deck.add(99, new Card("9", '♠'));
    deck.add(100, new Card("10", '♠'));
    deck.add(101, new Card("J", '♠'));
    deck.add(102, new Card("Q", '♠'));
    deck.add(103, new Card("K", '♠'));
    return deck;
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
    if (deck.size() != 104) {
      throw new IllegalArgumentException("Deck is not valid");
    }
    if (set.size() * 2 < deck.size()) {
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
    if (shuffle) {
      Collections.shuffle(duplicateDeck);
    }
    int j = 0;
    List<Card> firstRow = new ArrayList<Card>();
    int numFirstRow = 0;
    int numEmptyFirstRow = 0;
    int numEmptyRows = 0;
    int index = 0;
    if (numRows % 2 == 0) {
      numFirstRow = numRows + 1;
      numEmptyFirstRow = numRows - 2;
    } else if (numRows != 1) {
      numFirstRow = numRows;
      numEmptyFirstRow = numRows - 3;
    } else {
      numFirstRow = numRows;
    }
    numEmptyRows = numEmptyFirstRow / 2;
    firstRow.add(duplicateDeck.get(index));
    index += 1;
    addNullBetweenCards(firstRow, numEmptyFirstRow);
    firstRow.add(duplicateDeck.get(index));
    index += 1;
    addNullBetweenCards(firstRow, numEmptyFirstRow);
    firstRow.add(duplicateDeck.get(index));
    index += 1;
    this.pyramid.add(firstRow);
    for (int i = 1; i < numRows && !duplicateDeck.isEmpty(); i++) {
      List<Card> eachRowNotFirst = new ArrayList<Card>();
      if (i < numEmptyRows) {
        List<Card> cardsInRow = new ArrayList<Card>();
        cardsInRow = duplicateDeck.subList(index, index + i + 1);
        index += i + 1;
        eachRowNotFirst.addAll(cardsInRow);
        addNullBetweenCards(eachRowNotFirst, numEmptyFirstRow - (i * 2));
        cardsInRow = duplicateDeck.subList(index, index + i + 1);
        index += i + 1;
        eachRowNotFirst.addAll(cardsInRow);
        addNullBetweenCards(eachRowNotFirst, numEmptyFirstRow - (i * 2));
        cardsInRow = duplicateDeck.subList(index, index + i + 1);
        index += i + 1;
        eachRowNotFirst.addAll(cardsInRow);
      }
      else {
        eachRowNotFirst = duplicateDeck.subList(index, index + numFirstRow + i);
        index += numFirstRow + i;
      }
      this.pyramid.add(eachRowNotFirst);
    }
    int numCards = 0;
    for (List<Card> row : this.pyramid) {
      for (Card cards : row) {
        numCards += 1;
      }
    }
    if (deck.size() < numCards + numDraw) {
      throw new IllegalArgumentException("Not enough cards for a proper game");
    }
    for (int i = numCards; i < numCards + numDraw; i++) {
      this.drawCards.add(duplicateDeck.get(i));
    }
    for (int i = numCards + numDraw; i < 104; i++) {
      this.stockPile.add(duplicateDeck.get(i));
    }
    this.gamestate = Gamestate.STARTED;
  }

  /**
   * Adds null elements between cards in a row.
   *
   * @param row row of cards null elements are being added to
   * @param totEmptyCards represents total number of empty cards in row
   */
  private void addNullBetweenCards(List<Card> row, int totEmptyCards) {
    for (int i = 0; i < totEmptyCards / 2; i++) {
      row.add(null);
    }
  }
}