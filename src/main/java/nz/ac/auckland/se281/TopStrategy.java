package nz.ac.auckland.se281;

import java.util.Random;

public class TopStrategy implements Strategy{
    private int oddCount = 0;
    private int evenCount = 0;

    public void updateCounts(int playerAction) {
        if (playerAction % 2 == 0) {
            evenCount++;
        } else {
            oddCount++;
        }
    }


    @Override
    public int getAction() {
            Random rand = new Random();
        if (oddCount > evenCount) {
            // Player is likely to choose odd, so we choose even
            return Utils.getRandomOddNumber(); 
        } else if (evenCount > oddCount) {
            // Player is likely to choose even, so we choose odd
            return Utils.getRandomEvenNumber(); // Returns 1, 3, or 5
        } else {
            // Player is equally likely to choose odd or even, so we choose randomly
            return Utils.getRandomNumberRange(0, 5); 
        }
    }
}
