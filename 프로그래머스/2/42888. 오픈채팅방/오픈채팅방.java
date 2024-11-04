import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String[]> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        
        for (String rec : record) {
            String[] temp = rec.split(" ");
            if (temp[0].equals("Enter")) {
                list.add(new String[] {temp[0], temp[1]});
                map.put(temp[1], temp[2]);
            } else if (temp[0].equals("Leave")) {
                list.add(new String[] {temp[0], temp[1]}); 
            } else if (temp[0].equals("Change")) {
                map.put(temp[1], temp[2]);
            }
        }
        
        String[] answer = new String[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            String[] info = list.get(i);
            String name = map.get(info[1]);
            if (info[0].equals("Enter")) {
                answer[i] = name + "님이 들어왔습니다.";
            } else if (info[0].equals("Leave")) {
                answer[i] = name + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}
