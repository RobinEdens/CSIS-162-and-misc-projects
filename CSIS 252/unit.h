/*
@Author: Robin Edens
@Filename: size.h
@Date Created: October 30th, 2020
@Assignment 6

Header file that countains the unit class, which is used to hold the variables
thaht store both the name, type, and size of a unit, allowing it to be used as
a parent class to store any unit akin to how it was done in Assignment 2-4


*/
#ifndef _UNIT_H_
#define _UNIT_H_

#include <iostream>
#include <string>
using namespace std;

class unit {

	public:
		unit(
			string name = "undefined", 
			string type = "undefined", 
			double size = 0
		);

		unit(unit& clone);
		void setName(string);
		string getName() const;
		void setType(string);
		string getType() const;
		void setSize(double);
		double getSize() const;

		bool typeEquals(const unit&) const;

		bool operator < (const unit&) const;
		bool operator > (const unit&) const;
		bool operator <= (const unit&) const;
		bool operator >= (const unit&) const;
		bool operator == (const unit&) const;
		bool operator != (const unit&) const;



	private: 
		string name;
		string type;
		double size;
};

ostream& operator << (ostream&, const unit&);
istream& operator >> (istream&, unit&);

#endif
