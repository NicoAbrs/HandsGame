package nz.ac.auckland.se281;

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
        if (oddCount < evenCount) {
            // Player is likely to choose odd, so we choose even
            return Utils.getRandomEvenNumber(); // Returns 0, 2, or 4
        } else if (evenCount < oddCount) {
            // Player is likely to choose even, so we choose odd
            return Utils.getRandomOddNumber(); // Returns 1, 3, or 5
        } else {
            // Player is equally likely to choose odd or even, so we choose randomly
            return Utils.getRandomNumberRange(0, 5); 
        }
    }
}
