class Solution {
    public static int count;
    public static int length;
    public static int[] numbers2;
    public int solution(int[] numbers, int target) {
        length = numbers.length;
    
        numbers2 = numbers;
        
        dfs(0, target, 0);
        
        return count;
    }
    
    public static void dfs(int depth, int target, int result) {
        if(depth == length) {
            if(result == target) {
                count += 1;
            }
            return;
        }
        
        int temp = numbers2[depth];
        dfs(depth+1, target, result + numbers2[depth]);
        dfs(depth +1, target, result - numbers2[depth]);
    }
}