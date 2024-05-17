package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class HardAi implements Ai {
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
   * Method 'play' Deals with the real time strategy changes during the game.
   *
   * @param round The current round number in the game, dictates the strategy change
   * @param playerAction The number the player chooses, needed for TopStrategy
   * @return Returns the number generated from the strategy
   */
  @Override
  public int play(
      int round, List<Integer> playerActions, Choice playerChoice, List<Integer> playerWinHistory) {
    // Between rounds 1 and 3, use the random strategy
    if (round <= 3) {
      setStrategy(new RandomStrategy());
    } else if (round > 3) {
      setStrategy(new RandomStrategy());
      // Checking the most recent win
      if (playerWinHistory.get(playerWinHistory.size() - 1) == 1) {
        // Switching the strategy if it doesnt work
        if (strategy instanceof RandomStrategy) {
          setStrategy(new TopStrategy());
          ((TopStrategy) strategy).setPlayerChoice(playerChoice);
          for (int action : playerActions) {
            ((TopStrategy) strategy).updateCounts(action);
          }
        }
      }
    } else {
      System.out.println("Error");
    }
    // Print the chosen strategy
    System.out.println("Chosen strategy: " + strategy.getClass().getSimpleName());
    // Call the chosen strategy action
    return strategy.getAction();
  }
}
