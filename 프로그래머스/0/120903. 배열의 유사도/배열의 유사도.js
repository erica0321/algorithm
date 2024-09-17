function solution(s1, s2) {
    let answer =0;
    for(let s11 of s1) {
        for(let s22 of s2) {
            if(s11 === s22) {
                answer += 1;
            }
        }
    }
    return answer;
}