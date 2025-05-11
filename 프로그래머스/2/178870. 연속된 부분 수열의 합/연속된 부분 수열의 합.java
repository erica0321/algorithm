class Solution {
    public int[] solution(int[] sequence, int k) {
        int len = sequence.length;
        int start = 0, end = 0;
        int minRange = Integer.MAX_VALUE;

        int s = 0, e = 0, sum = 0; 
        while (s < len) {
            while (e < len && sum < k) {
                sum += sequence[e];
                e++;
            }

            if (sum == k) {
                int range = e - s;
                if (range < minRange || 
                   (range == minRange && s < start)) {
                    minRange = range;
                    start = s;
                    end = e - 1;
                }
            }

            sum -= sequence[s];
            s++;
        }

        return new int[]{start, end};
    }
}
