import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int max = nums.length / 2;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int num : nums) {
            set.add(num);
        }
        
        if(max >= set.size()) return set.size();
        else return max;
    }
}