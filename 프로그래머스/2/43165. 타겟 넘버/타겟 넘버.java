class Solution {
    public static int answer =0;
    public static int N;
    public static int[] list;
    
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        list = numbers;
        dfs(0, 0, target);
        
        return answer;
    }
    
    public static void dfs(int depth, int num, int target) {
        if (depth == N) {
            if (num == target) {
                answer++;
            }
        } else {
            dfs(depth + 1, num + list[depth], target);
            dfs(depth + 1, num - list[depth], target);
        }
    }
}