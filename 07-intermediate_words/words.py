#!/usr/bin/python2
import sys

# Not a good solution

f = open("enable1.txt")
lines = f.readlines()

most_found = "";
most_found_times = 0;

for line in lines:
    linec = line.strip('\n');    
    row_found = 0;   
    #print(linec)
    
    for indvlline in lines: 
        indvllinec = indvlline.strip('\n')        
        if(indvllinec in linec ):            
            row_found += 1;                     
    
    if (row_found > most_found_times):
        most_found = linec;
        most_found_times = row_found;
        
        print(linec)
        mystr = " Found: " + str(row_found) + " times";    
        print(mystr);
    
    

print("Most found: " + most_found + " " + str(most_found_times));
    
        
        
