package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

import nz.ac.auckland.se281.Main.Choice;


public class HardAI implements AI{
    private Strategy strategy; 
    private List<Integer> playerActions = new ArrayList<>();
    
    /**
     * This method Resets the History for the list 'playerActions'
     */
    public void resetHistory() {
        playerActions.clear();
    }


    @Override
    public Strategy getStrategy() {
        return this.strategy; 
    }

    @Override
    public void setStrategy(Strategy strategyType) {
        this.strategy = strategyType; 
    }

  /**
     * Method 'play' Deals with the real time strategy changes 
     * during the game, changing f
     * 
     * @param round The current round number in the game, dictates the strategy change
     * @param playerAction The number the player chooses, needed for TopStrategy
     * @return Returns the number generated from the strategy
     */
    @Override
    public int play(int round, List<Integer> playerActions, Choice playerChoice, List<Integer> playerWinHistory) {
        // Between rounds 1 and 3, use the random strategy, onwards use the topStrategy
        if (round <= 3) {
            setStrategy(new RandomStrategy());
        } else if (round > 3) {
            setStrategy(new RandomStrategy());
            if (playerWinHistory.get(playerWinHistory.size() - 1) == 0) {
                if (strategy instanceof RandomStrategy) {
                    setStrategy(new TopStrategy());
                    ((TopStrategy) strategy).setPlayerChoice(playerChoice); 
                    for (int action : playerActions) {
                        ((TopStrategy) strategy).updateCounts(action);
                    }
                }
            } else {
                setStrategy(new RandomStrategy());
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
