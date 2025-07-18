import java.util.*;

class Solution {
    public int solution(int n) {
        String three = Integer.toString(n, 3);
        
        StringBuilder reversed = new StringBuilder(three).reverse(); 
        String reversedStr = reversed.toString();
        
        return Integer.parseInt(reversedStr, 3); 
    }
}
