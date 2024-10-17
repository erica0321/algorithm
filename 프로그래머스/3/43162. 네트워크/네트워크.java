import java.util.*;

class Solution {
    public static int[] parents;
    public int solution(int n, int[][] computers) {
        // Union-Find 부모 배열 초기화
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        // 연결된 컴퓨터들에 대해 Union 처리
        Set<int[]> set = new HashSet<>();
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (i != j && computers[i][j] == 1) {
                    set.add(new int[]{i, j});
                }
            }
        }

        // Set에 저장된 연결 정보로 Union 수행
        for (int[] computer : set) {
            int start = computer[0];
            int end = computer[1];

            int rootStart = findParents(start);
            int rootEnd = findParents(end);

            if (rootStart != rootEnd) {
                parents[rootEnd] = rootStart; // rootEnd의 루트를 rootStart로 병합
            }
        }

        // 고유한 네트워크 개수를 저장할 Set
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < parents.length; i++) {
            result.add(findParents(i)); // 모든 노드의 최종 부모를 찾아 Set에 저장
        }

        return result.size(); // 네트워크 개수 반환
    }

    public static int findParents(int node) {
        if (parents[node] == node) {
            return node;
        } else {
            parents[node] = findParents(parents[node]); // 경로 압축
            return parents[node];
        }
    }
}
