class Solution {
    static int answer = 0;
    static int[] list;

    public int solution(int[] numbers, int target) {
        list = numbers;
        
        dfs(0, target, 0);

        return answer;
    }

    // 깊이 우선 탐색
    public void dfs(int depth, int target, int sum){
        if(depth == list.length){
            if(target == sum) answer++;
        } else {
            dfs(depth + 1, target, sum + list[depth]);
            dfs(depth + 1, target, sum - list[depth]);
        }
    }
}