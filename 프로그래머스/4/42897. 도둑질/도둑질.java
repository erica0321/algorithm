class Solution {
    public int solution(int[] money) {
        // 첫집을 털 경우 dp
        int[] dpO = new int[money.length];
        // 첫집을 털지 않은 경우 dp
        int[] dpX = new int[money.length];
        
        dpO[0] = money[0];
        dpO[1] = money[0];

        dpX[0] = 0;
        dpX[1] = money[1];
        
        for(int i =2; i<money.length; i++) {
            dpO[i] = Math.max(dpO[i-2] + money[i], dpO[i-1]);
            dpX[i] = Math.max(dpX[i-2] + money[i], dpX[i-1]);
        }
        
        return Math.max(dpO[money.length -2],  dpX[money.length-1]);
    }
}