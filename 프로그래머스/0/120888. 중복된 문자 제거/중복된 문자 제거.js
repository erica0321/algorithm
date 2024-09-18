function solution(my_string) {
    let map = new Map();
    let answer = '';

    for (let str of my_string) {
        let count = map.get(str) || 0;
        if (count === 0) {
            answer += str;
        }
        map.set(str, count + 1);
    }

    return answer;
}
