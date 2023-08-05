#최대공약수 구하기
def gcd(a, b):
    while b != 0:
        a, b = b, a % b
    return a

A, B = map(int, input().split())
X, Y = map(int, input().split())

#A/B, X/Y
Up = A*Y + B*X
Down = B*Y

#분자와 분모의 최대공약수 구해서 나누면 기약분수
K = gcd(Up, Down)

print(Up//K, Down//K)