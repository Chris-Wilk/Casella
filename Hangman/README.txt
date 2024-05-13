  Assignment 03 Arrays Review 2
  @author Chris Wilk
  @date: 14 September 2023
  @assignment CIS 203, Assignment 02, Fall 2023
 
 I was taxed to create a program that would play hangeman based of four text files provided. The
 program had to take the file from the user along with each guess. If the guess was correct the 
 program would display this and ask for the new guess. If the guess was incorrect with program 
 would display all incorrect guesses and ask for a new one. If you ran out of guesses the program
 would end saying you lost. If you guessed the word without running out of incorrect guesses the
 program would end saying you won. Whenever the game ended the program would ask the user if they
 wanted to play again.
 
 Compile:
 javac Hangman.java
 Run:
 java Hangman

Tests: 
input: (anything but a file). Expected: io error. Actual: correct.
input: 1. Expected: input one character that is not a number Actual: correct.
input: ha. Expected: input one character that is not a number Actual: correct.
input: 1a. Expected: input one character that is not a number Actual: correct.
input: (the correct word). Expected: You won the word was (word) Actual: correct.

Many times throughout the program I would hard code the word or the size of an array to make sure
that was not the issue throwing errors. 

I have made this in Notepad on my local machine and it still gives the error in git about invisable
unicode characters. 