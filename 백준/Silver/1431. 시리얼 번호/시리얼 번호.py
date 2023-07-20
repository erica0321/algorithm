n = int(input())

li = []

for i in range(n):
    serial = input()
    li.append(serial)

def num_sum(k):
    total = 0
    for i in k:
        if i.isdigit():
            total += int(i)
    return total   

#1번째로 문장 길이, 2번째로 숫자 합, 3번째로 사전 순으로 정렬하는 기준 넣기
li.sort(key = lambda x:(len(x), num_sum(x) , x))

for i in li:
    print(i)