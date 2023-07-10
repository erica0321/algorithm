import sys 
sys.setrecursionlimit(10000) 

def find(x, y):
    visited[x][y] = 1
    size = 1

    mov_x = [-1, 1, 0, 0]
    mov_y = [0, 0, -1, 1]

    for i in range(4):
        x_moved = x + mov_x[i]
        y_moved = y + mov_y[i]

        if 0 <= x_moved < n and 0 <= y_moved < m and place[x_moved][y_moved] == 1 and visited[x_moved][y_moved] == 0:
            size += find(x_moved, y_moved)

    return size

max_size = 0
 
n, m, k = map(int, input().split())
place = [[0] * m for _ in range(n)]
visited = [[0] * m for _ in range(n)]

for _ in range(k):
    r, c = map(int, input().split())
    place[r-1][c-1] = 1
    
for i in range(n):             #행
    for j in range(m):          #열
        if (place[i][j] == 1 and visited[i][j] == 0):
            max_size = max(max_size, find(i, j))
print(max_size)
