import sys

def search(n, r, c):
    if n == 0:
        return 0
    
    size = 2**n
    half_size = size // 2
    step = half_size ** 2

    #4등분 하여 분할 정복 시작
    if r < half_size and c < half_size:             #4등분 했을 시 왼쪽 위
        return (search(n - 1, r, c)) 
    elif r < half_size and c >= half_size:          #4등분 했을 시 오른쪽 위
        return (step + search(n - 1, r, c - half_size)) 
    elif r >= half_size and c < half_size:          #4등분 했을 시 왼쪽 아래
        return (2 * step + search(n - 1, r - half_size, c))
    else:                                           #4등분 했을 시 왼쪽 아래
        return (3 * step + search(n - 1, r - half_size, c - half_size))


n, r, c = map(int, sys.stdin.readline().split())
count = search(n, r, c)

print(count)