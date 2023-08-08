import sys

N = int(sys.stdin.readline())
li = []

for _ in range(N):
    li.append(sys.stdin.readline().strip())

#중복제거
li = list(set(li))
li.sort()
li.sort(key=len)

for word in li:
    print(word)