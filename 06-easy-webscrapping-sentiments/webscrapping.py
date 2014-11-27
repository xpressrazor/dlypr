#!/usr/bin/python2
import sys
import urllib2, re
from BeautifulSoup import BeautifulSoup   

print sys.argv[1]

#url = "https://www.youtube.com/all_comments?v=QWW9D2d-M8E"
url = sys.argv[1]
page = urllib2.urlopen(url)
soup = BeautifulSoup(page)
all_comments = soup.findAll('div', attrs={'class':'comment-text-content'})

happy = ['love','loved','like','liked','awesome','amazing','good','great','excellent']
sad = ['hate','hated','dislike','disliked','awful','terrible','bad','painful','worst']

happy_count = 0
sad_count = 0

print ("From a sample size of" + str(len(all_comments)) + " Persons")
for row in all_comments:
    happy_row = 0
    sad_row = 0

    for h in happy:		
        happy_row += row.text.count(h);
	
    for s in sad:
        sad_row += row.text.count(s);

    print ("This sentence: " + row.text + " is mostly ");

    if (sad_row > happy_row):
        print("Sad");
    elif (happy_row > sad_row):
        print("Happy");
    else:
        print("Balanced");
        
    print(" It contained " + str(happy_row) + " amount of happy keywoards and " + str(sad_row) + " amount of sad keywords");	    
    	
    happy_count += happy_row;
    sad_count += sad_row;

print("The general feelings towards this video were ");

if (happy_count > sad_count):
    print("Happy");
elif (sad_count > happy_count):
    print("Sad");
else:
    print("Normal");
