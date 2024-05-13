 Assignment 11
 Creating a Sudoku board
 @author Chris Wilk
 @date: 26 November 2023
 @assignment CIS 203, Assignment 11, Fall 2023

Design Choice #1:
Since the data stored in the class has to be able to hold any single decimal digit the only two options I can think of for the data type would be a string or a double. If I were to do a string that would allow the user to enter decimal digits and can be stored in the arrays but for every entry the program would have to check to make sure the user entered a number instead of a random character. If I were to use a double I can make sure the user enters a number very easily but the program would always have two digits in the numbers for the board.

Design Choice #2:
The two options for storing the collection of the eighty-one cells are either a two dimensional array or an ArrayList. The two dimensional array is efficient and simple. It will be able to hold all cells easily and will be easy to navigate. The disadvantages are that the two dimensional array has a lack of flexibility and will be more concrete. The ArrayList will be very flexible and allow me to manipulate the game in any way but it will be more demanding on the machine and it will be a much more complex program. 

Design Choice #3:
In my code I have a helper function to check to see if there is a value to put into the board or not. I did this because I felt it would not only make the code look cleaner and more readable but it would also be easier. Instead of having to check in the if statement the checking is done outside of the statement. 

Design Choice #4:
The stillValid method would return false when a duplicate number is present in any of the rows, columns, or 3x3 grids. The best way to break this method up would be to have three methods. Each to check for one of the three ways the game can be incorrect. A method for the rows, a method for the columns, and a method for the squares. 

Design Choice #5:
If you were given the coordinates of a square’s upper left (0, 0) and lower right (3, 3) then you can use a nested if statement to move across every cell in that square. The first if statement would count up to 3 moving along the columns and the second if statement would move along the rows. This would allow you to check every cell's elements.

Design Choice #6:
If someone who had infinite patience played sudoku without any logic they would start by filling out one element of the board whether it is the rows, columns, or squares and change the individual element if it comes to an invalid solution. My mind and hands hurt just thinking of trying to solve sudoku like this.


Compile:
javac SudokuBoard.java
Run:
SudokuBoard easy.txt

Tests:
Ran with easy.txt:
Expected: 
Initial Board Configuration
+---+---+---+---+---+---+---+---+---+
| 6 |   |   | 3 |   |   |   | 8 | 7 |
+---+---+---+---+---+---+---+---+---+
|   |   | 8 |   |   | 6 |   | 3 |   |
+---+---+---+---+---+---+---+---+---+
|   | 3 |   |   | 8 |   | 4 | 5 |   |
+---+---+---+---+---+---+---+---+---+
| 7 |   |   |   |   | 4 | 5 | 2 |   |
+---+---+---+---+---+---+---+---+---+
| 2 | 8 | 4 |   |   |   | 3 |   | 9 |
+---+---+---+---+---+---+---+---+---+
|   |   | 5 | 8 | 2 |   | 1 |   |   |
+---+---+---+---+---+---+---+---+---+
|   |   | 7 |   | 1 |   |   | 9 | 2 |
+---+---+---+---+---+---+---+---+---+
| 8 | 5 |   |   |   | 2 |   |   | 3 |
+---+---+---+---+---+---+---+---+---+
|   |   |   | 4 | 7 | 8 | 6 |   | 5 |
+---+---+---+---+---+---+---+---+---+

Attempting to Solve
Sudoku Solution:
+---+---+---+---+---+---+---+---+---+
| 6 | 4 | 9 | 3 | 5 | 1 | 2 | 8 | 7 |
+---+---+---+---+---+---+---+---+---+
| 5 | 7 | 8 | 2 | 4 | 6 | 9 | 3 | 1 |
+---+---+---+---+---+---+---+---+---+
| 1 | 3 | 2 | 7 | 8 | 9 | 4 | 5 | 6 |
+---+---+---+---+---+---+---+---+---+
| 7 | 1 | 6 | 9 | 3 | 4 | 5 | 2 | 8 |
+---+---+---+---+---+---+---+---+---+
| 2 | 8 | 4 | 1 | 6 | 5 | 3 | 7 | 9 |
+---+---+---+---+---+---+---+---+---+
| 3 | 9 | 5 | 8 | 2 | 7 | 1 | 6 | 4 |
+---+---+---+---+---+---+---+---+---+
| 4 | 6 | 7 | 5 | 1 | 3 | 8 | 9 | 2 |
+---+---+---+---+---+---+---+---+---+
| 8 | 5 | 1 | 6 | 9 | 2 | 7 | 4 | 3 |
+---+---+---+---+---+---+---+---+---+
| 9 | 2 | 3 | 4 | 7 | 8 | 6 | 1 | 5 |
+---+---+---+---+---+---+---+---+---+

