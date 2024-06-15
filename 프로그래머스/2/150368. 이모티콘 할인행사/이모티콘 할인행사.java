class Solution {
    // 결과 저장 [가입자 수, 구입 비용]
    int[] result = {0, 0};
    
    //가능한 할인율
    int[] percentages = {10, 20, 30, 40};
    
    // 이모티콘 할인율 저장
    int[] discount;
    
    public int[] solution(int[][] users, int[] emoticons) {
        discount = new int[emoticons.length];
        
        // 모든 경우의 결과 구하기
        checkDiscount(0, users, emoticons);
        
        return result;
    }
    
    public void checkDiscount(int target, int[][] users, int[] emoticons) {
        // 모든 이모티콘 할인율이 결정됐다면 해당 경우의 가입자수, 구입 비용 계산
        if (target == emoticons.length) {
            getBuy(users, emoticons);
            return;
        }
        
        // 할인율 설정
        for (int percentage : percentages) {
            // target 할인율 저장
            discount[target] = percentage;
            // target + 1부터 끝까지 할인율 정하기
            checkDiscount(target + 1, users, emoticons);
        }
    }
    
    public void getBuy(int[][] users, int[] emoticons) {
        int totalPrice = 0;
        int service = 0;
        
        // 유저 별 가입, 구입 계산
        for (int[] user : users) {
            // 유저가 이모티콘을 구입한 총 금액 
            int totalBuy = 0;
            
            // totalBuy 계산
            for (int i = 0; i < emoticons.length; i++) {
                // 유저가 이모티콘을 구입
                if (user[0] <= discount[i]) {
                    int price = emoticons[i] * (100 - discount[i]) / 100;
                    totalBuy += price;
                }
            }
            
            // 이모티콘 플러스 가입 체크
            if (user[1] <= totalBuy) {
                service += 1;
            } else {
                totalPrice += totalBuy;
            }
        }
        
        // 목적 최대 달성 체크
        //우선순위에 따라 계산
        if (service > result[0]) {
            result[0] = service;
            result[1] = totalPrice;
        } else if (service == result[0] && totalPrice > result[1]) {
            result[1] = totalPrice;
        }
    }
}
