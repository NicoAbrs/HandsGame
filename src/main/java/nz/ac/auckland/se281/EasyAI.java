package nz.ac.auckland.se281;


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

    @Override
    public int play(int round, int playerAction) {
        setStrategy(new RandomStrategy());
        return strategy.getAction(); 
    }
}