Actual:
Initial Board Configuration
+---+---+---+---+---+---+---+---+---+
| 6 |   |   | 3 |   |   |   | 8 | 7 |
+---+---+---+---+---+---+---+---+---+
|   |   | 8 |   |   | 6 |   | 3 |   |
+---+---+---+---+---+---+---+---+---+
|   | 3 |   |   | 8 |   | 4 | 5 |   |
+---+---+---+---+---+---+---+---+---+
| 7 |   |   |   |   | 4 | 5 | 2 |   |
+---+---+---+---+---+---+---+---+---+
| 2 | 8 | 4 |   |   |   | 3 |   | 9 |
+---+---+---+---+---+---+---+---+---+
|   |   | 5 | 8 | 2 |   | 1 |   |   |
+---+---+---+---+---+---+---+---+---+
|   |   | 7 |   | 1 |   |   | 9 | 2 |
+---+---+---+---+---+---+---+---+---+
| 8 | 5 |   |   |   | 2 |   |   | 3 |
+---+---+---+---+---+---+---+---+---+
|   |   |   | 4 | 7 | 8 | 6 |   | 5 |
+---+---+---+---+---+---+---+---+---+

Attempting to Solve
Sudoku Solution:
+---+---+---+---+---+---+---+---+---+
| 6 | 4 | 9 | 3 | 5 | 1 | 2 | 8 | 7 |
+---+---+---+---+---+---+---+---+---+
| 5 | 7 | 8 | 2 | 4 | 6 | 9 | 3 | 1 |
+---+---+---+---+---+---+---+---+---+
| 1 | 3 | 2 | 7 | 8 | 9 | 4 | 5 | 6 |
+---+---+---+---+---+---+---+---+---+
| 7 | 1 | 6 | 9 | 3 | 4 | 5 | 2 | 8 |
+---+---+---+---+---+---+---+---+---+
| 2 | 8 | 4 | 1 | 6 | 5 | 3 | 7 | 9 |
+---+---+---+---+---+---+---+---+---+
| 3 | 9 | 5 | 8 | 2 | 7 | 1 | 6 | 4 |
+---+---+---+---+---+---+---+---+---+
| 4 | 6 | 7 | 5 | 1 | 3 | 8 | 9 | 2 |
+---+---+---+---+---+---+---+---+---+
| 8 | 5 | 1 | 6 | 9 | 2 | 7 | 4 | 3 |
+---+---+---+---+---+---+---+---+---+
| 9 | 2 | 3 | 4 | 7 | 8 | 6 | 1 | 5 |
+---+---+---+---+---+---+---+---+---+



Test ran with cannotBeSolved.txt:
Expected:

Initial Board Configuration
+---+---+---+---+---+---+---+---+---+
| 2 | 5 |   |   | 3 |   | 9 |   | 1 |
+---+---+---+---+---+---+---+---+---+
|   |   |   |   |   | 4 |   |   |   |
+---+---+---+---+---+---+---+---+---+
| 4 |   | 7 |   |   |   | 2 |   | 8 |
+---+---+---+---+---+---+---+---+---+
|   |   | 5 | 2 |   |   |   |   |   |
+---+---+---+---+---+---+---+---+---+
|   | 2 |   |   | 9 | 8 | 1 |   |   |
+---+---+---+---+---+---+---+---+---+
|   | 4 |   |   |   | 3 |   |   |   |
+---+---+---+---+---+---+---+---+---+
|   |   |   | 3 | 6 |   |   | 7 | 2 |
+---+---+---+---+---+---+---+---+---+
|   | 7 |   |   |   |   |   |   | 3 |
+---+---+---+---+---+---+---+---+---+
| 9 | 1 | 3 | 5 | 8 | 7 | 6 |   | 4 |
+---+---+---+---+---+---+---+---+---+

Attempting to Solve
Attempt to solve failed.

Actual:
Initial Board Configuration
+---+---+---+---+---+---+---+---+---+
| 2 | 5 |   |   | 3 |   | 9 |   | 1 |
+---+---+---+---+---+---+---+---+---+
|   |   |   |   |   | 4 |   |   |   |
+---+---+---+---+---+---+---+---+---+
| 4 |   | 7 |   |   |   | 2 |   | 8 |
+---+---+---+---+---+---+---+---+---+
|   |   | 5 | 2 |   |   |   |   |   |
+---+---+---+---+---+---+---+---+---+
|   | 2 |   |   | 9 | 8 | 1 |   |   |
+---+---+---+---+---+---+---+---+---+
|   | 4 |   |   |   | 3 |   |   |   |
+---+---+---+---+---+---+---+---+---+
|   |   |   | 3 | 6 |   |   | 7 | 2 |
+---+---+---+---+---+---+---+---+---+
|   | 7 |   |   |   |   |   |   | 3 |
+---+---+---+---+---+---+---+---+---+
| 9 | 1 | 3 | 5 | 8 | 7 | 6 |   | 4 |
+---+---+---+---+---+---+---+---+---+

Attempting to Solve
Attempt to solve failed.

Test ran with invalidSquare.txt:
Expected:

