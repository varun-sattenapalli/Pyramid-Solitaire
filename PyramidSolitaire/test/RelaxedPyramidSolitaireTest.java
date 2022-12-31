import static org.junit.Assert.assertEquals;

import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw04.RelaxedPyramidSolitaire;
import cs3500.pyramidsolitaire.view.PyramidSolitaireTextualView;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * Tests the RelaxedPyramidSolitaire class.
 */
public class RelaxedPyramidSolitaireTest {

  RelaxedPyramidSolitaire game = new RelaxedPyramidSolitaire();
  List<Card> deck = new ArrayList<Card>();
  PyramidSolitaireTextualView view = new PyramidSolitaireTextualView(game);

  @Test(expected = RuntimeException.class)
  public void testBadRemove() {
    game.startGame(game.getDeck(), false, 7, 15);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠", view.toString());
    game.remove(6, 5, 6, 3);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  .   K♦  .   2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠", view.toString());
    game.removeUsingDraw(1, 6, 0);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + ".   10♦ J♦  .   K♦  .   2♥\n"
        + "Draw: 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠", view.toString());
    game.remove(6, 2, 5, 2);
    assertEquals("Attempted remove is invalid.", view.toString());
    game.remove(7, 2, 5, 2);
    assertEquals("Attempted remove is invalid.", view.toString());
    game.remove(6, 2, 5, 10);
    assertEquals("Attempted remove is invalid.", view.toString());
  }


  @Test
  public void testMethodsWithToString() {
    game.startGame(game.getDeck(), false, 7, 15);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠", view.toString());
    game.remove(6, 5, 6, 3);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  .   K♦  .   2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠", view.toString());
    game.removeUsingDraw(1, 6, 0);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + ".   10♦ J♦  .   K♦  .   2♥\n"
        + "Draw: 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠", view.toString());
    game.remove(6, 1, 5, 0);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  .   4♦  5♦  6♦  7♦  8♦\n"
        + ".   .   J♦  .   K♦  .   2♥\n"
        + "Draw: 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠", view.toString());
  }

}