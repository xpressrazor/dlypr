#!/usr/bin/python

from sys import argv
from functools import reduce
import re, operator

if len(argv) != 2:
    print("Usage: ./matching_bracket.py <file_name>")
    exit(-1);

# E.g., Content of file_name
#
#3
#^:right
#/:left
#-:left
#3-11/3-3^4-1
#
# Assuming line 0 contains number of symbols.
# Next number of symbols line contain symbols and left or right
# After the symbols, contains the input string that is to be parsed (for now only one line)
file = open(argv[1])
lines = file.read().splitlines()
file.close()

numberofsymbols = int(lines[0])
inputstr = lines[numberofsymbols + 1]

symbols = []
for i in range(1, numberofsymbols + 1):
    symbols.append(lines[i][0])

symbolreg = ''
for s in symbols:
    if s == '^' or s == '/':
        symbolreg = "{0}{1}{2}".format(symbolreg, "\\", s)
    else:
        symbolreg = "{0}{1}".format(symbolreg, s)

numberlist = re.findall(r'(\d+|\(.*\))', inputstr)

symtmpstr = inputstr
symtmplist = re.findall(r'\(.*\)', inputstr)
for x in symtmplist:    
    symtmpstr = symtmpstr.replace(x,'')

symbollist = re.findall(r'[{0}]'.format(symbolreg), symtmpstr)
numbersymbolcomblist = list(reduce(operator.add, zip(numberlist, symbollist)))
numbersymbolcomblist.append(numberlist[-1])

def isleft(symbolstr):
    symbolstrlist = symbolstr.split(':')
    if symbolstrlist[1] == 'left': return True
    else: return False

def numberofoccurances(inlist, symbol):
    inliststr = ''.join(inlist)
    newlist = re.findall(r'(\(.*\))',inliststr)
    if (len(newlist) > 0):
        inliststr.replace(newlist[0], '')    
    verynewlist = [i for i in inliststr]    
    return verynewlist.count(symbol)

for i in range (0, numberofsymbols):
    replacestr = ''
    lensymbolcomblist = 0

    for k in range(0, numberofoccurances(numbersymbolcomblist, symbols[i])):    
        if isleft(lines[i + 1]):        
            lensymbolcomblist = len(numbersymbolcomblist)
            j = 0
            while j < lensymbolcomblist:        
                if (numbersymbolcomblist[j] == symbols[i]):                
                    replacestr = '({0}{1}{2})'.format(numbersymbolcomblist[j - 1],
                                                      numbersymbolcomblist[j],
                                                      numbersymbolcomblist[j + 1])
                    numbersymbolcomblist[j - 1] = replacestr
                    numbersymbolcomblist.pop(j)
                    numbersymbolcomblist.pop(j)                
                    lensymbolcomblist = lensymbolcomblist - 2
                    break
                j = j + 1                
                    
        elif isleft(lines[i + 1]) == False:        
            revlist = reversed(numbersymbolcomblist)
            revlist = list(revlist)
            lensymbolcomblist = len(revlist)        
            j = 0
            while j < lensymbolcomblist:
                if (revlist[j] == symbols[i]):                
                    replacestr = '({0}{1}{2})'.format(revlist[j + 1],
                                                      revlist[j],
                                                      revlist[j - 1])
                    revlist[j - 1] = replacestr
                    revlist.pop(j)
                    revlist.pop(j)
                    numbersymbolcomblist = list(reversed(revlist))                                
                    lensymbolcomblist = lensymbolcomblist - 2
                    break
                j = j + 1        
            
print(''.join(numbersymbolcomblist))
