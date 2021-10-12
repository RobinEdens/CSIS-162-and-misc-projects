/*
@Author: Robin Edens
@Filename: array.cpp
@Date Created: October 30th, 2020
@Class: CSIS 252
@Assignment 6

This file contains the array() function which will take the passed file
and an array of unit classes, and will fill each index with classes of whichever
file the user passed to the program, formatted as "unitname unittype" within
the file and separated by newlines. 

Preconditions: File was able to be read
Postconditions: Array unit[] will be filled with values
*/

#include <iostream>
#include <ios>
#include <fstream>
#include <ios>
#include <string>
using namespace std;

#include "array.h"
#include "unit.h"
/*
array() function:
Variables in function:
	From array.h:
		int iterate: iterator for While loop
		string parse_word: temp string for iterating through file and
			assigning to passed arrays
	Passed into function:
		ifstream file: passed file
		units[]: array of unit classes
		int MAX_SIZE: lines in file, max size of array
*/
void array(ifstream& file, unit units[], int MAX_SIZE) {
	iterate = 0;
	file >> parse_word;
	// Populates list and increases iterator by one until eof is reached
	while (!file.eof() && iterate < MAX_SIZE) {
		units[iterate].setName(parse_word);
		file >> parse_word;
		units[iterate++].setType(parse_word);
		file >> parse_word;
	}
}
