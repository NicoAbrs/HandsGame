package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

interface AI {
  void setStrategy(Strategy strategyType);

  int play(
      int round, List<Integer> playerAction, Choice playerChoice, List<Integer> playerWinHistory);
}
