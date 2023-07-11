import sys

num, total = map(int, sys.stdin.readline().split())
coins = []

max = 100000
use = [max for _ in range(total+1)]

for i in range (num):
    coins.append(int(input()))

use[0] = 0

#주어진 coin보다 total이 클 때 -> 다양한 방법이 존재
#dynamic programming을 이용해서 문풀
for coin in coins:
    for i in range(coin, total+1):
            use[i] = min(use[i], use[i-coin]+1)

if use[total] == max:
    print(-1)
else:
    print(use[total])