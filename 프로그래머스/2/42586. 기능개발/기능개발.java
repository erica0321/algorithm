import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        
        int i = 0;
        while(i < progresses.length) {
            int count = 0;
            int days = (int)Math.ceil((100.0 - progresses[i]) / speeds[i]);

            while(i < progresses.length && (100 - progresses[i]) <= days * speeds[i]) {
                count++;
                i++;
            }
            
            list.add(count);
        }

        int[] result = new int[list.size()];
        for(int j = 0; j < list.size(); j++) {
            result[j] = list.get(j);
        }
    
        return result;
    }
}
