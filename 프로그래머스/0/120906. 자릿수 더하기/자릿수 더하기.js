function solution(n) {
    let num = `${n}`
    let answer = 0;
    for(let str of num) {
        answer += Number(str);
    }
    
    return answer;
}