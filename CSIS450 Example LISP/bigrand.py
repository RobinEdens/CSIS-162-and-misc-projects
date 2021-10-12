import random

file = open("bignum.txt", "w")
for x in range(20000000):
	file.write(str(random.randint(1, 100000000)))
	file.write("\n")
	
file.close()