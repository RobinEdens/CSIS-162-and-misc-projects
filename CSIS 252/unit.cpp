/*
@Author: Robin Edens
@Filename: unit.cpp
@Date Created: October 30th 2020
@Class CSIS 252
@Assignment 5

This file contains the unit class which is an asbtraction of a storage unit. 
It follows up from Assignment 1 and 2 as holding both the unit type (storage), 
the name of the unit (unit), and a container to measure the size of the unit 
(amount of storage) as the size attribute. Getters and setters are included,
alongside overloaded operators for comparing the size of the unit. 

As this is a hybrid between Assignment 4 and Assignment 5, it is crafted as 
a parent class to what the class in Assignment 5 was, to allow setters for
the name and type.

A method for comparing the type is included as well for use in Assignment 7
*/

#include "unit.h"
#include <string>
#include <iostream>
using namespace std;

ostream& operator << (ostream& o, const unit& g) {
	o << g.getSize();
	return o;
}
istream& operator >> (istream& input, unit& g) {
	string tmp;
	getline(input, tmp);
	g.setSize(stod(tmp));
	return input;
}

unit::unit(string name, string type, double size) { 
	setName(name);
	setType(type);
	setSize(size);
}

unit::unit(unit& clone) {
	setName(clone.getName());
	setType(clone.getType());
	setSize(clone.getSize());
}

void unit::setName(string n) {
	name = n;
}

string unit::getName() const {
	return name;
}

void unit::setType(string t) {

	type = t;
}
string unit::getType() const {
	return type;
}

void unit::setSize(double s) {
	size = s;
}

double unit::getSize() const {
	return size;
}

bool unit::operator < (const unit& u) const {
	return getSize() < u.getSize();
}

bool unit::operator > (const unit& u) const {
	return getSize() > u.getSize();
}

bool unit::operator <= (const unit& u) const {
	return getSize() <= u.getSize();
}

bool unit::operator >= (const unit& u) const {
	return getSize() >= u.getSize();
}

bool unit::operator == (const unit& u) const {
	return getSize() == u.getSize();
}

bool unit::operator != (const unit& u) const {
	return getSize() != u.getSize();
}

bool unit::typeEquals(const unit& u) const {
	return getType() == u.getType();
}
