/**
 * Represents an arena where critters can engage in battles.
 * Provides methods to create random critters, initiate battles between critters, and determine the outcome of battles.
 * 
 * @author Chris Wilk
 * @email wilkct207@potsdam.edu
 * @version 1.0
 * @since 2024-03-11
 */
package example;

import critters.Critter;
import critters.Fighter;
import critters.Rogue;
import critters.Wizard;

import java.util.Random;

public class Arena {

    /**
     * Creates a new critter based on the specified kind and attribute values.
     * 
     * @param kind the kind of critter to create (Fighter, Rogue, or Wizard)
     * @param name the name of the critter
     * @param STR  the value of the Strength attribute
     * @param DEX  the value of the Dexterity attribute
     * @param INT  the value of the Intelligence attribute
     * @return the created critter
     * @throws IllegalArgumentException if the specified critter kind is invalid
     */
    public static Critter critterFactory(String kind, String name, int STR, int DEX, int INT) {
        // Create a new critter based on the given kind and attribute values
        if (kind.equalsIgnoreCase("Fighter")) {
            return new Fighter(name, STR, DEX, INT);
        } else if (kind.equalsIgnoreCase("Rogue")) {
            return new Rogue(name, STR, DEX, INT);
        } else if (kind.equalsIgnoreCase("Wizard")) {
            return new Wizard(name, STR, DEX, INT);
        } else {
            throw new IllegalArgumentException("Invalid critter kind: " + kind);
        }
    }

    /**
     * Creates a random critter with random attribute values.
     * 
     * @param name   the name of the critter
     * @param random a Random object for generating random values
     * @return the created random critter
     */
    public static Critter makeRandomCritter(String name, Random random) {
        // Generate random attribute values for the critter
        int STR = rollDice(random);
        int DEX = rollDice(random);
        int INT = rollDice(random);

        // Randomly choose a critter type and create a new critter with the generated attributes
        int critterType = random.nextInt(3); // 0 = Fighter, 1 = Rogue, 2 = Wizard
        switch (critterType) {
            case 0:
                return critterFactory("Fighter", "Fighter", STR, DEX, INT);
            case 1:
                return critterFactory("Rogue", "Rogue", STR, DEX, INT);
            case 2:
                return critterFactory("Wizard", "Wizard", STR, DEX, INT);
            default:
                throw new IllegalStateException("Unexpected critter type: " + critterType);
        }
    }

    /**
     * Rolls a six-sided die (d6) and returns the result.
     * 
     * @param random a Random object for generating random values
     * @return the result of rolling the die
     */
    private static int rollDice(Random random) {
        // Roll a six-sided die (d6)
        return random.nextInt(6) + 1;
    }

    /**
     * Initiates a battle between two critters until one of them is defeated.
     * 
     * @param combatantA the first critter
     * @param combatantB the second critter
     * @param random     a Random object for generating random values
     * @return the winner of the battle (or null if it ends in a draw)
     */
    public static Critter fight(Critter combatantA, Critter combatantB, Random random) {
        // Run a battle between two critters until one of them is dead
        while (combatantA.isAlive() && combatantB.isAlive()) {
            // Roll a d20 for each critter to determine the order of attack
            int rollA = random.nextInt(20) + 1;
            int rollB = random.nextInt(20) + 1;

            // Determine which critter goes first based on their rolls
            Critter first, second;
            if (rollA >= rollB) {
                first = combatantA;
                second = combatantB;
            } else {
                first = combatantB;
                second = combatantA;
            }

            // Attempt attack from the first critter
            if (first.attack(second, random)) {
                // If attack succeeds, apply damage to the second critter
                int damage = first.doDamage(second, random);
                System.out.println(first.getName() + " hits " + second.getName() + " for " + damage + " damage!");
            } else {
                System.out.println(first.getName() + " missed their attack!");
            }

            // Check if the second critter is still alive before its attack
            if (second.isAlive()) {
                // Attempt attack from the second critter
                if (second.attack(first, random)) {
                    // If attack succeeds, apply damage to the first critter
                    int damage = second.doDamage(first, random);
                    System.out.println(second.getName() + " hits " + first.getName() + " for " + damage + " damage!");
                }
            }
        }

        // Return the critter that is still alive (or null if both are dead)
        if (combatantA.isAlive()) {
            return combatantA;
        } else if (combatantB.isAlive()) {
            return combatantB;
        } else {
            return null;
        }
    }

    /**
     * Runs a battle between two random critters and prints the result.
     * 
     * @param arena the Arena object used to run the battle
     */
    public void run(Arena arena) {
        Random random = new Random();

        // Generate two random critters
        Critter critterA = arena.makeRandomCritter("CritterA", random);
        Critter critterB = arena.makeRandomCritter("CritterB", random);

        // Print the attributes of the critters
        System.out.println("Critter A: " + critterA.getName());
        System.out.println("Critter B: " + critterB.getName());

        // Fight between the critters
        Critter winner = arena.fight(critterA, critterB, random);

        // Print the winner, if any
        if (winner != null) {
            System.out.println("The winner is: " + winner.getName());
        } else {
            System.out.println("The battle ended in a draw.");
        }
    }

    /**
     * Main method to run the Arena program.
     * 
     * @param args the command-line arguments (not used)
     */
    public static void main(String[] args) {
        Arena arena = new Arena();
        arena.run(arena);
    }
}
