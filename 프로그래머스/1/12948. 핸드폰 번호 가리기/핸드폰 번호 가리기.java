class Solution {
    public String solution(String phone_number) {
        int length = phone_number.length();
        String last = phone_number.substring(length - 4); 
        
        String star = "*".repeat(length - 4);
        return star+last;
    }
}