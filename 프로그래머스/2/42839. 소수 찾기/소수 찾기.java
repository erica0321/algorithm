import java.util.*;

class Solution {
    public static int N;
    public static boolean[] visited;
    public static Set<Integer> set;
    public static String[] numberArr;
    
    public int solution(String numbers) {
        int answer = 0;
        numberArr = numbers.split("");
        
        N = numberArr.length;
        visited = new boolean[N];
        
        set = new HashSet<>();
    
        dfs(0, "");
        
        for(Integer num: set) {
            if(isPrime(num)) answer ++;
        }
        return answer;
    }
                
    
    public static void dfs(int depth, String str) {
        if(depth == N) return;
        
        for(int i =0; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                String newStr = str + numberArr[i];
                System.out.print(newStr + " ");
                set.add(Integer.parseInt(newStr));
                dfs(depth+1, newStr);
                visited[i] = false;
            }
        }
    }
    
    public static boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}