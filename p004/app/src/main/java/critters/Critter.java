/**
 * Represents a generic critter in the game with attributes such as Strength, Dexterity, and Intelligence,
 * and hit points. Provides methods for attacking, taking damage, and checking if the critter is alive.
 * 
 * @author Chris Wilk
 * @email wilkct207@potsdam.edu
 * Medieval Melee Assingment 4
 * 3/11/2024
 * Dr. Ladd
 */
package critters;

import java.util.Random;

public class Critter {
    private String name;
    protected Attribute strength;
    protected Attribute dexterity;
    protected Attribute intelligence;
    protected int hitPoints;

    /**
     * Constructs a Critter with the given name and hit points.
     * 
     * @param name      the name of the critter
     * @param hitPoints the hit points of the critter
     */
    public Critter(String name, int hitPoints) {
        this.name = name;
        this.hitPoints = hitPoints;
    }

    /**
     * Returns the name of the critter.
     * 
     * @return the name of the critter
     */
    public String getName() {
        return name;
    }

    /**
     * Checks if the critter is alive (i.e., has positive hit points).
     * 
     * @return true if the critter is alive, false otherwise
     */
    public boolean isAlive() {
        return hitPoints > 0;
    }

    /**
     * Attempts to attack the opponent critter.
     * 
     * @param opponent the opponent critter to attack
     * @param random   a Random object for rolling dice
     * @return true if the attack succeeds, false otherwise
     */
    public boolean attack(Critter opponent, Random random) {
        // Perform some sort of test to determine if the attack succeeds
        // For now, let's simulate a simple attack using the dexterity attribute
        return random.nextInt(20) + 1 > opponent.dexterity.current();
    }

    /**
     * Calculates the damage dealt by the critter's attack.
     * 
     * @param random a Random object for rolling dice
     * @return the damage dealt by the critter's attack
     */
    public int calculateDamage(Random random) {
        // Implement damage calculation logic here
        return calculateDamage(random);
    }

    /**
     * Applies damage to the opponent critter.
     * 
     * @param opponent the opponent critter to apply damage to
     * @param random   a Random object for rolling dice
     * @return the damage points dealt to the opponent
     */
    public int doDamage(Critter opponent, Random random) {
        if (!opponent.isAlive()) {
            return 0; // If opponent is already dead, no damage can be dealt
        }
        int damage = calculateDamage(random);
        opponent.takeDamage(damage);
        return damage;
    }

    /**
     * Reduces the hit points of the critter by the specified amount of damage.
     * 
     * @param damage the amount of damage to apply
     */
    protected void takeDamage(int damage) {
        hitPoints -= damage;
        if (hitPoints < 0) {
            hitPoints = 0; // Ensure hitPoints doesn't go negative
        }
    }
}
