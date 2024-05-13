/* *
 * Assignment 05 AnimalShelter Class
 * Creates the AnimalShelter to take Animals and add them to the AnimalShelter array
 * @author Chris Wilk
 * @date: 26 September 2023
 * @assignment CIS 203, Assignment 05, Fall 2023
 **/

import java.util.Arrays;

public class AnimalShelter {
	public final int SIZE = 50;

	private String name;
	private Animal[] rescues;
	private int count;
/**
 * This method will create the defaults for each parameter
 * @param inName the default name of the animal
 * @param inRescues the default animal array
 * @param inCount the default count
 */
	public AnimalShelter(String inName, Animal[] inRescues, int inCount) {
		name = inName;
		rescues = new Animal[SIZE];
		count = inCount;
	}
/**
 * the default constructor assigning all values to the null or 0 values.
 */
	public AnimalShelter() {
		this(null, null, 0);
	}

	/**
	 * the setName method will set the name of the animal shelter
	 * @param inName the name of the animal shelter
	 */
	public void setName(String inName) {
		name = inName;
	}

	/**
	 * the getName method will return the name of the animal shelter
	 * @return the name of the animal shelter
	 */
	public String getName() {
		return name;
	}

	/**
	 * the getCount method will return the number of animals in the shelter
	 * @return returns the number of animals in the shelter
	 */
	public int getCount() {
		return count;
	}

	/**
	 * the addAnimal method adds the animal that is passed to the animal object array
	 * @param intakeRescue the animal to be added to the array
	 */
	public void addAnimal(Animal intakeRescue) {
		rescues[count++] = intakeRescue;
	}

	/**
	 * The deletAnimal Method will take a string and find that animal in the animal array. If it is found
	 * then the animal and all of its data will be removed
	 * Not working at this time
	 * @param animalName the name of the animal to be removed
	 */
	public void deleteAnimal(String animalName) {
		for (int i = 0; i < count; i++) {
			Animal[] animal2 = { rescues[i] };
			String[] animalLine = Arrays.toString(animal2).split(" ");
			String animalString = animalLine[0].substring(1, animalLine[0].length());
		//	System.out.println(animalLine[0].substring(1, animalLine[0].length()));
			if (animalString.equals(animalName)) {
				for (int x = i + 1; x < count -1; x++) {
					rescues[x] = rescues[x + 1];
				}
				count--;
			}else {
				System.out.println(animalString + " " + animalName);
			}
		}
	}

	/**
	 * the getSummaryByType method will calculate each number of all the types of animals in the shelter
	 * @return the number of animals by type
	 */
	public String getSummaryByType() {
		int cat = 0;
		int dog = 0;
		int bird = 0;
		int other = 0;
		for (int i = 0; i < SIZE; i++) {
			if (rescues[i] != null) {
				Animal[] animal2 = { rescues[i] };
				String[] animalLine = Arrays.toString(animal2).split(" ");
				if (animalLine[1].equals("bird")) {
					bird++;
				} else if (animalLine[1].equals("cat")) {
					cat++;
				} else if (animalLine[1].equals("dog")) {
					dog++;
				} else {
					other++;
				}
			}

		}
		String last = "Birds: " + bird + "; Cats: " + cat + "; Dogs: " + dog + "; Other: " + other;
		return last;

	}

	/**
	 * the getSummaryByYear method will calculate how many animals have are in the shelter based off the
	 * year they were rescued
	 */
	public void getSummaryByYear() {
		String[] years = new String[SIZE];
		for (int i = 0; i < SIZE; i++) {
			if (rescues[i] != null) {
				Animal[] animals2 = { rescues[i] };
				String[] a1 = Arrays.toString(animals2).split(" ");
				String s = a1[5].substring(0, a1[5].length() - 1);
				years[i] = s;
			}
		}
		summary2(years);
	}

