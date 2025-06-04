import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int start = section[0];
        int end = section[0] + m - 1;
        int result = 1;

        for (int i = 1; i < section.length; i++) {
            if (section[i] > end) {
                start = section[i];
                end = section[i] + m - 1;
                result++;
            }
        }

        return result;
    }
}
