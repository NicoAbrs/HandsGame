package nz.ac.auckland.se281;

import java.util.List;

import nz.ac.auckland.se281.Main.Choice;


public class EasyAI implements AI {

    private Strategy strategy; 

    @Override
    public Strategy getStrategy() {
        return this.strategy; 
    }

    @Override
    public void setStrategy(Strategy strategyType) {
        this.strategy = strategyType; 
    }

    /**
     * Using one strategy for the rest of the round
     * 
     */
    @Override
    public int play(int round, List<Integer> playerActions, Choice playerChoice, List<Integer> playerWinHistory) {
        setStrategy(new RandomStrategy());
        return strategy.getAction(); 
    }
}
