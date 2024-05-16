package nz.ac.auckland.se281;


public class RandomStrategy implements Strategy{
    
    /**
     * This Strategy focuses on using a random number generator 
     * To inform its actions
     * 
     * Returns either ODD or EVEN, a choice ENUM
     */
    @Override
    public int getAction() {
        // Getting a random number
        int randomInt = Utils.getRandomNumberRange(0, 5); 

        // Returning either an even or odd ENUM choice
        // if (Utils.isEven(randomInt)) {
        //     return Choice.EVEN;
        // } else {
        //     return Choice.ODD; 
        // }

        return randomInt; 
    }
}
