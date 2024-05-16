package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

interface Strategy {
    public Choice getAction();
}