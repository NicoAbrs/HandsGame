package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class MediumAi implements Ai {
  private Strategy strategy;

  /**
   * Setter method for the strategy for the AI.
   *
   * @param strategyType The strategy to be used by the AI. This should be an instance of a class
   *     that implements the Strategy interface.
   */
  @Override
  public void setStrategy(Strategy strategyType) {
    this.strategy = strategyType;
  }

  /**
   * Method 'play' Deals with the real time strategy changes during the game, Changing strategies.
   *
   * @param round The current round number in the game, dictates the strategy change
   * @param playerAction The number the player chooses, needed for TopStrategy
   * @return Returns the number generated from the strategy
   */
  @Override
  public int play(
      int round, List<Integer> playerActions, Choice playerChoice, List<Integer> playerWinHistory) {
    // Between rounds 1 and 3, use the random strategy, onwards use the topStrategy
    if (round <= 3) {
      setStrategy(new RandomStrategy());
    } else if (round > 3) {

      setStrategy(new TopStrategy());
      // Updates the count in topStrategy, which then decides what they use
      ((TopStrategy) strategy).setPlayerChoice(playerChoice);
      for (int action : playerActions) {
        ((TopStrategy) strategy).updateCounts(action);
      }
    } else {
      System.out.println("Error");
    }

    // Call the chosen strategy action
    return strategy.getAction();
  }
}
