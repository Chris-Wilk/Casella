/* *
 * Assignment 05 AnimalShelterDriver
 * Creates the AnimalShelterDriver test the animalShelter Class
 * @author Chris Wilk
 * @date: 26 September 2023
 * @assignment CIS 203, Assignment 05, Fall 2023
 **/
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class AnimalShelterDriver {
    static final int MAX_ITEMS = 20;
    
    public static void main(String[] args) {
        Animal[] animals = new Animal[MAX_ITEMS];
        AnimalShelter a1 = new AnimalShelter();
        int numAnimals = readFromFile(animals, args, a1);
        fillRescues(animals, numAnimals, a1); 
    }
    
    /**
     * readFromFile, reads data from file and populates Animal array; counts number of
     * objects read/added, up to max array capacity
     * @param animals, an array of Animal objects
     * @param args, array of command line arguments
     * @throws IOExceptions on FileNotFound and data parsing/type mismatch errors
     * @return count of animals read and stored in array
     */
    static int readFromFile(Animal[] animals, String[] args, AnimalShelter a1) {
	   	String file = args[0];
    	int arrayLength = 0;
    	try {
    		Scanner input = new Scanner (new File(file));
    		while(input.hasNextLine()) {
    			Scanner line = new Scanner(input.nextLine());
    			if(line.hasNext()) {
    				animals[arrayLength++] = new Animal(line.next(), line.next(), line.next().charAt(0), line.nextDouble(), line.next(), line.nextInt());;
    			}
    		}
    	}catch(Exception e) {
    		System.out.println("Error " + e);
    		e.printStackTrace();
    		System.exit(2);
    	}
        return arrayLength;
    }
    
    /**
     * the fillRescues method will populate the animalShelter array with animals from this file.
     * along with other class method calls to test the animalShelter class
     * @param animals the animals array
     * @param numAnimals the number of animals
     * @param a1 the animalShelter class
     */
    static void fillRescues(Animal[] animals, int numAnimals, AnimalShelter a1) {
    	a1.setName("Awesome");
    	for(int i =0; i < numAnimals; i++) {
    		a1.addAnimal(animals[i]);
    	}
    	System.out.println(a1.getCount());
    	a1.getSummaryByYear();
    	System.out.println(a1.getSummaryByType());
    	a1.printReport();
    	System.out.println(a1.toString());
    	//a1.deleteAnimal("Inky");
    	
    }
}
