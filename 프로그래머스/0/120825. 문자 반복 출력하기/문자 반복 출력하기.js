function solution(my_string, n) {
    let answer = '';
    for (let str of my_string) {
        answer += str.repeat(n);
    }
    return answer;
}
