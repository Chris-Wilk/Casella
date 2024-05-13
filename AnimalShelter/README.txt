Assignment 05 AnimalShelter Class
Creates the AnimalShelter to take Animals and add them to the AnimalShelter array
@author Chris Wilk
@date: 26 September 2023
@assignment CIS 203, Assignment 05, Fall 2023

I was tasked to create a class called AnimalShelter that would take animal objects and add them to the AnimalShelter class. Allong with this the class had to have a shelter name, the number of animals in the shelter, the ability to add or remove animals to the shelter.

 Compile:
 javac AnimalShelter.java
 javac AnimalShelterDriver.java
 Run:
 java AnimalShelterDriver animalInfoA.txt

Tests:

Run with animalInfoa.txt: java AnimalShelterDriver animalInfoA.txt
Expected output: 
11
2015: 1
2016: 0
...
Birds: 2; Cats: 1; Dogs: 1; Other: 7
ALL RESCUES:
 Animal Type  Name        Sex        Age     Rescue Year 
 -----------  -----       ---        ---     ----------- 
 bird         Morpheus     M         1.4        2021 
 dog          Inky         M         5.6        2020 
 bear         Podrick      M         6.1        2019 
...

SUMMARY BY CATEGORY: 
 Type   Number Rescues 
 ----   -------------- 
 Birds       2          
 Cats        1          
 Dogs        1          
 Other*      7          

*Includes: bear, fish, leopard, snake, gerbil

SUMMARY TOTALS
Number of rescues: 11
Year range: 2015 - 2023
Awesome AnimalShelter, 11 rescues.

Actual:
11
2015: 1
2016: 0
...
Birds: 2; Cats: 1; Dogs: 1; Other: 7
ALL RESCUES:
 Animal Type  Name        Sex        Age     Rescue Year 
 -----------  -----       ---        ---     ----------- 
 bird         Morpheus     M         1.4        2021 
 dog          Inky         M         5.6        2020 
 bear         Podrick      M         6.1        2019 
...

SUMMARY BY CATEGORY: 
 Type   Number Rescues 
 ----   -------------- 
 Birds       2          
 Cats        1          
 Dogs        1          
 Other*      7          

*Includes: bear, fish, leopard, snake, gerbil

SUMMARY TOTALS
Number of rescues: 11
Year range: 2015 - 2023
Awesome AnimalShelter, 11 rescues.

Run with animalInfoa.txt: java AnimalShelterDriver animalInfo.txt
Expected output:
FileNotFound

Acutal:
FileNotFound


I am unable to get deleteAnimal to work at this time.
