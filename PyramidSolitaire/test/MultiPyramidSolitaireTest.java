import static org.junit.Assert.assertEquals;

import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw04.MultiPyramidSolitaire;
import cs3500.pyramidsolitaire.view.PyramidSolitaireTextualView;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * Tests the MultiPyramidSolitaire class.
 */
public class MultiPyramidSolitaireTest {

  MultiPyramidSolitaire game = new MultiPyramidSolitaire();
  List<Card> deck = new ArrayList<Card>();
  PyramidSolitaireTextualView view = new PyramidSolitaireTextualView(game);

  @Test
  public void testGetDeck() {
    assertEquals(104, game.getDeck().size());
  }

  @Test(expected = RuntimeException.class)
  public void testStartGame() {
    List<Card> badDeck = new ArrayList<Card>();
    badDeck.add(0, new Card("A", '♣'));
    badDeck.add(1, new Card("A", '♣'));
    game.startGame(badDeck, false, 7, 3);
    assertEquals("Deck is not valid", game.toString());
    game.startGame(game.getDeck(), false, 100, 4);
    assertEquals("Not enough cards for a proper game.", game.toString());
    game.startGame(game.getDeck(), false, 7, 104);
    assertEquals("Not enough cards for a proper game.", game.toString());
  }


  @Test
  public void testMethodsWithToString() {
    game.startGame(game.getDeck(), false, 7, 15);
    assertEquals("            A♣  .   .   2♣  .   .   3♣\n"
        + "          4♣  5♣  .   6♣  7♣  .   8♣  9♣\n"
        + "        10♣ J♣  Q♣  K♣  A♦  2♦  3♦  4♦  5♦\n"
        + "      6♦  7♦  8♦  9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "    3♥  4♥  5♥  6♥  7♥  8♥  9♥  10♥ J♥  Q♥  K♥\n"
        + "  A♠  2♠  3♠  4♠  5♠  6♠  7♠  8♠  9♠  10♠ J♠  Q♠\n"
        + "K♠  A♣  2♣  3♣  4♣  5♣  6♣  7♣  8♣  9♣  10♣ J♣  Q♣\n"
        + "Draw: 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦, A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥", view.toString());
    game.remove(6, 3, 6, 10);
    assertEquals("            A♣  .   .   2♣  .   .   3♣\n"
        + "          4♣  5♣  .   6♣  7♣  .   8♣  9♣\n"
        + "        10♣ J♣  Q♣  K♣  A♦  2♦  3♦  4♦  5♦\n"
        + "      6♦  7♦  8♦  9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "    3♥  4♥  5♥  6♥  7♥  8♥  9♥  10♥ J♥  Q♥  K♥\n"
        + "  A♠  2♠  3♠  4♠  5♠  6♠  7♠  8♠  9♠  10♠ J♠  Q♠\n"
        + "K♠  A♣  2♣  .   4♣  5♣  6♣  7♣  8♣  9♣  .   J♣  Q♣\n"
        + "Draw: 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦, A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥", view.toString());
    game.removeUsingDraw(0 , 6, 7);
    assertEquals("            A♣  .   .   2♣  .   .   3♣\n"
        + "          4♣  5♣  .   6♣  7♣  .   8♣  9♣\n"
        + "        10♣ J♣  Q♣  K♣  A♦  2♦  3♦  4♦  5♦\n"
        + "      6♦  7♦  8♦  9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "    3♥  4♥  5♥  6♥  7♥  8♥  9♥  10♥ J♥  Q♥  K♥\n"
        + "  A♠  2♠  3♠  4♠  5♠  6♠  7♠  8♠  9♠  10♠ J♠  Q♠\n"
        + "K♠  A♣  2♣  .   4♣  5♣  6♣  .   8♣  9♣  .   J♣  Q♣\n"
        + "Draw: 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦, A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥", view.toString());
  }

}