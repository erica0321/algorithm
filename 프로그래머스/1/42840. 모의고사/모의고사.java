import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] correct = new int[3];
        
        for(int i =0; i<answers.length; i++) {
            if(answers[i] == a[i%5]) correct[0] ++;
            if(answers[i] == b[i%8]) correct[1] ++;
            if(answers[i] == c[i%10]) correct[2] ++;
        }
        
        int max = Math.max(correct[0], Math.max(correct[1], correct[2]));
        
        List<Integer> answer = new ArrayList<Integer>();
        for(int i=0; i<3; i++) if(max == correct[i]) answer.add(i+1);
        
        int[] arr = new int[answer.size()];
        for(int i=0; i<answer.size(); i++){
            arr[i] = answer.get(i);
        }

        return arr;
    }
}