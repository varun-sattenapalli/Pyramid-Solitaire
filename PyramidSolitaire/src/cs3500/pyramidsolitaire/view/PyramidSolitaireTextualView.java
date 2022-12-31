package cs3500.pyramidsolitaire.view;

import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import java.io.IOException;

/**
 * View of pyramid solitaire game. Implements the PyramidSolitaireView interface and is used to
 * represent the view portion of the model-view-controller implementation of a pyramid solitaire
 * game.
 */
public class PyramidSolitaireTextualView implements PyramidSolitaireView {

  private final PyramidSolitaireModel<?> model;
  final Appendable out;

  /**
   * Constructor for view of solitaire game.
   *
   * @param model model of the Pyramid Solitaire game.
   */
  public PyramidSolitaireTextualView(PyramidSolitaireModel<?> model) {
    this.model = model;
    this.out = null;
  }

  /**
   * Constructor for view of solitaire game with a solitaire model and appendable.
   *
   * @param model model of the Pyramid Solitaire game.
   * @param out appendable which is the output.
   */
  public PyramidSolitaireTextualView(PyramidSolitaireModel<?> model, Appendable out) {
    this.model = model;
    this.out = out;
  }

  /**
   * ToString method needed for visualization.
   *
   * @return
   */
  @Override
  public String toString() {
    String finalRow = "";
    if (model.getNumRows() == -1) {
      return "";
    }
    else if (model.isGameOver() && model.getScore() == 0) {
      return "You win!";
    }
    else if (model.isGameOver()) {
      return "Game over: Score: ##";
    }
    else {
      for (int i = 0; i < model.getNumRows(); i ++) {
        String eachRow = "";
        String blankSpace = " ";
        blankSpace = blankSpace.repeat((model.getNumRows() - 1 - i) * 2);
        int j = 0;
        while (j < model.getRowWidth(i)) {
          if (j == 0) {
            finalRow += blankSpace;
          }
          if (j == model.getRowWidth(i) - 1 && model.getCardAt(i, j) == null) {
            eachRow = finalRow.concat(".");
          }
          else if (j == model.getRowWidth(i) - 1 && model.getCardAt(i, j) != null) {
            eachRow = finalRow.concat(model.getCardAt(i, j).toString());
          }
          else if (model.getCardAt(i, j) == null) {
            eachRow = finalRow.concat(".   ");
          }
          else if (model.getCardAt(i, j).toString().equals("10♣") ||
              model.getCardAt(i, j).toString().equals("10♦") ||
              model.getCardAt(i, j).toString().equals("10♥") ||
              model.getCardAt(i, j).toString().equals("10♠")) {
            eachRow = finalRow.concat(model.getCardAt(i, j).toString()).concat(" ");
          }
          else {
            eachRow = finalRow.concat(model.getCardAt(i, j).toString()).concat("  ");
          }
          finalRow = eachRow;
          j += 1;
        }
        finalRow += "\n";
      }

      String draw = "";
      model.getDrawCards();
      if (model.getDrawCards().isEmpty()) {
        draw = "Draw:";
      }
      else {
        int k = 0;
        draw = "Draw: ";
        while (k < model.getDrawCards().size()) {
          String card = model.getDrawCards().get(k).toString();
          String drawCard = "";
          if (k == model.getDrawCards().size() - 1) {
            drawCard = draw.concat(card);
          }
          else {
            drawCard = draw.concat(card).concat(", ");
          }
          draw = drawCard;
          k += 1;
        }
      }
      finalRow += draw;
      return finalRow;
    }
  }

  /**
   * Render method which appends current toString method to appendable.
   *
   * @throws IOException if render throws exception.
   */
  @Override
  public void render() throws IOException {
    out.append(this.toString());
  }
}
