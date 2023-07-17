n, d = map(int, input().split())

li = [list(map(int, input().split())) for _ in range(n)]
li = sorted(li, key = lambda x: (x[0], x[1], x[2]))

#고속도로만 타고 가는 경우로 dist 초기화
dist = [i for i in range(d+1)]

for shortcut in li:
    start, end, len = shortcut
    if end <= d:
        dist[end] = min(dist[start] + len, dist[end])

    for i in range (start, d+1):
        dist[i] = min(dist[i-1] + 1, dist[i])

print(dist[d])