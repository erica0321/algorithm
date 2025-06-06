class Solution {
    public int solution(int storey) {
        int answer = 0;
        while (storey > 0) {
            int left_one = storey % 10;
            if (left_one < 5) {
                answer += left_one;
                storey /= 10;
            } 
            if (left_one > 5) {
                answer += (10 - left_one);
                storey = storey / 10 + 1;
            } 
            if(left_one == 5) {
                int left_ten = (storey / 10) % 10;
                if (left_ten >= 5) {
                    answer += 5;
                    storey = storey / 10 + 1;
                } else {
                    answer += 5;
                    storey /= 10;
                }
            }
        }
        return answer;
    }
}
