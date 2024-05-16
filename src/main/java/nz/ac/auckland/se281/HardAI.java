package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

public class HardAI implements AI{
    private Strategy strategy; 
    private List<Integer> playerActions = new ArrayList<>(); 

    @Override
    public Strategy getStrategy() {
        return this.strategy; 
    }

    @Override
    public void setStrategy(Strategy strategyType) {
        this.strategy = strategyType; 
    }

    @Override
    public int play(int round, int playerAction) {
        playerActions.add(playerAction); 

        if (round <= 3) {
            setStrategy(new RandomStrategy());
        } else if (round > 3) {
            setStrategy(new TopStrategy());
            for (int action : playerActions) {
                ((TopStrategy) strategy).updateCounts(action);
            }
        }
        
        return strategy.getAction(); 
    }
}
