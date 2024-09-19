function solution(s) {
    let map = new Map();
    let arr = s.split("");
    let answer = [];
    arr.forEach((e) => {
        map.set(e, (map.get(e) || 0) + 1)
    })
    
    for(let str of arr) {
        if(map.get(str) === 1) {
            answer.push(str);
        }
    }
    
    
    return answer.sort().join("");
}