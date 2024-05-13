/**
 * Represents a Fighter critter, a subclass of Critter, with specific attributes and abilities.
 * Fighters have higher hit points and specialize in melee combat.
 * 
 * @author Chris Wilk
 * @email wilkct207@potsdam.edu
 * Medieval Melee Assingment 4
 * 3/11/2024
 * Dr. Ladd
 */
package critters;

import java.util.Random;

public class Fighter extends Critter {

    /**
     * Constructs a Fighter with the given name and attribute values.
     * 
     * @param name             the name of the Fighter
     * @param strengthValue    the value of the Strength attribute
     * @param dexterityValue   the value of the Dexterity attribute
     * @param intelligenceValue the value of the Intelligence attribute
     */
    public Fighter(String name, int strengthValue, int dexterityValue, int intelligenceValue) {
        super(name, 8); // Hit points for Fighter is 8
        this.strength = new Attribute("Strength", strengthValue);
        this.dexterity = new Attribute("Dexterity", dexterityValue);
        this.intelligence = new Attribute("Intelligence", intelligenceValue);
    }

    /**
     * Calculates the damage dealt by the Fighter's attack.
     * 
     * @param random a Random object for rolling dice
     * @return the damage dealt by the Fighter's attack
     */
    @Override
    public int calculateDamage(Random random) {
        // Damage calculation for Fighter (1d8)
        return random.nextInt(8) + 1;
    }
}
