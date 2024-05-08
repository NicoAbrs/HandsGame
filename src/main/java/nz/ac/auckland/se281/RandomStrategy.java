package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy{
    
    /**
     * This Strategy focuses on using a random number generator 
     * To inform its actions
     */
    @Override
    public int getAction() {
        int randomInt = Utils.getRandomNumberRange(0, 5); 
        return randomInt;
    }
}
