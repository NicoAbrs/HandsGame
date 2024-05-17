package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class AiFactory {

  /**
   * createAI is the method which creates the AI behaviour based on The factory design pattern.
   *
   * @param difficulty Chooses the AI based on the difficulty
   * @return A new instance of the specific AI
   */
  public static Ai createAi(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new EasyAi();
      case MEDIUM:
        return new MediumAi();
      case HARD:
        return new HardAi();
      default:
        System.out.println("Error");
        return null;
    }
  }
}
