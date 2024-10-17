import java.util.*;

class Solution {
    public static boolean[] visited;
    public static String[][] tickets;
    public static List<String> allRoute;
    
    public String[] solution(String[][] ticketss) {
        String[] answer = {};
        tickets = ticketss;
        allRoute = new ArrayList<>();
        
        // 해당 티켓 사용 유무
        visited = new boolean[tickets.length];
        
        dfs("ICN", "ICN", 0);
        
        Collections.sort(allRoute);
        answer = allRoute.get(0).split(" ");
        
        return answer;
        
    }
    public static void dfs(String start, String routes, int depth) {
        if(depth == tickets.length) {
            allRoute.add(routes);
            return;
        }
        
        for(int i =0; i<tickets.length; i++) {
            if(!visited[i] && start.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(tickets[i][1], routes + " " + tickets[i][1], depth+1);
                visited[i] = false;
            }
        }
    }
}