/**
 * Represents an attribute of a critter, such as Strength, Dexterity, or Intelligence.
 * Attributes can be modified by applying buffs (advantages) or nerfs (disadvantages).
 * Provides methods to manipulate and interact with attributes.
 * 
 * @author Chris Wilk
 * @email wilkct207@potsdam.edu
 * Medieval Melee Assingment 4
 * 3/11/2024
 * Dr. Ladd
 */
package critters;

import java.util.Random;

public class Attribute {
    private String name;
    private int baseValue;
    private int buffValue;
    private int nerfValue;

    /**
     * Constructs an Attribute with the given name and base value.
     * 
     * @param name      the name of the attribute
     * @param baseValue the base value of the attribute
     */
    public Attribute(String name, int baseValue) {
        this.name = name;
        this.baseValue = baseValue;
        this.buffValue = 0;
        this.nerfValue = 0;
    }

    /**
     * Returns the base value of this attribute without any advantages or disadvantages applied.
     * 
     * @return the base value of the attribute
     */
    public int base() {
        return baseValue;
    }

    /**
     * Returns the current value of this attribute, including all advantages and disadvantages.
     * 
     * @return the current value of the attribute
     */
    public int current() {
        return baseValue + buffValue - nerfValue;
    }

    /**
     * Returns the total magnitude of this attribute's disadvantages.
     * 
     * @return the total magnitude of disadvantages
     */
    public int nerf() {
        return nerfValue;
    }

    /**
     * Changes the total disadvantages of this attribute by the given amount.
     * 
     * @param amount the amount to change the disadvantages by
     * @return the total magnitude of disadvantages after the adjustment
     */
    public int nerf(int amount) {
        nerfValue = Math.max(0, nerfValue + amount);
        return nerfValue;
    }

    /**
     * Returns the total magnitude of this attribute's advantages.
     * 
     * @return the total magnitude of advantages
     */
    public int buff() {
        return buffValue;
    }

    /**
     * Changes the total advantages of this attribute by the given amount.
     * 
     * @param amount the amount to change the advantages by
     * @return the total magnitude of advantages after the adjustment
     */
    public int buff(int amount) {
        buffValue = Math.max(0, buffValue + amount);
        return buffValue;
    }

    /**
     * Returns a string representation of this attribute.
     * 
     * @return a string of the form "name: baseValue(+buffValue/-nerfValue)"
     */
    @Override
    public String toString() {
        return name + ": " + baseValue + "(+" + buffValue + "/-" + nerfValue + ")";
    }

    /**
     * Runs an opposed test of this attribute against an opposing attribute.
     * 
     * @param opposingAttribute the attribute of the opponent
     * @param modifier          a situational adjustment on this test
     * @param random            a Random object for rolling a d20
     * @return true if the test succeeds, false otherwise
     */
    public boolean succeedAgainst(Attribute opposingAttribute, int modifier, Random random) {
        int roll = random.nextInt(20) + 1; // Roll a d20
        return (current() + roll + modifier - opposingAttribute.current() > 10);
    }

    /**
     * Runs an unopposed test of this attribute against a challenge.
     * 
     * @param opposingChallenge the intrinsic difficulty of the challenge
     * @param modifier          a situational modifier on this test
     * @param random            a Random object for rolling a d20
     * @return true if the test succeeds, false otherwise
     */
    public boolean succeedAgainst(int opposingChallenge, int modifier, Random random) {
        int roll = random.nextInt(20) + 1; // Roll a d20
        return (current() + roll + modifier - opposingChallenge > 10);
    }
}
