package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class AIFactory {

    public static AI createAi(Difficulty difficulty) {
        switch (difficulty) {
            case EASY: 
                return new EasyAI(); 
            default: 
                System.out.println("Error");
            return null; 
        }
    }
}
