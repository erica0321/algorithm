import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (f1, f2) -> {
            String[] file1 = splitHeadNum(f1);
            String[] file2 = splitHeadNum(f2);
            
            // head 대소문자 무시
            int comp = file1[0].compareToIgnoreCase(file2[0]);
            if(comp != 0) return comp;
            
            // number 비교
            Integer num1 = Integer.parseInt(file1[1]);
            Integer num2 = Integer.parseInt(file2[1]);
            
            return num1.compareTo(num2);
        });
        return files;
    }
    
    public String[] splitHeadNum(String file) {
        int length = file.length();
        int headIdx = 0;
        
        // head 분리: 숫자가 나오기 전까지
        while (headIdx < length && !Character.isDigit(file.charAt(headIdx))) {
            headIdx++;
        }
        String head = file.substring(0, headIdx);

        // number 분리: 최대 5자리 숫자
        int numberIdx = headIdx;
        while (numberIdx < length && Character.isDigit(file.charAt(numberIdx)) && numberIdx - headIdx < 5) {
            numberIdx++;
        }
        String number = file.substring(headIdx, numberIdx);

        return new String[]{ head, number };
    }
}