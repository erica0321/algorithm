class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int realHeight = 3;
        int realWidth = 0;
        
        //n은 노란색 가로, m은 노란색 세로
        for(int height = 3; height <= total / height; height ++) {
            if(total % height == 0) {
                int width = total / height;
                
                int yellowWidth = width -2;
                int yelloHeight = height -2;
                
                if (yellowWidth * yelloHeight == yellow) { 
                    realHeight = height;
                    realWidth = width;
                }
            }
        }
        
        return new int[] { realWidth, realHeight };
    }
}