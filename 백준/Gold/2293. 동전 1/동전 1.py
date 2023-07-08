num, total = map(int, input().split())
coins = []
use = [0 for _ in range(total+1)]

for i in range (num):
    coins.append(int(input()))

#주어진 coin과 total이 같을 때
use[0] = 1

#주어진 coin보다 total이 클 때 -> 다양한 방법이 존재
#dynamic programming을 이용해서 문풀
for coin in coins:
    for i in range(1, total+1):
        if i - coin >= 0:
            use[i] += use[i - coin]

print(use[total])