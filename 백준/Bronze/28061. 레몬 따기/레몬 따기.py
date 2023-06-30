import sys

num = sys.stdin.readline()
place = sys.stdin.readline().split()
place = list(map(int, place))

home = len(place)

lemon = []
for i in range(home):
    lemon.append(place[i] - home + i)

print(max(lemon))