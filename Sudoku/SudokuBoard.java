/* *
 * Assignment 05 AnimalShelter Class
 * Creates a sudoku board with recursive backtracking
 * @author Chris Wilk
 * @date: 26 November 2023
 * @assignment CIS 203, Assignment 11, Fall 2023
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SudokuBoard {
	private int[][] board;

	/**
	 * Constructor initializes the board with empty cells (filled with 0).
	 */
	public SudokuBoard() {
		board = new int[9][9];
		// Initialize each cell to 0
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				board[row][col] = 0;
			}
		}
	}

	/**
	 * Returns the value in the given cell.
	 * @return the value at the row and column number.
	 */
	public int at(int row, int column) {
		return board[row][column];
	}

	/**
	 * Sets the value in the given cell.
	 */
	public void set(int row, int column, int n) {
		board[row][column] = n;
	}

	/**
	 * Returns a String representation of the board.
	 * @return a String with the board filled in
	 */
	public String toString() {
		String result = "+---+---+---+---+---+---+---+---+---+\n| ";
		for (int row = 0; row < 9; row++) {
			if (row != 0) {
				result += "+---+---+---+---+---+---+---+---+---+\n| ";
				// result += "|";
			}
			for (int col = 0; col < 9; col++) {
				if (col != 0) {
					result += "| ";
				}
				if (isEmpty(row, col)) {
					result += "  ";
				} else {
					result += board[row][col] + " ";
				}
			}
			result += "|\n";
		}
		result += "+---+---+---+---+---+---+---+---+---+\n";
		return result;
	}

	/**
	 * Helper function to check if a cell is empty.
	 * @param row    an int for the row number
	 * @param column an int for the column number
	 * @return true or false if the row and column are empty.
	 */
	private boolean isEmpty(int row, int column) {
		return board[row][column] == 0;
	}

	/**
	 * Loads the Sudoku board from a given file.
	 * @param fileName the name of the file to load from
	 */
	public void loadFrom(String fileName) {
		try {
			File file = new File(fileName);
			Scanner fileScanner = new Scanner(file);

			for (int row = 0; row < 9; row++) {
				String line = fileScanner.nextLine();
				Scanner lineScanner = new Scanner(line);

				for (int col = 0; col < 9; col++) {
					int next = lineScanner.nextInt();
					set(row, col, next);
				}

			}

			fileScanner.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + fileName);
			System.exit(1);
			e.printStackTrace();
		}

	}

	/**
	 * Checks if a row is valid based on the sudoku rules.
	 * @param row the row number
	 * @return true or false if the row is valid
	 */
	public boolean rowStillValid(int row) {
		int[] counters = new int[10]; // 0...9 counters
		for (int col = 0; col < 9; col++) {
			counters[at(row, col)]++; // increment the counter
		}
		for (int i = 1; i <= 9; i++) {
			if (counters[i] > 1) {
				return false;
			}
		}
		return true; // Row is valid
	}

	/**
	 * Checks if the column is still valid based on the sudoku rules.
	 * @param column the column number to check
	 * @return true or false if the column is valid.
	 */
	public boolean columnStillValid(int column) {
		int[] counters = new int[10]; // 0...9 counters
		for (int row = 0; row < 9; row++) {
			counters[at(row, column)]++; // increment the counter
		}
		for (int i = 1; i <= 9; i++) {
			if (counters[i] > 1) {
				return false;
			}
		}
		return true; // Column is valid
	}

	/**
	 * Checks if the square is still valid based on the sudoku rules.
	 * @param centerRow the row number to check
	 * @param CenterColumn the column number to check
	 * @return true or false if the square is valid.
	 */
	public boolean squareStillValid(int centerRow, int centerColumn) {
		int[] counters = new int[10]; // 0...9 counters
		int ulRow = centerRow - 1;
		int ulColumn = centerColumn - 1;
		int lrRow = centerRow + 1;
		int lrColumn = centerColumn + 1;

		for (int row = ulRow; row <= lrRow; row++) {
			for (int col = ulColumn; col <= lrColumn; col++) {
				counters[at(row, col)]++; // increment the counter
			}
		}

		for (int i = 1; i <= 9; i++) {
			if (counters[i] > 1) {
				return false;
			}
		}
		return true; // Square is valid
	}

	/**
	 * Checks if the whole board is still valid.
	 * @return true or false if the board is valid
	 */
	public boolean stillValid() {
		for (int i = 0; i < 9; i++) {
			if (!rowStillValid(i) || !columnStillValid(i)) {
				return false;
			}
		}
		for (int row = 0; row <= 6; row += 3) {
			for (int col = 0; col <= 6; col += 3) {
				if (!squareStillValid(row + 1, col + 1)) {
					return false;
				}
			}
		}
		return true; // Whole board is valid
	}

	/**
	 * Attempts to solve the sudoku board.
	 * @return true or false if it is able to be solved or not
	 */
	public boolean solve() {
		return solveFrom(0, 0); // Start solving from the top-left cell
	}

	/**
	 * the recursive helper method to solve the board using recursive backtracking 
	 * @param row the row that is trying to be solved
	 * @param column the column that is trying to be solved
	 * @return true or false if the board was able to be solved.
	 */
	boolean solveFrom(int row, int column) {
		if (row == 9)
			return true; // Board completely filled and valid

		int nextColumn = column + 1;
		int nextRow = row;
		if (nextColumn == 9) {
			nextColumn = 0;
			nextRow++;
		}

		if (!isEmpty(row, column)) // Cell already contains a value
			return solveFrom(nextRow, nextColumn);
		else {
			for (int guess = 1; guess < 10; guess++) {
				set(row, column, guess); // Set a guess in the cell

				if (stillValid()) {
					if (solveFrom(nextRow, nextColumn)) // Recursive call
						return true; // Solution found
				}
			}
			// No valid guess; backtrack by resetting the cell and returning false
			set(row, column, 0);
			return false;
		}
	}

}