	/**
	 * the summary2 method  is a helper method to the getSummaryByYear method.
	 * this method will take the array of years and return a string that has the years and the number of 
	 * rescues by year.
	 * @param years the array of years that animals have been rescued
	 */
	public void summary2(String[] years) {
		int count = 0;
		for (int i = 0; i < years.length; i++) {
			if (years[i] != null) {
				count++;
			}
		}
		int[] yearInNumbers = new int[count];
		for (int i = 0; i < count; i++) {
			yearInNumbers[i] = Integer.parseInt(years[i]);
		}
		Arrays.sort(yearInNumbers);
		int numberOfYears = yearInNumbers[yearInNumbers.length - 1] - yearInNumbers[0] + 1;
		int temp = yearInNumbers[0];
		int[] allYears = new int[numberOfYears];
		for (int i = 0; i < numberOfYears; i++) {
			allYears[i] = temp + i;
		}
		int[] amount = new int[numberOfYears];
		for (int i = 0; i < numberOfYears; i++) {
			for (int x = 0; x < yearInNumbers.length; x++) {// Extension
				if (yearInNumbers[x] == allYears[i]) {
					amount[i]++;
				}
			}
		}
		for (int i = 0; i < numberOfYears; i++) {
			System.out.println(allYears[i] + ": " + amount[i]);
		}
	}

	/**
	 * the printReport method will display all the information in the class in a specific output display.
	 */
	public void printReport() {
		System.out.println("ALL RESCUES:");
		System.out.printf(" %-10s  %-10s  %-10s %-7s %-5s %n", "Animal Type", "Name", "Sex", "Age", "Rescue Year");
		System.out.printf(" %-10s  %-10s  %-10s %-7s %-5s %n", "-----------", "-----", "---", "---", "-----------");
		for (int i = 0; i < count; i++) {
			if (rescues != null) {
				Animal[] animals2 = { rescues[i] };
				String[] animalLine = Arrays.toString(animals2).split(" ");
				// for(int x =0; x < a1.length-1; x++){
				System.out.printf(" %-11s  %-11s  %-9s %-10s %s %n", animalLine[1],
						animalLine[0].substring(1, animalLine[0].length()), animalLine[2], animalLine[3],
						animalLine[5].substring(0, animalLine[5].length() - 1));
				// }
			}
		}
		System.out.println();
		System.out.println("SUMMARY BY CATEGORY: ");
		System.out.printf(" %-5s  %-10s %n", "Type", "Number Rescues");
		System.out.printf(" %-5s  %-10s %n", "----", "--------------");
		printReportHelper();

	}

	/**
	 * the printReportHelper method is a helper method for printReport to do the calculations for the
	 * years and category outputs
	 */
	private void printReportHelper() {
		String summary1 = getSummaryByType();
		String[] summaryLine = summary1.split(" ");
		for (int i = 0; i < summaryLine.length - 1; i++) {
			summaryLine[i] = summaryLine[i].substring(0, summaryLine[i].length() - 1);
		}
		summaryLine[summaryLine.length - 2] = summaryLine[summaryLine.length - 2] + "*";
		for (int i = 0; i < summaryLine.length - 1; i = i + 2) {
			System.out.printf(" %-10s  %-10s %n", summaryLine[i], summaryLine[i + 1]);
		}
		System.out.println();
		System.out.println("*Includes: bear, fish, leopard, snake, gerbil");

		String[] years = new String[SIZE];
		for (int i = 0; i < SIZE; i++) {
			if (rescues[i] != null) {
				Animal[] animals2 = { rescues[i] };
				String[] a1 = Arrays.toString(animals2).split(" ");
				String s = a1[5].substring(0, a1[5].length() - 1);
				years[i] = s;
			}
		}

		int[] yearInNumbers = new int[count];
		for (int i = 0; i < count; i++) {
			yearInNumbers[i] = Integer.parseInt(years[i]);
		}
		Arrays.sort(yearInNumbers);
		System.out.println();
		System.out.println("SUMMARY TOTALS");
		System.out.println("Number of rescues: " + count);
		System.out.println("Year range: " + yearInNumbers[0] + " - " + yearInNumbers[yearInNumbers.length - 1]);
	}
	
	/**
	 * the toString method will output the name of the shelter and the count of the animals in the shelter
	 */
	public String toString() {
		return name + " AnimalShelter, " +  count + " rescues."; 
	}

}
