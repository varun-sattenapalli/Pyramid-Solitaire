package cs3500.pyramidsolitaire.model.hw04;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;

/**
 * Creates an instance of a pyramid solitaire.
 */
public class PyramidSolitaireCreator {

  /**
   * Three types of games - basic, relaxed, multi.
   */
  public enum GameType {
    BASIC, RELAXED, MULTIPYRAMID
  }

  /**
   * Creates a pyramid solitaire model given a specific game type.
   *
   * @param type the type of game
   * @return returns a pyramid solitaire model
   */
  public static PyramidSolitaireModel<Card> create(GameType type) {
    if (type == GameType.BASIC) {
      return new BasicPyramidSolitaire();
    }
    if (type == GameType.RELAXED) {
      return new RelaxedPyramidSolitaire();
    }
    if (type == GameType.MULTIPYRAMID) {
      return new MultiPyramidSolitaire();
    }
    return null;
  }
}
