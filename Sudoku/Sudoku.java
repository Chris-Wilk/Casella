/**
 * Sudoku - Starter client for SudokuBoard programming project.
 *
 * Uses a standard create/run paradigm to avoid having many static
 * methods.
 *
 * Checks the number of command-line parameters, gives a usage message
 * if there is not EXACTLY one. Then creates the Sudoku object (with
 * the presumed file name) and calls run.
 *
 * @author Brian C. Ladd
 */

public class Sudoku {
  // File name provided on the command-line; SudokuBoard should be
  // loaded from it.
  private String fileName;
  // The sudoku board, filled and solved (eventually) with recursive
  // backtracking.
  private SudokuBoard board;

  /**
   * main program
   *  if !(right number of arguments)
   *    call usage and exit with error
   *  Create client object and call run.
   */
  public static void main(String[] args) {
    if (args.length != 1)
      usage(); // never returns

    String fileName = args[0];
    Sudoku solver = new Sudoku(fileName);
    solver.run();
  }

  /**
   * Sudoku application constructor: gets file name to load from.
   * Save file name, create empty board.
   * @param fileName path to a sudoku data file
   * (9x9 grid of integers, 0 for empty cell)
   */
  public Sudoku(String fileName) {
    this.fileName = fileName;
    this.board = new SudokuBoard();
  }

  /**
   * Display a usage message to standard error stream and halts.
   * A non-zero return code signals an error to the operating system.
   * @note This method NEVER returns. Terminates the program.
   */
  private static void usage() {
    System.err.println("usage: Sudoku <sudoku-file-name>");
    System.err.println();
    System.err.println("  where");
    System.err.println("    <sudoku-file-name>");
    System.err.println("    - path to a file w/ a sudoku configuration;");
    System.err.println("      nine rows of nine integers, 0 for empty cells");

    System.exit(1);
  }

  /**
   * run the program: load a board, display the board, solve the board
   */
  public void run() {
    // replace with a call to SudokuBoard.loadFrom(String fileName) when
    // that is written
	    board.loadFrom(fileName);

	    System.out.println("Initial Board Configuration");
	    System.out.println(board);

    /* Uncomment when SudokuBoard.stillValid is compiling
     */
    if (!board.stillValid()) {
      System.out.println("Initial configuration is not even vallid.");
      System.out.println("Will not attempt to solve.");
      System.exit(3);
    }
    

    System.out.println("Attempting to Solve");

    /* Uncomment when SudokuBoard.solve() is compiling
     * 
     */
    if (!board.solve()) {
      System.out.println("Attempt to solve failed.");
    } else {
      System.out.println("Sudoku Solution:");
      System.out.println(board) ;
    }
   
  }

  /**
   * Helper/test only method: fills in the sudoku from assignment
   *
   * Should NOT be called during normal operation.
   */
  private void fillBoardLikeAssignment() {
    board.set(0, 1, 2);
    board.set(0, 3, 5);
    board.set(0, 5, 1);
    board.set(0, 7, 9);

    board.set(1, 0, 8);
    board.set(1, 3, 2);
    board.set(1, 5, 3);
    board.set(1, 8, 6);

    board.set(2, 1, 3);
    board.set(2, 4, 6);
    board.set(2, 7, 7);

    board.set(3, 2, 1);
    board.set(3, 6, 6);

    board.set(4, 0, 5);
    board.set(4, 1, 4);
    board.set(4, 7, 1);
    board.set(4, 8, 9);

    board.set(5, 2, 2);
    board.set(5, 6, 7);

    board.set(6, 1, 9);
    board.set(6, 4, 3);
    board.set(6, 7, 8);

    board.set(7, 0, 2);
    board.set(7, 3, 8);
    board.set(7, 5, 4);
    board.set(7, 8, 7);

    board.set(8, 1, 1);
    board.set(8, 3, 9);
    board.set(8, 5, 7);
    board.set(8, 7, 6);
  }
}
