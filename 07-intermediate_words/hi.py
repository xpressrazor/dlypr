# Written by http://www.reddit.com/user/Cosmologicon

words = set(map(str.strip, open("enable1.txt")))
def score(w):
    return sum(w[i:j] in words for i in range(len(w)-1) for j in range(i+2, len(w)+1))
print(max(words, key=score))
