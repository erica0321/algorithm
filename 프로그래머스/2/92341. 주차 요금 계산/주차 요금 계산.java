import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 기본 시간
        int BASETIME = fees[0];
        
        // 기본 요금
        int BASEFEE = fees[1];
        
        // 단위 시간 
        int UNITTIME = fees[2];
        
        // 단위 요금
        int UNITFEE = fees[3];
        
        // 최대 출차 시간
        int MAXOUT = 1439;
        
        // 입차 내역
        Map<String, Integer> in = new HashMap<String, Integer>();
        
        // 총 주차 시간
        Map<String, Integer> parking = new HashMap<String, Integer>();
        
        // 입차 출차 기록 있는 차들의 총 주차 시간
        for (String record : records) {
            String[] arr = record.split(" ");
            
            // 기록 시간
            int recordTime = timeStamp(arr[0]);
            
            // 차 번호
            String carNum = arr[1];
            
            // 입차 기록
            if (arr[2].equals("IN")) {
                in.put(carNum, recordTime);
            }
            
            // 출차 기록 -> 총 주차 시간 계산
            if (arr[2].equals("OUT")) {
                // 입차 시간 계산
                int inTime = in.get(carNum);
                in.remove(carNum);
                                     
                // 만약 이전에 출차 기록이 있다면
                if (parking.containsKey(carNum)) {
                    int totalTime = parking.get(carNum);
                    // 이전 주차 시간 + 현재 주차 시간
                    parking.replace(carNum, totalTime + recordTime - inTime);
                // 처음 출차 한다면
                } else {
                    parking.put(carNum, recordTime - inTime);
                }       
            }    
        }
         
        // 입차는 했으나 출차 기록이 없는 경우
        for (Entry<String, Integer> elem : in.entrySet()) {
            String carNum = elem.getKey();
            int inTime = elem.getValue();
            
            // 만약 주차한 시간이 있다면
            if (parking.containsKey(carNum)) {
                int totalTime = parking.get(carNum);
                // 이전 주차 시간 + 현재 주차 시간
                parking.replace(carNum, totalTime + MAXOUT - inTime);
            // 첫 주차 후, 출차 기록이 없다면
            } else {
                parking.put(carNum, MAXOUT - inTime);
            }
        }
        
        // 주차 시간에 따라 주차 요금 계산
        Map<String, Integer> parkingFee = new HashMap<String, Integer>();
        for (Entry<String, Integer> elem : parking.entrySet()) {
            String carNum = elem.getKey();
            int totalTime = elem.getValue();
            
            if (totalTime <= BASETIME) {
                parkingFee.put(carNum, BASEFEE);
            } else {
                parkingFee.put(carNum, BASEFEE + (int)Math.ceil((double)(totalTime - BASETIME) / UNITTIME) * UNITFEE);
            }
        }
        
        // 차 번호 정렬
        Object[] carNums = parkingFee.keySet().toArray();
        Arrays.sort(carNums);
        
        int[] answer = new int[carNums.length];
        for (int i = 0; i < carNums.length; i++) {
            answer[i] = parkingFee.get(carNums[i]);
        }
        
        return answer;
    }
    
    public static int timeStamp(String times) {
        String[] time = times.split(":");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);

        return hour * 60 + minute;
    }
}
