package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class EasyAi implements Ai {

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
   * Method play uses a random number generator generate the AI's play
   *
   * @return Integer number of fingers
   */
  @Override
  public int play(
      int round, List<Integer> playerActions, Choice playerChoice, List<Integer> playerWinHistory) {
    setStrategy(new RandomStrategy());
    return strategy.getAction();
  }
}
