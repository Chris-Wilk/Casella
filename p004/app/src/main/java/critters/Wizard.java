/**
 * Represents a Wizard critter, a subclass of Critter, with specific attributes and abilities.
 * Wizards have low hit points but excel in intelligence-based attacks and spellcasting.
 * 
 * @author Chris Wilk
 * @email wilkct207@potsdam.edu
 * Medieval Melee Assingment 4
 * 3/11/2024
 * Dr. Ladd
 */
package critters;

import java.util.Random;

public class Wizard extends Critter {

    /**
     * Constructs a Wizard with the given name and attribute values.
     * 
     * @param name             the name of the Wizard
     * @param strengthValue    the value of the Strength attribute
     * @param dexterityValue   the value of the Dexterity attribute
     * @param intelligenceValue the value of the Intelligence attribute
     */
    public Wizard(String name, int strengthValue, int dexterityValue, int intelligenceValue) {
        super(name, 4); // Hit points for Wizard is 4
        this.strength = new Attribute("Strength", strengthValue);
        this.dexterity = new Attribute("Dexterity", dexterityValue);
        this.intelligence = new Attribute("Intelligence", intelligenceValue);
    }

    /**
     * Calculates the damage dealt by the Wizard's attack.
     * 
     * @param random a Random object for rolling dice
     * @return the damage dealt by the Wizard's attack
     */
    @Override
    public int calculateDamage(Random random) {
        // Damage calculation for Wizard (1d4)
        return random.nextInt(4) + 1;
    }
}
