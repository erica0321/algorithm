function solution(age) {
    let ages = String(age).split("");
    let answer = '';
    for(let age of ages) {
        answer += String.fromCharCode(Number(age)+65).toLowerCase()
    }
    
    return answer;
}