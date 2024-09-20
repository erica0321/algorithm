function solution(n) {
    let i = 0;
    let answer = 0;
    while(i < n) {
        answer++;
        if (answer % 3 !== 0 && !String(answer).includes('3')) {
            i++; 
        }
    }
    
    return answer;
}
