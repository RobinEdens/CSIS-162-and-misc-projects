OBJECTS = main.o open_file.o size.o array.o compare.o prompt.o unit.o
CC = g++
EXE = prog6 


$(EXE):		$(OBJECTS)
		$(CC) -o $(EXE) $(OBJECTS)

main.o:		main.cpp main.h unit.h
		$(CC) -c main.cpp

open_file.o:	open_file.cpp open_file.h 
		$(CC) -c open_file.cpp

size.o: 	size.cpp size.h
		$(CC) -c size.cpp

array.o:	array.cpp array.h unit.h
		$(CC) -c array.cpp

compare.o:	compare.cpp compare.h unit.h
		$(CC) -c compare.cpp

prompt.o:	prompt.cpp prompt.h unit.h
		$(CC) -c prompt.cpp

unit.h:		unit.cpp unit.h
		$(CC) -c unit.cpp

clean: 
		rm -rf $(OBJECTS) $(EXE) *~

