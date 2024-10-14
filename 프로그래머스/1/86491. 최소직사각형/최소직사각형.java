class Solution {
    public static int max_x = Integer.MIN_VALUE;
    public static int max_y = Integer.MIN_VALUE;
    
    public int solution(int[][] sizes) {
        for(int i =0; i<sizes.length; i++) {
            if(sizes[i][0] <= sizes[i][1]) {
                int switchs = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = switchs; 
            }
            
            max_x = Math.max(sizes[i][0], max_x);
            max_y = Math.max(sizes[i][1], max_y);
        }
        
        return max_x * max_y;
    }
}