package nz.ac.auckland.se281;

interface AI {
    Strategy getStrategy(); 
    void setStrategy(Strategy strategyType);
    int play();
}