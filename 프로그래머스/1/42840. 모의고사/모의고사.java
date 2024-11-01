import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer1 = {1, 2, 3, 4, 5};
        int[] answer2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] answer3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
        int[] count = new int[3];
        
        for(int i = 0; i<answers.length; i++) {
            if(answers[i] == answer1[i % (answer1.length)]) count[0]++;
            if(answers[i] == answer2[i % (answer2.length)]) count[1]++;
            if(answers[i] == answer3[i % (answer3.length)]) count[2]++;
        }
        
        int answer = Math.max(count[0], Math.max(count[1], count[2]));
        
        List<Integer> people = new ArrayList<>();
        
        for(int i =0; i<3; i++) {
            if(count[i] == answer) people.add(i+1);
        }
        
        int[] result = new int[people.size()];
        for(int i = 0; i < people.size(); i++) {
            result[i] = people.get(i);
        }
        
        return result;
    }
}