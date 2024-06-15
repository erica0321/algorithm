import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[][] terms2 = new String[terms.length][2];
        
        // terms 배열 분리
        for (int i = 0; i < terms.length; i++) {
            String[] splitTerm = terms[i].split(" ");
            terms2[i][0] = splitTerm[0];
            terms2[i][1] = splitTerm[1];
        }
        
        String[][] privacies2 = new String[privacies.length][2];
        
        // privacies 배열 분리
        for (int i = 0; i < privacies.length; i++) {
            String[] splitPrivacy = privacies[i].split(" ");
            privacies2[i][0] = splitPrivacy[0];
            privacies2[i][1] = splitPrivacy[1];
        }
        
        List<Integer> expiredIndices = new ArrayList<>();
        
        for (int i = 0; i < privacies2.length; i++) {
            String privacyDate = privacies2[i][0];
            String privacyTerm = privacies2[i][1];
            
            int termMonths = 0;
            
            // terms2에서 해당 term의 기간을 찾기
            for (String[] term : terms2) {
                if (term[0].equals(privacyTerm)) {
                    termMonths = Integer.parseInt(term[1]);
                    break;
                }
            }
            
            String[] dateParts = privacyDate.split("\\.");
            int year = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int day = Integer.parseInt(dateParts[2]);
            
            month += termMonths;
            while (month > 12) {
                year += 1;
                month -= 12;
            }
            
            String expiresDate = String.format("%04d.%02d.%02d", year, month, day);
            
            // 만료 날짜가 오늘 날짜보다 이전인지 확인
            if (expiresDate.compareTo(today) <= 0) {
                expiredIndices.add(i + 1);
            }
        }
        
        // 결과 배열로 변환
        int[] solution = new int[expiredIndices.size()];
        for (int i = 0; i < expiredIndices.size(); i++) {
            solution[i] = expiredIndices.get(i);
        }
        
        return solution;
    }
}
