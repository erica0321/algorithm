function solution(array) {
    let answer = 0;
    array.forEach((e) => {
        const str = String(e);
        
        str.split("").forEach((a) => {
            if (a === '7') {
                answer++;
            }
        });
    });
    return answer;
}
