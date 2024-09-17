function solution(order) {
    let answer = 0;
    for (let str of String(order)) {
        if (str === '3' || str === '6' || str === '9') {
            answer++;
        }
    }
    return answer;
}
