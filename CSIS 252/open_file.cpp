/*
@Author: Robin Edens
@Filename: open_file.cpp
@Date Created: October 30th, 2020
@Class: CSIS 252
@Assignment 6 

This file contains the Open_file() function which takes the name of a file passed
to the program via command line arguments, then attempts to open a file of that 
name. If the file opens without issue, the program continues, and if not, an
error is given to the user letting them know it cannot be opened

Preconditions: A valid filename was passed to the program via command line
Postconditions: the file is opened and main is informed the file is valid
*/
#include <iostream>
#include <fstream>
using namespace std;
#include "open_file.h"

/*
open_file() function:
	From open_file.h: 
		bool has_file: determines whether or not file can be read
	Passed into function:
		string filename: filename passed via command line
		bool has_file: whether or not file was able to be opened
	Return: returns has_file
*/
bool open_file(string filename, ifstream& file) {
	file.open(filename);
	if (file.fail()) {
		cerr << "Unable to read input file: '" << filename << endl;
		has_file = false;
		file.close();
	} else {
		has_file = true;
	}
	return has_file;
}
