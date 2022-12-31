import static org.junit.Assert.assertEquals;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.view.PyramidSolitaireTextualView;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * Class to test methods in BasicPyramidSolitaire.
 */
public class BasicPyramidSolitaireTest {

  BasicPyramidSolitaire game = new BasicPyramidSolitaire();
  List<Card> deck = new ArrayList<Card>();
  PyramidSolitaireTextualView view = new PyramidSolitaireTextualView(game);


  @Test
  public void testGetDeck() {
    assertEquals(52, game.getDeck().size());
  }

  @Test(expected = RuntimeException.class)
  public void testNullDeck() {
    deck = null;
    game.startGame(deck, false, -1, -1);
    assertEquals("Game has not been started yet",
        game.getNumRows());
    assertEquals("Game has not been started yet",
        game.getNumDraw());
    assertEquals("Game has not been started yet",
        game.getRowWidth(4));
    assertEquals("Game has not been started yet",
        game.isGameOver());
    assertEquals("Game has not been started yet",
        game.getScore());
    assertEquals("Game has not been started yet",
        game.getNumDraw());
    assertEquals("Game has not been started yet",
        game.getCardAt(1,1));
    assertEquals("Game has not been started yet",
        game.getDrawCards());
  }

  @Test(expected = RuntimeException.class)
  public void testDuplicateDeck() {
    deck.add(0, new Card("A", '♣'));
    deck.add(1, new Card("A", '♣'));
    game.startGame(deck, false, 1, 0);
    assertEquals(" Deck is not valid", game.toString());
  }

  @Test(expected = RuntimeException.class)
  public void testIncorrectDeck() {
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
    deck.add(51, new Card("L", '♠'));
    game.startGame(deck, false, 7, 15);
    assertEquals(" Deck is not valid", view.toString());
  }

  @Test
  public void testStartGameToString() {
    game.startGame(game.getDeck(), false, 7, 15);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠", view.toString());
  }

  @Test
  public void testRemove() {
    game.startGame(game.getDeck(), false, 7, 15);
    game.remove(6,4);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  .   A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠", view.toString());
    game.remove(6,3,6,5);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  .   .   .   2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠", view.toString());
  }




}