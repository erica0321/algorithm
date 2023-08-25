import sys

n = int(sys.stdin.readline())
len = []

for _ in range(n):
    len.append(list(map(int, sys.stdin.readline().split())))

for i in range(1, n):
    len[i][0] = min(len[i-1][1], len[i-1][2]) + len[i][0]
    len[i][1] = min(len[i-1][0], len[i-1][2]) + len[i][1]
    len[i][2] = min(len[i-1][0], len[i-1][1]) + len[i][2]

print(min(len[n-1][0], len[n-1][1], len[n-1][2]))