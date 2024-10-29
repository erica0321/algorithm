function solution(clothes) {
    let map = new Map();
    for(let cloth of clothes) {
        map.set(cloth[1], (map.get(cloth[1]) || 0) + 1)
    };
        
    let answer = 1;
    for(let [key, value] of map) {
        answer *= value + 1
    }
        
    return answer - 1
}