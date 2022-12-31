import static org.junit.Assert.assertEquals;
import cs3500.pyramidsolitaire.controller.PyramidSolitaireTextualController;
import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw04.MultiPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw04.RelaxedPyramidSolitaire;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * Tests for PyramidSolitaireTextualController class.
 */
public class PyramidSolitaireTextualControllerTest {

  BasicPyramidSolitaire game = new BasicPyramidSolitaire();
  RelaxedPyramidSolitaire game2 = new RelaxedPyramidSolitaire();
  MultiPyramidSolitaire game3 = new MultiPyramidSolitaire();
  List<Card> deck = new ArrayList<Card>();

  @Test(expected = IllegalArgumentException.class)
  public void testModelNull() {
    StringBuilder out = new StringBuilder();
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(out);
    controller.playGame(null, game.getDeck(), false, 7, 15);
    assertEquals("Model cannot be null", out.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDeckNull() {
    StringBuilder out = new StringBuilder();
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(out);
    controller.playGame(game, null, false, 7, 15);
    assertEquals("Deck cannot be null", out.toString());
  }

  @Test(expected = IllegalStateException.class)
  public void testGameCannotStart1() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm1 7 5");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(game, game.getDeck(), false, -1, 15);
    assertEquals("Game cannot be started", out.toString());
  }

  @Test(expected = IllegalStateException.class)
  public void testGameCannotStart2() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm1 7 5");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(game, game.getDeck(), false, 7, -1);
    assertEquals("Game cannot be started", out.toString());
  }

  @Test(expected = IllegalStateException.class)
  public void testGameCannotStart3() {
    List<Card> deck = new ArrayList<Card>();
    deck.add(0, new Card("A", '♣'));
    deck.add(1, new Card("2", '♣'));
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm1 7 5");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(game, deck, false, 7, 15);
    assertEquals("Game cannot be started", out.toString());
  }

  @Test(expected = IllegalStateException.class)
  public void testControllerCannotInteract1() {
    StringBuilder out = new StringBuilder();
    Reader in = null;
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(game, game.getDeck(), false, 7, 15);
    assertEquals("Controller cannot interact with player", out.toString());
  }

  @Test(expected = IllegalStateException.class)
  public void testControllerCannotInteract2() {
    StringBuilder out = null;
    Reader in = new StringReader("rm1 7 5");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(game, game.getDeck(), false, 7, 15);
    assertEquals("Controller cannot interact with player", out.toString());
  }

