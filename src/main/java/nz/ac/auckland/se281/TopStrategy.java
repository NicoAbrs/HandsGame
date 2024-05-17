package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy implements Strategy {
  private int oddCount = 0;
  private int evenCount = 0;
  private Choice playerChoice;

  /**
   * Method UpdateCounts categorises the playerActions between Even or Odd tendencies.
   *
   * @param playerAction The fingers the player puts
   */
  public void updateCounts(int playerAction) {
    if (playerAction % 2 == 0) {
      evenCount++;
    } else {
      oddCount++;
    }
  }

  /**
   * A Setter method for playerChoice for use in the getAction and TopStrategy.
   *
   * @param playerChoice The player choice between ODD or EVEN
   */
  public void setPlayerChoice(Choice playerChoice) {
    this.playerChoice = playerChoice;
  }

  /**
   * Method getAction based on the player's behaviour will choose the best Action to win, the
   * behaviour being what the player tends to choose, ODD or EVEN.
   *
   * @return A number representing the AI's Fingers for the hands game
   */
  @Override
  public int getAction() {

    if (oddCount > evenCount) {
      // Player is likely to choose odd
      if (playerChoice == Choice.EVEN) {
        return Utils.getRandomEvenNumber(); // Returns 0, 2, or 4
      } else if (playerChoice == Choice.ODD) {
        return Utils.getRandomOddNumber();
      }
    } else if (evenCount > oddCount) {
      // Player is likely to choose even
      if (playerChoice == Choice.EVEN) {
        return Utils.getRandomOddNumber(); // Returns 0, 2, or 4
      } else if (playerChoice == Choice.ODD) {
        return Utils.getRandomEvenNumber(); // Returns 1, 3, or 5
      }
    } else {
      // Player is equally likely to choose odd or even, so we choose randomly
      return Utils.getRandomNumberRange(0, 5);
    }
    return 0;
  }
}
