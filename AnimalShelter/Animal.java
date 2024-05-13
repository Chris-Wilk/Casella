/* *
 * Assignment 04 Animal Class
 * Creates the Animal class that will take multiple different types of data from a file and created a class
 * @author Chris Wilk
 * @date: 20 September 2023
 * @assignment CIS 203, Assignment 04, Fall 2023
 **/

public class Animal {
	private String name;
	private String type;
	private char sex;
	private double ageInYears;
	private String homeType;
	private int yearRescued;
	/**
	 * This method will create the defaults for each parameter
	 * @param inName is the name of the animal 
	 * @param inType is the type of the animal
	 * @param inSex is the sex of the animal
	 * @param inAgeInYears is the age of the animal
	 * @param inHomeType is the type of home the animal lives in
	 * @param inYearRescued is when the animal was rescued
	 */
	
	public Animal(String inName, String inType, char inSex, double inAgeInYears, String inHomeType, int inYearRescued) {
		name = inName;
		type = inType;
		sex = inSex;
		ageInYears = inAgeInYears;
		homeType = inHomeType;
		yearRescued = inYearRescued;
	}
	
	/**
	 * the toString method will output the animal that has been created to the console
	 */
    public String toString(){
    	return (name + " " + type + " "+ sex + " " + ageInYears + " " + homeType + " " + yearRescued);
    }
	
    /**
     * This is the default constructor for the animal class. It will set every data type to the default value
     */
	public Animal() {
		this(null, null, '\0', 0.0, null, 0);
	}
	
    /**
     * the getName method will output the name of the animal 
     * @return the name of the animal
     */
	public String getName() {
		return name;
	}
	
	/**
	 * The getType animal will output the type of animal
	 * @return the type of animal
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * The getSex method will output the sex of the animal
	 * @return the sex of the animal
	 */
	public char getSex() {
		return sex;
	}
	
	/**
	 * the getAgeInYears method will output the age of the animal
	 * @return the age of the animal
	 */
	public double getAgeInYears() {
		return ageInYears;
	}
	
	/**
	 * the getHomeType method will output the home type of the animal
	 * @return the type of home
	 */
	public String getHomeType() {
		return homeType;
	}
	
	/**
	 * The getYearRescued method will output the year the animnal was rescued
	 * @return the year the animal was rescued
	 */
	public int getYearRescued() {
		return yearRescued;
	}
	
	/**
	 * the setName method will set the name of the animal
	 * @param inName assigns the name of the animal
	 */
	public void setName(String inName) {
		name = inName;
	}
	
	/**
	 * the setType method will set the type of animal
	 * @param inType assigns the type of animal
	 */
	public void setType(String inType) {
		type = inType;
	}
	
	/**
	 * the setSex method will set the sex of the animal
	 * @param inSex assigns the sex of the animal
	 */
	public void setSex(char inSex) {
		sex = inSex;
	}
	
	/**
	 * the seAgeInYears method will set the age of the animal
	 * @param inAgeInYears assigns the age of the animal
	 */
	public void setAgeInYears(double inAgeInYears) {
		ageInYears = inAgeInYears;
	}
	
	/**
	 * the setHomeType method will set the type of home for the animal
	 * @param inHomeType assigns the type of home of the animal
	 */
	public void setHomeType(String inHomeType) {
		homeType = inHomeType;
	}
	
	/**
	 * the setYearRescued will set the year the animal was rescued
	 * @param inYearRescued assigns the year the animal was rescued
	 */
	public void setYearRescued(int inYearRescued) {
		yearRescued = inYearRescued;
	}
}
