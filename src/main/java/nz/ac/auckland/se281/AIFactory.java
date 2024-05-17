package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class AIFactory {

  /**
   * createAI is the method which creates the AI behaviour based on The factory design pattern
   *
   * @param difficulty Chooses the AI based on the difficulty
   * @return A new instance of the specific AI
   */
  public static AI createAi(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new EasyAI();
      case MEDIUM:
        return new MediumAI();
      case HARD:
        return new HardAI();
      default:
        System.out.println("Error");
        return null;
    }
  }
}
