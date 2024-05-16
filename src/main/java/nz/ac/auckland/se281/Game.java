package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private int gameRound = 1;
  private String playerName = null; 
  private Difficulty difficultyChoice;

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
    playerName = options[0];
    this.difficultyChoice = difficulty; 
  }

  /**
   * This method 'play' gets the initial user input while also
   * Checking if it fits the allowable numbers. 0 and 5.
   */
  public void play() {
    String userInput; 
    boolean inputPass = false; 

    // Print with the round number then update the number of rounds
    MessageCli.START_ROUND.printMessage(Integer.toString(gameRound));
    gameRound++; 

    // Checking the user input
    do {
      MessageCli.ASK_INPUT.printMessage();
      userInput = Utils.scanner.nextLine();
      int integer_user = Integer.parseInt(userInput);

      // Checking if it is between 0 and 5
      if ((integer_user > 0) && (integer_user <= 5)) {
        inputPass = true; 
      } else {
        MessageCli.INVALID_INPUT.printMessage();
      }
    } while(!inputPass);

    // Printing the info when implemented correctly
    MessageCli.PRINT_INFO_HAND.printMessage(playerName, userInput);

    // Getting the AI's play
    AI ai = AIFactory.createAi(difficultyChoice); 
    Choice aiFingers = ai.play(); 

    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", aiFingers.toString());
  }

  public void endGame() {}

  public void showStats() {}
}
