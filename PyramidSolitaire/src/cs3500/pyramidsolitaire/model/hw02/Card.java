package cs3500.pyramidsolitaire.model.hw02;

import java.util.Objects;

/**
 * Creates a card implementation.
 */
public class Card {
  public String value;
  public char suit;

  /**
   * Constructor which accounts for face cards.
   *
   * @param value value of the card
   * @param suit suit of the card
   */
  public Card(String value, char suit) {

    this.value = value;
    this.suit = suit;
  }

  /**
   * Gets suit of card.
   *
   * @return suit
   */
  public char getSuit() {
    return suit;
  }

  /**
   * Gets integer value of card.
   *
   * @return value of card.
   */
  public int getValue() {
    if (value.equals("A")) {
      return 1;
    }
    else if (value.equals("J")) {
      return 11;
    }
    else if (value.equals("Q")) {
      return 12;
    }
    else if (value.equals("K")) {
      return 13;
    }
    else {
      return Integer.parseInt(value);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Card card = (Card) o;
    return suit == card.suit &&
        value.equals(card.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, suit);
  }

  /**
   * ToString method for Card class.
   *
   * @return
   */
  public String toString() {
    if (this == null) {
      return ".  ";
    }
    else {
      return this.value + this.suit;
    }
  }

}
