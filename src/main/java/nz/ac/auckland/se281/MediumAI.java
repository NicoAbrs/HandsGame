package nz.ac.auckland.se281;

import javax.management.MBeanRegistration;

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
    public int play(int round) {
        setStrategy(new RandomStrategy());
        return strategy.getAction(); 
    }
}
