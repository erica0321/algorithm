import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String str: operations) {
            String[] arr = str.split(" ");
            if(arr[0].equals("I")) {
                int num = Integer.parseInt(arr[1]);
                min.offer(num);
                max.offer(num);
            } else if(arr[0].equals("D")) {
                if(arr[1].equals("-1")) {
                    if(!min.isEmpty()) {
                        max.remove(min.poll());
                    }
                } else if(arr[1].equals("1")) {
                    if(!max.isEmpty()) {
                        min.remove(max.poll());
                    }
                }
            }
        }
        
        
         int minNum = min.isEmpty() ? 0 : min.poll();
        int maxNum = max.isEmpty() ? 0 : max.poll();
        
        return new int[]{maxNum, minNum} ;
        
        
    }
}