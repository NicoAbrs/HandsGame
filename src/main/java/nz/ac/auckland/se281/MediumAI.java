package nz.ac.auckland.se281;

public class MediumAI implements AI{
    private Strategy strategy; 

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
        if (round <= 3) {
            setStrategy(new RandomStrategy());
        } else if (round > 3) {
            setStrategy(new TopStrategy());
            ((TopStrategy) strategy).updateCounts(playerAction); 
        }
        
        return strategy.getAction(); 
    }
}
