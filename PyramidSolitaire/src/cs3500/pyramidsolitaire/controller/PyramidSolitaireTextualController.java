package cs3500.pyramidsolitaire.controller;

import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.view.PyramidSolitaireTextualView;
import cs3500.pyramidsolitaire.view.PyramidSolitaireView;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Class representing Pyramid Solitaire view controller. This allows the model and view to
 * communicate with the user and implements the PyramidSolitaireController interface. The main
 * function of this class is to play a game.
 */
public class PyramidSolitaireTextualController implements PyramidSolitaireController {
  private final Readable rd;
  private final Appendable ap;
  private PyramidSolitaireView view;

  /**
   * Constructor with readable and appendable.
   *
   * @param rd Readable in
   * @param ap Appendable out
   * @throws IllegalArgumentException if model or deck is null and game cannot be started
   */
  public PyramidSolitaireTextualController(Readable rd, Appendable ap)
      throws IllegalArgumentException {
    this.rd = rd;
    this.ap = ap;
    this.view = null;
  }

  /**
   * Constructor without a readable, only used for testing purposes as of now.
   *
   * @param ap Appendable out
   * @throws IllegalArgumentException if model or deck is null and game cannot be started
   */
  public PyramidSolitaireTextualController(Appendable ap)
      throws IllegalArgumentException {
    this.rd = null;
    this.ap = ap;
  }


  /**
   * The primary method for beginning and playing a game.
   *
   * @param model   The game of solitaire to be played
   * @param deck    The deck of cards to be used
   * @param shuffle Whether to shuffle the deck or not
   * @param numRows How many rows should be in the pyramid
   * @param numDraw How many draw cards should be visible
   * @throws IllegalArgumentException if the model or deck is null
   * @throws IllegalStateException    if the game cannot be started, or if the controller cannot
   *                                  interact with the player.
   */

  @Override
  public <K> void playGame(PyramidSolitaireModel<K> model, List<K> deck, boolean shuffle,
      int numRows, int numDraw) throws IllegalArgumentException, IllegalStateException {
    if (model == null) {
      throw new IllegalArgumentException("Model cannot be null");
    }
    if (deck == null) {
      throw new IllegalArgumentException("Deck cannot be null");
    }
    model.startGame(deck, shuffle, numRows, numDraw);
    view = new PyramidSolitaireTextualView(model, ap);
    StringBuilder badInput = new StringBuilder("\nThis is an invalid input, reenter value.");
    StringBuilder quit = new StringBuilder("\nGame quit! \nState of game when quit:");
    StringBuilder invalidMove = new StringBuilder("\nInvalid Move. Play again. ");
    StringBuilder score = new StringBuilder("\nScore: " + model.getScore());
    StringBuilder newLine = new StringBuilder("\n");
    helpAppendRender();
    helpAppend(score);
    Scanner scan = new Scanner(this.rd);
    String str;
    str = scan.next();
    /*
    To recheck for inputs at the beginning.
    while (!checkMove(str)) {
      str = scan.next();
    }
     */
    if (!checkMove(str)) {
      throw new IllegalArgumentException("This is a bad input.");
    }
    while (!model.isGameOver() && scan.hasNext()) {
      switch (str) {
        case "rm1":
          int row;
          int card;
          row = scan.nextInt() - 1;
          card = scan.nextInt() - 1;
          try {
            model.remove(row, card);
          } catch (IllegalArgumentException e) {
            StringBuilder error = new StringBuilder(invalidMove + e.getMessage());
            helpAppend(error);
          }
          score = new StringBuilder("\nScore: " + model.getScore());
          helpAppend(newLine);
          helpAppendRender();
          helpAppend(score);
          break;
        case "rm2":
          int row1;
          int card1;
          int row2;
          int card2;
          row1 = scan.nextInt() - 1;
          card1 = scan.nextInt() - 1;
          row2 = scan.nextInt() - 1;
          card2 = scan.nextInt() - 1;
          model.remove(row1, card1, row2, card2);
          score = new StringBuilder("\nScore: " + model.getScore());
          helpAppend(newLine);
          helpAppendRender();
          helpAppend(score);
          break;
        case "rmwd":
          int stock;
          int rowWD;
          int cardWD;
          stock = scan.nextInt() - 1;
          rowWD = scan.nextInt() - 1;
          cardWD = scan.nextInt() - 1;
          model.removeUsingDraw(stock, rowWD, cardWD);
          score = new StringBuilder("\nScore: " + model.getScore());
          helpAppend(newLine);
          helpAppendRender();
          helpAppend(score);
          break;
        case "dd":
          int stockDD;
          stockDD = scan.nextInt() - 1;
          model.discardDraw(stockDD);
          score = new StringBuilder("\nScore: " + model.getScore());
          helpAppend(newLine);
          helpAppendRender();
          helpAppend(score);
          break;
        case "q":
        case "Q":
          helpAppend(quit);
          helpAppendRender();
          helpAppend(score);
          break;
        default:
      }
    }
  }



  /**
   * Checks if scanner returns proper input at the start.
   *
   * @param str string input
   * @return checks if scanner returns proper input
   */
  private boolean checkMove(String str) {

    return str.equals("rm1") || str.equals("rm2") || str.equals("rmwd") || str.equals("dd")
        || str.equals("q") || str.equals("Q");
  }


  /**
   * Appends a string to the appendable.
   *
   * @param stringBuilder string to be appended
   */
  private void helpAppend(StringBuilder stringBuilder) {
    try {
      ap.append(stringBuilder);
    } catch (IOException e) {
      throw new IllegalStateException("Readable is unable to provide input.");
    }
  }

  /**
   * Appends render to the appendable.
   */
  private void helpAppendRender() {
    try {
      view.render();
    } catch (IOException e) {
      throw new IllegalStateException("Readable is unable to provide input");
    }
  }


}
