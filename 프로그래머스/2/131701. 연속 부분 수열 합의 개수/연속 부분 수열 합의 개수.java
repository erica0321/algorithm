import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        ArrayList<Integer> elList = new ArrayList<Integer>();
        HashSet<Integer> sumSet = new HashSet<Integer>();
        
        for (int i = 0; i<2; i++) {
            for (int element : elements) {
                elList.add(element);
            }
        }
        
        for (int i = 0; i < elements.length; i++) {
            for (int j = 1; j <= elements.length; j++) {
                List<Integer> subLst = elList.subList(i, i+j);
                int sum = 0;
                for (int num : subLst)
                    sum += num;
                sumSet.add(sum);
            }
        }
        answer = sumSet.size();
        return answer;
    }
}
