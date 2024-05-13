/**
 * Represents a Rogue critter, a subclass of Critter, with specific attributes and abilities.
 * Rogues have moderate hit points and specialize in agility and precision attacks.
 * 
 * @author Chris Wilk
 * @email wilkct207@potsdam.edu
 * Medieval Melee Assingment 4
 * 3/11/2024
 * Dr. Ladd
 */
package critters;

import java.util.Random;

public class Rogue extends Critter {

    /**
     * Constructs a Rogue with the given name and attribute values.
     * 
     * @param name             the name of the Rogue
     * @param strengthValue    the value of the Strength attribute
     * @param dexterityValue   the value of the Dexterity attribute
     * @param intelligenceValue the value of the Intelligence attribute
     */
    public Rogue(String name, int strengthValue, int dexterityValue, int intelligenceValue) {
        super(name, 6); // Hit points for Rogue is 6
        this.strength = new Attribute("Strength", strengthValue);
        this.dexterity = new Attribute("Dexterity", dexterityValue);
        this.intelligence = new Attribute("Intelligence", intelligenceValue);
    }

    /**
     * Calculates the damage dealt by the Rogue's attack.
     * 
     * @param random a Random object for rolling dice
     * @return the damage dealt by the Rogue's attack
     */
    @Override
    public int calculateDamage(Random random) {
        // Damage calculation for Rogue (1d6)
        return random.nextInt(6) + 1;
    }
}
