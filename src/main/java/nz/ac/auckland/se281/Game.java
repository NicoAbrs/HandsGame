package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private int gameRound = 1;
  private String playerName = null; 
  private Difficulty difficultyChoice;
  private Choice playerChoice;

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
    this.playerChoice = choice; 
  }

  /**
   * This method 'play' gets the initial user input while also
   * Checking if it fits the allowable numbers. 0 and 5.
   */
  public void play() {
    String userInput; 
    boolean inputPass = false; 
    int integerUser; 
    Choice numChoice; 

    // Print with the round number then update the number of rounds
    MessageCli.START_ROUND.printMessage(Integer.toString(gameRound));
    gameRound++; 

    // Checking the user input
    do {
      MessageCli.ASK_INPUT.printMessage();
      userInput = Utils.scanner.nextLine();
      integerUser = Integer.parseInt(userInput);

      // Checking if it is between 0 and 5
      if ((integerUser >= 0) && (integerUser <= 5)) {
        inputPass = true; 
      } else {
        MessageCli.INVALID_INPUT.printMessage();
      }
    } while(!inputPass);

    // Printing the info when implemented correctly
    MessageCli.PRINT_INFO_HAND.printMessage(playerName, userInput);

    // Getting the AI's fingers for the game
    AI ai = AIFactory.createAi(difficultyChoice); 
    int aiFingers = ai.play(gameRound, integerUser); 

    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", Integer.toString(aiFingers));

    // Checking who wins
    // Getting the sum
    int roundSum = aiFingers + integerUser; 
    numChoice = getChoice(roundSum);

    // Changing the variable names for the print_outcome_round
    String winner = playerName; 
    if (numChoice != playerChoice) {
      winner = "HAL-9000"; 
    }

    MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(roundSum), numChoice.toString(), winner);
  }

  /**
   * This method 'getChoice' finds the choice enum that the roundSum 
   * equates to. 
   * @param roundSum The sum of the integers in the round
   * @return the choice ODD/EVEN
   */
  public Choice getChoice(int roundSum) {
    if (Utils.isEven(roundSum)) {
      return Choice.EVEN;
    } else {
      return Choice.ODD; 
    }
  }

  public void endGame() {}

  public void showStats() {}
}
