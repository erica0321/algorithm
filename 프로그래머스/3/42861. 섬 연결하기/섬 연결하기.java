import java.util.*;

class Solution {
    public static int[] parents;
    
    public int solution(int n, int[][] costs) {
        
        // 1. 간선들을 가중치에 따라 정렬
        Arrays.sort(costs, (int[] cost1, int[] cost2) -> cost1[2] - cost2[2]);
        
        // 2. 부모 배열 초기화
        parents = new int[n];
        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }
        
        int answer = 0;
        // 3. 각 간선을 순회하면서 처리
        for(int[] cost : costs) {
            int start = cost[0];
            int end = cost[1];
            int weight = cost[2];
            
            int rootStart = findParent(start);
            int rootEnd = findParent(end);
            
            // 사이클이 발생하지 않으면 합치기
            if(rootStart != rootEnd) {
                answer += weight;
                parents[rootEnd] = rootStart; // 두 집합을 병합
            }
        }
        return answer;
    }
    
    // 부모 찾기 로직 (경로 압축)
    public static int findParent(int node) {
        if(parents[node] == node) {
            return node;
        } else {
            parents[node] = findParent(parents[node]); // 경로 압축
            return parents[node];
        }
    }
}
