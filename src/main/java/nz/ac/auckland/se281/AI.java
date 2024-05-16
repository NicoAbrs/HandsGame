package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

interface AI {
    Strategy getStrategy(); 
    void setStrategy(Strategy strategyType);
    Choice play();
}