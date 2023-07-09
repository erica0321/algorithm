import sys

test_num, length = map(int, sys.stdin.readline().split())

number = 0
cover = 0

hole = []

for i in range (test_num):
    start, end = map(int, sys.stdin.readline().split())
    hole.append([start, end])

hole.sort(key=lambda x:x[0])

for start, end in hole:
    #다른 웅덩이를 덮인 널빤지가 해당 웅덩이도 덮은 경우
    if start > end:
        continue

    #다른 웅덩이의 널빤지가 다른 웅덩이와 겹칠 때
    if cover > start:
        start = cover


    while start < end:
        start += length
        number += 1

    cover = start

print(number)