  @Test
  public void testCurrentGameState() {
    StringBuilder out = new StringBuilder();
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(out);
    controller.playGame(game, game.getDeck(), false, 7, 15);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠\n"
        + "Score: 185", out.toString());
  }

  @Test
  public void testRemoveOneCard() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm1 7 5");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(game, game.getDeck(), false, 7, 15);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠\n"
        + "Score: 185\n"
        + "            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  .   A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠\n"
        + "Score: 172", out.toString());
  }

  @Test
  public void testRemoveTwoCards() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm2 7 4 7 6");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(game, game.getDeck(), false, 7, 15);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠\n"
        + "Score: 185\n"
        + "            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  .   K♦  .   2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠\n"
        + "Score: 172", out.toString());
  }

  @Test
  public void testRemoveWithDraw() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rmwd 1 7 2");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(game, game.getDeck(), false, 7, 15);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠\n"
        + "Score: 185\n"
        + "            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  .   J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠\n"
        + "Score: 175", out.toString());
  }

  @Test
  public void testDiscardDraw() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("dd 1");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(game, game.getDeck(), false, 7, 15);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠\n"
        + "Score: 185\n"
        + "            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠, 5♠\n"
        + "Score: 185", out.toString());
  }

  @Test
  public void testConsecutiveRemoves() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm1 7 5 rm2 7 4 7 6");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(game, game.getDeck(), false, 7, 15);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠\n"
        + "Score: 185\n"
        + "            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  .   .   .   2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠\n"
        + "Score: 159", out.toString());
  }

  @Test
  public void testQuitq() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("q");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(game, game.getDeck(), false, 7, 15);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠\n"
        + "Score: 185\n"
        + "Game quit! \n"
        + "State of game when quit:\n"
        + "            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠\n"
        + "Score: 185", out.toString());
  }

  @Test
  public void testBadInputString() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm3 1 7");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(game, game.getDeck(), false, 7, 15);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠\n"
        + "Score: 185\n"
        + "This is an invalid input, reenter value.", out.toString());
  }

  @Test
  public void testBadInputRemove() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm3 p 7");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(game, game.getDeck(), false, 7, 15);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠\n"
        + "Score: 185\n"
        + "This is an invalid input, reenter value.", out.toString());
  }

  @Test
  public void testBadInputDiscard() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("dd h");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(game, game.getDeck(), false, 7, 15);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠\n"
        + "Score: 185\n"
        + "This is an invalid input, reenter value.", out.toString());
  }

  // Tests invalid moves in rm1
  @Test
  public void testInvalidMoveRM1_1() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm1 1 7");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(game, game.getDeck(), false, 7, 15);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠\n"
        + "Score: 185\n"
        + "Invalid move. Play again. Card does not exist.", out.toString());
  }

  // Tests invalid moves in rm1
  @Test
  public void testInvalidMoveRM1_2() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm1 8 7");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(game, game.getDeck(), false, 7, 15);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠\n"
        + "Score: 185\n"
        + "Invalid move. Play again. Card does not exist.", out.toString());
  }

  // Tests invalid moves in rm1
  @Test
  public void testInvalidMoveRM1_3() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm1 5 3");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(game, game.getDeck(), false, 7, 15);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠\n"
        + "Score: 185\n"
        + "Invalid move. Play again. Card is not uncovered.", out.toString());
  }

  // Tests invalid moves in rm1
  @Test
  public void testInvalidMoveRM1_4() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm1 7 2");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(game, game.getDeck(), false, 7, 15);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠\n"
        + "Score: 185\n"
        + "Invalid move. Play again. Attempted remove is impossible.", out.toString());
  }


  // Tests invalid moves in rm2
  @Test
  public void testInvalidMoveRM2_1() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm2 1 7 7 1");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(game, game.getDeck(), false, 7, 15);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠\n"
        + "Score: 185\n"
        + "Invalid move. Play again. Card does not exist.", out.toString());
  }

  // Tests invalid moves in rm2
  @Test
  public void testInvalidMoveRM2_2() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm2 7 1 8 7");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(game, game.getDeck(), false, 7, 15);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠\n"
        + "Score: 185\n"
        + "Invalid move. Play again. Card does not exist.", out.toString());
  }

  // Tests invalid moves in rm2
  @Test
  public void testInvalidMoveRM2_3() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm2 5 3 7 4");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(game, game.getDeck(), false, 7, 15);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠\n"
        + "Score: 185\n"
        + "Invalid move. Play again. Card is not uncovered.", out.toString());
  }

  // Tests invalid moves in rm2
  @Test
  public void testInvalidMoveRM2_4() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm2 7 4 5 4");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(game, game.getDeck(), false, 7, 15);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠\n"
        + "Score: 185\n"
        + "Invalid move. Play again. Card is not uncovered.", out.toString());
  }

  // Tests invalid moves in rm2
  @Test
  public void testInvalidMoveRM2_5() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rm2 7 2 7 1");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(game, game.getDeck(), false, 7, 15);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠\n"
        + "Score: 185\n"
        + "Invalid move. Play again. Attempted remove is impossible.", out.toString());
  }

  // Tests invalid moves in rmwd
  @Test
  public void testInvalidMoveRMWD_1() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rmwd 1 1 7");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(game, game.getDeck(), false, 7, 15);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠\n"
        + "Score: 185\n"
        + "Invalid move. Play again. Card does not exist.", out.toString());
  }

  // Tests invalid moves in rmwd
  @Test
  public void testInvalidMoveRMWD_2() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rmwd 1 8 7");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(game, game.getDeck(), false, 7, 15);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠\n"
        + "Score: 185\n"
        + "Invalid move. Play again. Card does not exist.", out.toString());
  }

  // Tests invalid moves in rmwd
  @Test
  public void testInvalidMoveRMWD_3() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rmwd 1 5 3");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(game, game.getDeck(), false, 7, 15);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠\n"
        + "Score: 185\n"
        + "Invalid move. Play again. Card is not uncovered.", out.toString());
  }

  // Tests invalid moves in rmwd
  @Test
  public void testInvalidMoveRMWD_4() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rmwd 1 7 3");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(game, game.getDeck(), false, 7, 15);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠\n"
        + "Score: 185\n"
        + "Invalid move. Play again. Attempted remove is impossible.", out.toString());
  }

  // Tests invalid moves in rmwd
  @Test
  public void testInvalidMoveRMWD_5() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("rmwd 16 7 3");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(game, game.getDeck(), false, 7, 15);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠\n"
        + "Score: 185\n"
        + "Invalid move. Play again. Draw card does not exist.", out.toString());
  }

  // Tests invalid moves in dd
  @Test
  public void testInvalidMoveDD_1() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("dd 16");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(game, game.getDeck(), false, 7, 15);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠\n"
        + "Score: 185\n"
        + "Invalid move. Play again. Draw card does not exist.", out.toString());
  }

  // Tests invalid moves in dd
  @Test
  public void testInvalidMoveDD_2() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("dd 0");
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(in, out);
    controller.playGame(game, game.getDeck(), false, 7, 15);
    assertEquals("            A♣\n"
        + "          2♣  3♣\n"
        + "        4♣  5♣  6♣\n"
        + "      7♣  8♣  9♣  10♣\n"
        + "    J♣  Q♣  K♣  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♥  2♥\n"
        + "Draw: 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥, A♠, 2♠, 3♠, 4♠\n"
        + "Score: 185\n"
        + "Invalid move. Play again. Draw card does not exist.", out.toString());
  }



}