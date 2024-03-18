n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

#a 작은 수 부터 정렬
a.sort()

#정답
answer = 0

for i in range(n):
  #a 배열에서 가장 작은 수, b 배열에서 가장 큰 수를 곱해서 더하기
  b_max =  max(b)
  answer += a[i] * b_max
  b.remove(b_max)

print(answer)