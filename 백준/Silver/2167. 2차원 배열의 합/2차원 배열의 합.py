import sys

n, m = map(int, sys.stdin.readline().split())
li = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

k = int(sys.stdin.readline())

answer = []

for _ in range(k):
    i, j, x, y = map(int, input().split())
    cnt = 0
    for l in range(i-1, x):
        for m in range(j-1, y):
            cnt += li[l][m]
    answer.append(cnt)


for result in answer:
    print(result)