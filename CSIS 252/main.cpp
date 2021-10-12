/*
@Author: Robin Edens
@Filename: main.cpp
@Date Created: October 30th, 2020
@Assignment 6

This is the Main() function for Assignment 6. It makes sure that there are 
the correct amount of arguments needed to open a file, then passes the file
name to open_file() to actually open the file and start the user loop. 

Preconditions: user launched file via command line
Postconditions: If there's a command line argument, it will be passed to
	open_file to try to open a file with said argument
*/
#include <iostream>
#include <ios>
#include <fstream>
#include <string>
using namespace std;
#include "main.h"
#include "unit.h"

// Prototypes
bool open_file(string filename, ifstream& file);
void array(ifstream& file, unit units[], int MAX_SIZE);
void prompt(unit units[], int MAX_SIZE);
int size(ifstream& file);

/*
main() function:
	From main.h:
		ifstream file: file that is opened via passed filename 
	Passed into function:
		int argc: amount of command line arguments
		char *argv[]: character array that contains the string values of
			command line arguments
*/
int main(int argc, char *argv[]) {
	if (argc != 2) {cerr << "usage: " << argv[0] << " <inputfile>\n";}
	if (open_file(argv[1], file)) { 
		int array_size = size(file);
		unit units[array_size]; 
		array(file, units, array_size);
		file.close();
		prompt(units, array_size);
	}
	return 0;
}
