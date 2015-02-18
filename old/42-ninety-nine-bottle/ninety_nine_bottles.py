numbermap = {0:"zero", 1:"one", 2:"two", 3:"three", 4:"four", 5:"five", 6:"six", 7:"seven", 8:"eight", 9:"nine", 10:"ten", 11: "eleven", 12: "twelve", 13: "thirteen", 14: "fourteen", 15: "fifeteen", 16: "sixteen", 17: "seventeen", 18:"eighteen", 19: "nineteen", 20: "twenty", 30: "thirty", 40: "fourty", 50: "fifty", 60:"sixty", 70: "seventy", 80:"eighty", 90:"ninety"} 

def numbertoword(num):
    numword = ''
    if num < 21 and num > -1:
        numword = numbermap[num];
    elif num < 100 and num > 20:
        try:
            numword = numbermap[num]
        except KeyError:
            ones = num % 10
            tens = (num // 10) * 10
            numword = "{0} {1}".format(numbermap[tens], numbermap[ones])
    else:
        numword = "Not a valid number"
        
    return numword


lyrics = '{0} bottles of beer on the wall, {0} bottles of beer.Take one down, pass it around'

for i in range (99, 0, -1):
    n = numbertoword(i)
    print(lyrics.format(n))

lyrics_after = 'No more bottles of beer on the wall, no more bottles of beer.'
print(lyrics_after)

