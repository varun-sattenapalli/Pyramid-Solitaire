package cs3500.pyramidsolitaire;

import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw04.PyramidSolitaireCreator;
import cs3500.pyramidsolitaire.model.hw04.PyramidSolitaireCreator.GameType;

/**
 * Class to play a pyramid solitaire game.
 */
public final class PyramidSolitaire {

  /**
   * Creates a game of pyramid solitaire given input args.
   *
   * @param args takes in a string of arguments needed for a game
   */
  public static void main(String[] args) {
    int numRows = 0;
    int numDraw = 0;
    GameType type = null;
    PyramidSolitaireCreator creator = new PyramidSolitaireCreator();
    switch (args[0]) {
      case "basic":
        type = GameType.BASIC;
        break;
      case "relaxed":
        type = GameType.RELAXED;
        break;
      case "multipyramid":
        type = GameType.MULTIPYRAMID;
        break;
      default:
        System.out.println("Not a valid type of pyramid solitaire, invalid input.");
        System.exit(1);
    }
    if (args.length == 3) {
      numRows = Integer.parseInt(args[1]);
      numDraw = Integer.parseInt(args[2]);
    }
    else if (args.length == 1) {
      numRows = 7;
      numDraw = 3;
    }
    else {
      System.out.println("Not a valid type of pyramid solitaire, invalid input.");
      System.exit(1);
    }
    PyramidSolitaireModel<Card> game = creator.create(type);
    game.startGame(game.getDeck(), true, numRows, numDraw);
  }
}
