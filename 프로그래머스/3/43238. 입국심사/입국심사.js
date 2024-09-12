function solution(n, times) {
    var answer = 0;
    
    var min = 0;
    var max = n * Math.max(...times);
    
    while (min <= max) {
        let mid = Math.floor((min + max) / 2);
        let people = 0;
        
        for (let time of times) {  
            people += Math.floor(mid / time);
        }
        
        if (people >= n) { 
            answer = mid;
            max = mid - 1;
        } else {  
            min = mid + 1;
        }
    }
    
    return answer;
}
