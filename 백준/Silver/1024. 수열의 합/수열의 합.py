N, L = map(int, input().split())

for i in range(L, 101):
    k = N - (i * (i + 1) / 2)

    if k % i == 0:
        k = int(k / i)

        if k >= -1:
            for j in range(1, i + 1):
                print(k + j, end=" ")
            print()
            break
else:
    print(-1)