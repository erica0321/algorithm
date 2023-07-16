r, c, k = map(int, input().split())
li = []

for i in range(r):
    li.append(list(input()))

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
cnt = 0

def find(x, y, len):
    global cnt

    if len == k and x == 0 and y == c-1:
        cnt += 1

    for i in range(4):
        mov_x = x + dx[i]
        mov_y = y + dy[i]

        if 0 <= mov_x < r and 0 <= mov_y < c and li[mov_x][mov_y] == '.':
            li[mov_x][mov_y] = 'T'
            find(mov_x, mov_y, len + 1)
            #초기화
            li[mov_x][mov_y] = '.'
                
li[r-1][0] = 'T'
find(r-1, 0, 1)
print(cnt)