function solution(i, j, k) {
    let answer = 0;
    for (let start = i; start <= j; start++) {
        const currentStr = String(start);
        for (let char of currentStr) {
            if (char === String(k)) {
                answer++;
            }
        }
    }

    return answer;
}
