package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private int Game_Round = 1;

  /**
   * This method Starts a Newgame 'Odds and Evens' With all the parameters 
   * To start playing and adjust the options.
   * 
   * @param difficulty The chosen difficulty, changes AI behaviour
   * @param choice The player chooses if they are predicting odd or even
   * @param options Options[0] is the player name
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
  }

  public void play() {
    String user_input; 
    boolean input_pass = false; 

    // Print with the round number then update the number of rounds
    MessageCli.START_ROUND.printMessage(Integer.toString(Game_Round));
    Game_Round++; 

    // Checking the user input
    do {
      MessageCli.ASK_INPUT.printMessage();
      user_input = Utils.scanner.nextLine();
      int integer_user = Integer.parseInt(user_input);

      // Checking if it is between 0 and 5
      if ((integer_user > 0) && (integer_user <= 5)) {
        input_pass = true; 
      } else {
        MessageCli.INVALID_INPUT.printMessage();
      }
    } while(!input_pass);
  }

  public void endGame() {}

  public void showStats() {}
}
