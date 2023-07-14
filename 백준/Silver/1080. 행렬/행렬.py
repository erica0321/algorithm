def is_same():
    for i in range(r):
        for j in range(c):
            if li_input[i][j] != li_output[i][j]:
                check = False
                return check
    check = True
    return check


r, c = map(int, input().split())
li_input = []
li_output = []

cnt = 0

for i in range(r):
    li_input.append(list(map(int, input())))
for i in range(r):
    li_output.append(list(map(int, input())))

for i in range(r - 2):
    for j in range(c - 2):
        #같은지 다른지 확인
        if li_input[i][j] != li_output[i][j]:
            for k in range(i, i+3):
                for l in range(j, j+3):
                    li_input[k][l] = 1 - li_input[k][l]
            
            cnt += 1

if is_same():
    print(cnt)
else:
    print(-1)
                    