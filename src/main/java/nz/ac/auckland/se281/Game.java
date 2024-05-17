package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private int gameRound;
  private String playerName = null;
  private String winner = null;
  private Difficulty difficultyChoice;
  private Choice playerChoice;
  private List<Integer> playerActions = new ArrayList<>();
  private List<Integer> playerWinHistory = new ArrayList<>();

  /**
   * This method Starts a Newgame 'Odds and Evens' With all the parameters To start playing and
   * adjust the options.
   *
   * @param difficulty The chosen difficulty, changes AI behaviour
   * @param choice The player chooses if they are predicting odd or even
   * @param options Options[0] is the player name
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    // Setting the private field variables
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    playerName = options[0];
    this.difficultyChoice = difficulty;
    this.playerChoice = choice;
    this.gameRound = 0;

    // Clear history
    playerActions.clear();
    playerWinHistory.clear();
  }

  /**
   * This method 'play' gets the initial user input while also Checking if it fits the allowable
   * numbers. 0 and 5. This plays the entire game controlling and calculating the AI strategies and
   * Factory creation based on the inputs.
   */
  public void play() {
    String userInput;
    boolean inputPass = false;
    int integerUser;
    Choice numChoice;

    if (playerName == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
    } else {
      // Print with the round number then update the number of rounds
      gameRound++;
      MessageCli.START_ROUND.printMessage(Integer.toString(gameRound));

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
      } while (!inputPass);
      // Adding to the history of playerInputs
      playerActions.add(integerUser);

      // Printing the info when implemented correctly
      MessageCli.PRINT_INFO_HAND.printMessage(playerName, userInput);

      // Getting the AI's fingers for the game
      AI ai = AIFactory.createAi(difficultyChoice);
      int aiFingers = ai.play(gameRound, playerActions, playerChoice, playerWinHistory);

      MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", Integer.toString(aiFingers));

      // Checking who wins
      // Getting the sum
      int roundSum = aiFingers + integerUser;
      numChoice = getChoice(roundSum);

      // Changing the variable names for the print_outcome_round
      String winner = playerName;
      if (numChoice != playerChoice) {
        winner = "HAL-9000";
        playerWinHistory.add(0);
      } else {
        playerWinHistory.add(1);
      }

      MessageCli.PRINT_OUTCOME_ROUND.printMessage(
          Integer.toString(roundSum), numChoice.toString(), winner);
    }
  }

  /**
   * This method 'getChoice' finds the choice enum that the roundSum equates to.
   *
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

  /**
   * Method endGame prints out the stats and the winner of all the rounds and resets everything to
   * get Ready for the new game
   *
   * <p>No return as it just prints.
   */
  public void endGame() {
    // showStats and print winner
    showStats();
    if (!winner.equals("Tie!")) {
      MessageCli.PRINT_END_GAME.printMessage(winner);
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }

    // Reset the playerName
    playerName = null;
  }

  /**
   * Method showStats prints out how many times the player lost and won and the same thing for the
   * AI. This is used in other methods
   *
   * <p>No return as it just prints.
   */
  public void showStats() {
    int playerRoundsWon = 0;
    int playerRoundsLost = 0;

    if (playerName == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
    } else {
      // Find out the playerRoundsWon
      playerRoundsWon = playerWinHistory.stream().mapToInt(Integer::intValue).sum();
      playerRoundsLost = playerWinHistory.size() - playerRoundsWon;

      // Player Wins
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          playerName, Integer.toString(playerRoundsWon), Integer.toString(playerRoundsLost));

      // AI WIns
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          "HAL-9000", Integer.toString(playerRoundsLost), Integer.toString(playerRoundsWon));

      // Setting who won
      if (playerRoundsWon > playerRoundsLost) {
        winner = playerName;
      } else if (playerRoundsWon < playerRoundsLost) {
        winner = "HAL-9000";
      } else {
        winner = "Tie!";
      }
    }
  }
}
