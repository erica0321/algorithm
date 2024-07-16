import java.util.*;

public class Solution {
    public int solution(int n) {
        
        int result = 0;

        while (n > 1) {
            if (n % 2 == 1) {
                result += 1;
                n = n - 1;
            } else {
                n = n / 2;
            }
        }

        return result + 1;
    }
}
