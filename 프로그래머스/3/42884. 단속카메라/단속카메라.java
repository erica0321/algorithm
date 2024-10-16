import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (int[] o1, int[] o2) -> o1[1] - o2[1]);
        
        int answer =1;
        int location = routes[0][1];
        
        for(int i =1; i<routes.length; i++) {
            if(location < routes[i][0]) {
                answer ++;
                location = routes[i][1];
            }
        }
        
        return answer;
    }
}