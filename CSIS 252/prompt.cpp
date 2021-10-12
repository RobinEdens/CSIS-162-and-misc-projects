/*
@Author: Robin Edens
@Filename: prompt.cpp
@Date Created: October 30th, 2020
@Class: CSIS 252
@Assignment 6

This file contains the prompt() function which will loop indefinately until the
user presses enter without entering any other input. If two words can be parsed
from the user input, the compare() method is called to see if the two units
can be compared.

Preconditions: File that user gave via command line was valid and was able to be 
parsed into an array of Units from the array() function. 
Postconditions: compare() will be called to check the two parsed units
*/

#include <iostream>
#include <string>
#include <sstream>
using namespace std;
#include "prompt.h"
#include "unit.h"

// Prototypes
void compare(unit units[], string first, string second, int MAX_SIZE);

/*
prompt() function:
	from prompt.h:
		bool user_loop: loop that runs until user hits enter without input
		string input: user input
		string first: first word in user input
		string second: second word in user input
	Passed into function:
		unit units[]: array of Unit classes
		int MAX_SIZE: max size of array
*/
void prompt(unit units[], int MAX_SIZE ) {
	while (user_loop) {
		cout << "Please enter two units you would like to compare\n"
			<< "Press enter to quit" << endl;
		getline(cin, input);
		// Only way I could get the iostream to recognize an enter press
		stringstream parse(input);
		// If users only input was a newline flag, end loop
		if (parse.peek() == -1) {
			cout << "Have a good day\n";
			user_loop = false;
		} else {
			// If user input starts with space
			if (parse.peek() == 32) {
				cerr << "Please enter values without spaces preceeding\n\n";
				continue;
			}
			parse >> first;
			// If only one value is entered
			if (parse.peek() == -1) {
				cerr << "Please enter more than one value\n\n";
				continue;
			}
			parse >> second;
			// If multiple values are entered, runs anyways
			if (parse.peek() != -1) {
				cerr << "More than 2 units entered, discarding units after "
					<< second << endl;
			}
			compare(units, first, second, MAX_SIZE);
		}
	
	}
}
