class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int top = 0;
        int bottom = 0;
        
        for (int i = 0; i < lottos.length; i ++) {
            if (lottos[i] == 0) {
                top++;
                continue;
            }
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    top++;
                    bottom++;
                }
            }
        }
        
        if (top == 0) top = 1;
        if (bottom == 0) bottom = 1;
        
        return new int[]{6 - top + 1, 6 - bottom + 1};
    }
}
