import java.util.*;

class Solution {
    public static int answer = 0;
    public static Set<Integer> set;
    public static boolean[] visited;
    public static String[] str;
    
    public int solution(String numbers) {
        set = new HashSet<>();
        visited = new boolean[numbers.length()];
        str = numbers.split("");
        
        
        dfs("");
        
        for(int num : set) {
            if(isPrime(num)) answer ++;
        }
        
        return answer;
    }
    
    public static boolean isPrime(int num) {
        if(num < 2) return false;
        for(int i = 2; i<= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
    
    public static void dfs(String make) {
        if(!make.equals("")) set.add(Integer.parseInt(make));
        for(int i =0; i<visited.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(make + str[i]);
                visited[i] = false;
            }
        }
    }
}