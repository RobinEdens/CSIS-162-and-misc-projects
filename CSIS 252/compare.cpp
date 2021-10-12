/*
@Author: Robin Edens
@Filename: compare.cpp
@Date Created: October 30th, 2020
@Class; CSIS 252
@Assignment 6

This file contains the compare() function which will take two names of measurement
provided by the user, and using a For loop, will iterate and check to see if those
two values are within the provided input file passed by the user. If both of the
user units are within the array, the types of both are checked to see if the two
are the same type. If both are the same type, the user is told that they can be
converted between. If they are not the same type, the user is told they are not 
compatible. If one or both of the units are not found in the array, the user
is given an error stating the value is not able to be checked.

Preconditions: File was able to be read and parsed into an array of unit objects
User has passed two units to check that passed any error checking in the prompt()
function.
Postcondition: User will know if the two units passed can be converted between, or
will be notified of any errors if values are invalid.
*/

#include <iostream>
#include <string>
using namespace std;

#include "compare.h"
#include "unit.h"
/*
compare() function:
Variables in function:
	From compare.h: 
		int first_index: index of first unit if found in array
		int second_index: index of second unit if found in array
		bool has_first: bool stating if first user input is in array
		bool has_second: bool stating if second user input is in array
	Passed into function:
		unit units[]: Unit array holding all unit that can be compared
		string first: first word parsed by user
		string second: second unit inputed by user
		int MAX_SIZE: max size of array

*/
void compare(unit units[], string first, string second, int MAX_SIZE) {
	// Checks if first and second values are in the array
	for (int i = 0; i < MAX_SIZE; i++) { 
		if (units[i].getName() == first) {
			has_first = true;
			first_index = i;
		}
		if (units[i].getName() == second) {
			has_second = true;
			second_index = i;
		}

	}

	if (has_first && has_second) {
		// Print if both values are able to be converted between
		if (units[first_index].getType() == units[second_index].getType()) {
			cout << "Both " << first << " and " << second 
				<< " are able to be converted since they are both of type " 
				<< units[first_index].getType() << endl;
		// Print if values differ
		} else {
			cerr << "Unable to convert " << first << " and " << second
			<< ". " << first << " is of type " << units[first_index].getType() << " and "
			<< second << " is of type " << units[second_index].getType() << endl;
		}
	// Tells user which values not found in list
	} else {
		if (!has_first) { 
			cerr << "Value " << first << " not in list\n";
		}
		
		if (!has_second) { 
			cerr << "Value " << second << " not in list\n";
		}

		cerr << "If you are unsure what values are available, check the file you linked\n\n";
	}
	has_first = false; has_second = false;
}
