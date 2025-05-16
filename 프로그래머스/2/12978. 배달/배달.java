import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int[][] map = new int[N+1][N+1];
        boolean[] visited = new boolean[N+1];
        int[] dist = new int[N+1];

        for(int i =1; i<=N; i++) {
            for(int j = 1; j<=N; j++) {
                if(i!=j) map[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < road.length; i++) {
            int start = road[i][0];
            int end = road[i][1];
            int cost = road[i][2];

            map[start][end] = Math.min(map[start][end], cost);
            map[end][start] = Math.min(map[end][start], cost);
        }

        for(int i =2 ; i<=N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int end = current[0];
            int cost = current[1];

            if (visited[end]) continue;
            visited[end] = true;

            for (int i = 1; i <= N; i++) {
                if (map[end][i] != Integer.MAX_VALUE && dist[i] > dist[end] + map[end][i]) {
                    dist[i] = dist[end] + map[end][i];
                    pq.offer(new int[]{i, dist[i]});
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }

        return answer;
    }
}
