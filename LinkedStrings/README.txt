 Assignment 07 Linked Strings
 Creates a class to imitate java's String method by taking chars and putting them into
 a linked list.
 @author Chris Wilk
 @date: 19 October 2023
 @assignment CIS 203, Assignment 07, Fall 2023

I am tasked with creating a class will act as the java String method taking chars and adding them to a list. It will be able to add items to the list at the end, find items at an index, find the lenght of the list, see if two lists are equal, and print the items of the list as a String.

Compile:
 javac LinkedString.java
 Run:
 java SimpleArrayListClient moreLines.txt

Tests
Test ran with moreLines.txt

Expected:
8 lines read from moreLines.txt
  hop on pop pop on hop : poh no pop pop no poh 
  hop on pop pop no poh : hop on pop pop no poh PALINDROME
  543212345 : 543212345 PALINDROME
...

Actual:
8 lines read from moreLines.txt
  hop on pop pop on hop : poh no pop pop no poh 
  hop on pop pop no poh : hop on pop pop no poh PALINDROME
  543212345 : 543212345 PALINDROME
...


Test ran with someLines.txt:

Expected:
 lines read from someLines.txt
  A man, a plan, a canal, panama. : .amanap ,lanac a ,nalp a ,nam A 
  amanaplanacanalpanama : amanaplanacanalpanama PALINDROME
  one fish two fish red fish blue fish : hsif eulb hsif der hsif owt hsif eno
...

Actual: 
 lines read from someLines.txt
  A man, a plan, a canal, panama. : .amanap ,lanac a ,nalp a ,nam A 
  amanaplanacanalpanama : amanaplanacanalpanama PALINDROME
  one fish two fish red fish blue fish : hsif eulb hsif der hsif owt hsif eno
...


Test ran with incorrect file name:

Expected:
Unable to open/read input file someLnes.txt

Actual:
Unable to open/read input file someLnes.txt