Initial Board Configuration
+---+---+---+---+---+---+---+---+---+
| 2 | 5 |   |   | 3 |   | 9 |   | 1 |
+---+---+---+---+---+---+---+---+---+
|   | 1 |   |   |   | 4 |   |   |   |
+---+---+---+---+---+---+---+---+---+
| 4 |   | 7 |   |   |   | 2 |   | 8 |
+---+---+---+---+---+---+---+---+---+
|   |   | 5 | 2 |   |   |   |   |   |
+---+---+---+---+---+---+---+---+---+
|   |   |   |   | 9 | 8 | 1 |   |   |
+---+---+---+---+---+---+---+---+---+
|   | 4 | 2 |   | 5 | 3 |   |   |   |
+---+---+---+---+---+---+---+---+---+
|   |   |   | 3 | 6 |   |   | 7 | 2 |
+---+---+---+---+---+---+---+---+---+
|   | 7 |   |   |   |   |   |   | 3 |
+---+---+---+---+---+---+---+---+---+
| 9 |   | 3 |   |   |   | 6 |   | 4 |
+---+---+---+---+---+---+---+---+---+

Attempting to Solve
Attempt to solve failed.

Actual:
Initial Board Configuration
+---+---+---+---+---+---+---+---+---+
| 2 | 5 |   |   | 3 |   | 9 |   | 1 |
+---+---+---+---+---+---+---+---+---+
|   | 1 |   |   |   | 4 |   |   |   |
+---+---+---+---+---+---+---+---+---+
| 4 |   | 7 |   |   |   | 2 |   | 8 |
+---+---+---+---+---+---+---+---+---+
|   |   | 5 | 2 |   |   |   |   |   |
+---+---+---+---+---+---+---+---+---+
|   |   |   |   | 9 | 8 | 1 |   |   |
+---+---+---+---+---+---+---+---+---+
|   | 4 | 2 |   | 5 | 3 |   |   |   |
+---+---+---+---+---+---+---+---+---+
|   |   |   | 3 | 6 |   |   | 7 | 2 |
+---+---+---+---+---+---+---+---+---+
|   | 7 |   |   |   |   |   |   | 3 |
+---+---+---+---+---+---+---+---+---+
| 9 |   | 3 |   |   |   | 6 |   | 4 |
+---+---+---+---+---+---+---+---+---+

Attempting to Solve
Attempt to solve failed.

Test ran with invalidColumn.txt:
Expected:

Initial Board Configuration
+---+---+---+---+---+---+---+---+---+
| 6 |   |   | 3 |   |   |   | 8 | 7 |
+---+---+---+---+---+---+---+---+---+
|   |   | 8 |   |   | 6 |   | 3 |   |
+---+---+---+---+---+---+---+---+---+
|   | 3 |   |   | 8 |   | 4 | 5 |   |
+---+---+---+---+---+---+---+---+---+
| 7 |   |   |   | 2 | 4 | 5 |   |   |
+---+---+---+---+---+---+---+---+---+
| 2 | 8 | 4 |   |   |   | 3 |   | 9 |
+---+---+---+---+---+---+---+---+---+
|   |   | 5 | 8 | 2 |   | 1 |   |   |
+---+---+---+---+---+---+---+---+---+
|   |   | 7 |   | 1 |   |   | 9 | 2 |
+---+---+---+---+---+---+---+---+---+
| 8 | 5 | 8 |   |   | 2 |   |   | 3 |
+---+---+---+---+---+---+---+---+---+
|   |   |   | 4 | 7 | 8 | 6 |   | 5 |
+---+---+---+---+---+---+---+---+---+

Initial configuration is not even vallid.
Will not attempt to solve.

Actual:
Initial Board Configuration
+---+---+---+---+---+---+---+---+---+
| 6 |   |   | 3 |   |   |   | 8 | 7 |
+---+---+---+---+---+---+---+---+---+
|   |   | 8 |   |   | 6 |   | 3 |   |
+---+---+---+---+---+---+---+---+---+
|   | 3 |   |   | 8 |   | 4 | 5 |   |
+---+---+---+---+---+---+---+---+---+
| 7 |   |   |   | 2 | 4 | 5 |   |   |
+---+---+---+---+---+---+---+---+---+
| 2 | 8 | 4 |   |   |   | 3 |   | 9 |
+---+---+---+---+---+---+---+---+---+
|   |   | 5 | 8 | 2 |   | 1 |   |   |
+---+---+---+---+---+---+---+---+---+
|   |   | 7 |   | 1 |   |   | 9 | 2 |
+---+---+---+---+---+---+---+---+---+
| 8 | 5 | 8 |   |   | 2 |   |   | 3 |
+---+---+---+---+---+---+---+---+---+
|   |   |   | 4 | 7 | 8 | 6 |   | 5 |
+---+---+---+---+---+---+---+---+---+

Initial configuration is not even vallid.
Will not attempt to solve.

Test ran with invalid name (none.txt):
Expected: 
File not found: none.txt

Actual:
File not found: none.txt
