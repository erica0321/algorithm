import sys 
sys.setrecursionlimit(10000) 

def find(x, y):
    visited[x][y] = 1
    
    mov_x = [-1, 1, 0, 0]
    mov_y = [0, 0, -1, 1]

    for i in range(4):
        x_moved = x + mov_x[i]
        y_moved = y + mov_y[i]

        if 0 <= x_moved < height and 0 <= y_moved < width and place[x_moved][y_moved] == 1 and visited[x_moved][y_moved] == 0:
            find(x_moved, y_moved)

test_case = int(input())

for _ in range(test_case):
    width, height, num = map(int, input().split())
    place = [[0] * width for _ in range(height)]
    visited = [[0] * width for _ in range(height)]
    bug = 0

    for _ in range(num):
        y, x = map(int, input().split())
        place[x][y] = 1
    
    for i in range(height):             #행
        for j in range(width):          #열
            if (place[i][j] == 1 and visited[i][j] == 0):
                find(i, j)
                bug += 1
    
    print(bug)
