import sys

def bfs(n1, n2):
    queue = [(n1, 0)]
    visited = [False] * (N+1)
    visited[n1] = True

    while queue:
        V, d = queue.pop(0)

        #end node와 찾는 노드가 같으면 바로 길이 출력
        if V == n2:
            return d
        
        #거리 찾기
        for i, j in li[V]:
            if visited[i] == False:
                visited[i] = True
                queue.append((i, d + j))

N, M = map(int, sys.stdin.readline().split())
li = [[] for _ in range(N+1)]

for i in range(N-1):
    start, end, len = map(int, sys.stdin.readline().split())
    li[start].append((end, len))
    li[end].append((start, len))

for _ in range(M):
    start_node, end_node = map(int, sys.stdin.readline().split())
    print(bfs(start_node, end_node))