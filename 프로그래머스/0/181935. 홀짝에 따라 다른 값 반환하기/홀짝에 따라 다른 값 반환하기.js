function solution(n) {
    let answer =0;
    if(n%2 ===0) {
        for(let i =0; i<=n; i++) {
            if(i % 2 == 1) continue;
            answer += i*i;
        }
        return answer;
    } 
    
    for(let i =0; i<=n; i++) {
        if(i%2 === 0) continue;
        answer += i;
    }
    return answer;
}