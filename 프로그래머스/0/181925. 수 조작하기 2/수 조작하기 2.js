function solution(numLog) {
    var answer = '';
    let start = numLog[0];
    for(let i = 1; i<numLog.length; i++) {
        if(numLog[i] - start === 1) answer += 'w';
        if(numLog[i] - start === -1) answer += 's';
        if(numLog[i] - start === 10) answer += 'd';
        if(numLog[i] - start === -10) answer += 'a';
        start = numLog[i];
    }
    return answer;
}