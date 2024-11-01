class Solution {
    public int[] solution(int brown, int yellow) {
        for(int i = 1; i<=yellow; i++) {
            if(yellow % i == 0) {
                int width = i;
                int height = yellow / i;
                
                if((width+2) * (height + 2) == (brown + yellow) && width >= height)  {
                    return new int[] {width+2, height+2};
                }
            }
        }
        return new int[]{0};
    }
}