test_num = int(input())

for _ in range(test_num):
    li = []
    max = 1

    people = int(input())
    for i in range(people):
        s1, s2 = map(int, input().split())
        li.append([s1, s2])

    #서류심사 성적 기준 정렬
    li.sort(key = lambda x:x[0])

    #숫자가 작을수록 성적이 좋은 것
    min = li[0][1]

    for i in range(1, people):
        if li[i][1] < min:
            min = li[i][1]
            max += 1
    print(max)