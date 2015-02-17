#!/usr/bin/python
from sys import argv

if len(argv) != 2:
    print("./<prog_name> <input-file>")
    exit(-1)

file = open(argv[1])
file_lines = file.read().splitlines()
file.close()

myinput = ''
for line in file_lines: myinput += line

formatted_str = ''.join([chr(int(myinput[i:i+8], 2)) for i in range(0, len(myinput), 8)])
print(formatted_str)
