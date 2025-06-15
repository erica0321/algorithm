class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int card1 = 0; 
        int card2 = 0;
        
        for (String str : goal) {
            if (card1 < cards1.length && str.equals(cards1[card1])) {
                card1++;
            } else if (card2 < cards2.length && str.equals(cards2[card2])) {
                card2++;
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}
