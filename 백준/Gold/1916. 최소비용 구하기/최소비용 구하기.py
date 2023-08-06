import sys

N = int(sys.stdin.readline())
M = int(sys.stdin.readline())

MAX = int(1e9)

visited = [False] * (N+1)
dist = [MAX] * (N+1)

graph = [[] for _ in range(N+1)]

for _ in range(M):
    start, end, len = map(int, sys.stdin.readline().split())
    graph[start].append((end, len))

start_node, end_node = map(int, sys.stdin.readline().split())

#방문하지 않은 노드이면서 시작노드와 최단거리인 노드
def short_node():
    min = MAX
    index = 0
    for i in range(1, N+1):
        if dist[i] < min and visited[i] == False:
            min = dist[i]
            index = i
    return index

#다익스트라 알고리즘
def dijkstra(start_node):
    dist[start_node] = 0
    visited[start_node] = True

    for i in graph[start_node]:
        if dist[i[0]] > i[1]:
            dist[i[0]] = i[1]

    for k in range(N-1):
        now = short_node()
        visited[now] = 1

        for j in graph[now]:
            if dist[now] + j[1] < dist[j[0]]:
                dist[j[0]] = dist[now] + j[1]

dijkstra(start_node)
print(dist[end_node])