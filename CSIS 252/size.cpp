/*
@Author: Robin Edens
@Filename: size.cpp
@Date Created: October 30th, 2020
@Assignment 6 

This is the size() function used to determine the size of whatever file is passed
to the program via the command line. This is used to determine the MAX_SIZE int
that is passed between the majority of functions throughout, since I was unable
to get a function to calculate a const int that would be useable in a .h file
since it cannot be declared until after runtime.

*/
#include <fstream>
#include <ios>
#include <iostream>
#include <string>
using namespace std;
#include "size.h"

/*
size() function:
	From size.h: 
		int length: iterator for checking how many lines are in file
		string line: temp value that holds whatever the current line
			of the file stores
	Passed into function:
		ifstream file: pass-by-reference of the ifstream file that is
			being checked for amount of lines
	Return: returns length, which determines the MAX_SIZE of the array


*/
int size(ifstream& file) {
	length = 0;
	while (getline(file, line)) {
		length++;
	}
	file.clear();
	file.seekg(0);
	return length;
}
