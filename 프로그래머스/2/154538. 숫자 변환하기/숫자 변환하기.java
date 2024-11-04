import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        if (x == y) return 0;
        
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(new int[] {x, 0});
        visited.add(x);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int num = current[0];
            int count = current[1];
            
            if (num == y) {
                return count;
            }
            
            int[] nextNums = {num + n, num * 2, num * 3};
            
            for (int next : nextNums) {
                if (next <= y && !visited.contains(next)) {
                    queue.add(new int[] {next, count + 1});
                    visited.add(next);
                }
            }
        }
        
        return -1;
    }
}
