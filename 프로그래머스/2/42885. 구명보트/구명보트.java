import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int start = 0;
        int end = people.length -1;
        
        Arrays.sort(people);
        
        while(start <= end) {
            int total = people[start] + people[end];
            if(total <= limit) {
                answer++;
                start++;
                end--;
            } else if(total > limit) {
                answer++;
                end--;
            }
        }
        
        return answer;
    }
}