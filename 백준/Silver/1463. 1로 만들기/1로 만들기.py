num = int(input())

#최소 값 배열에 저장하는 동적프로그래밍 사용
max = 10000

#calulation 배열에서 각 인덱스 i는 숫자 i일 때의 연산 최솟값이다
calculation = [int(max)] * (num + 1)
calculation[1] = 0

for i in range(num+1):
    #연산 경우의 수 중 1번째 (3으로 나누기)
    if i % 3 == 0 :
        calculation[i] = min(calculation[i], calculation[i//3] + 1)
    #연산 경우의 수 중 2번째 (2로 나누기)
    if i % 2 == 0:
        calculation[i] = min(calculation[i], calculation[i//2] + 1)
    #연산 경우의 수 중 3번째 (-1)
    calculation[i] = min(calculation[i], calculation[i-1] + 1)

print(calculation[num])
