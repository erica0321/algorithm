class Solution {
    public int[] solution(int[][] edges) {
        //정점 번호, 도넛 수, 막대 수, 8자 수
        int[] answer = new int[4];

        // 각 정점에서 나가는 간선, 들어오는 간선 수 저장
        int maxVertex = 0;
        for (int[] edge : edges) {
            maxVertex = Math.max(maxVertex, Math.max(edge[0], edge[1]));
        }

        // 각 정점에서 나가는 간선, 들어오는 간선 수 저장
        int[] edges_in = new int[maxVertex + 1];
        int[] edges_out = new int[maxVertex + 1];

        for (int[] edge : edges) {
            edges_out[edge[0]] += 1;
            edges_in[edge[1]] += 1;
        }

        for (int i = 1; i <= maxVertex; i++) {
            // 정점 번호
            if (edges_in[i] == 0 && edges_out[i] >= 2) {
                answer[0] = i;
            } else if (edges_in[i] >= 1 && edges_out[i] == 0) {
                answer[2] += 1;
            } else if (edges_in[i] >= 2 && edges_out[i] == 2) {
                answer[3] += 1;
            }
        }

        answer[1] = edges_out[answer[0]] - answer[2] - answer[3];

        return answer;
    }
}