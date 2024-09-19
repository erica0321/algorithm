let map = new Map();

function solution(n) {
    소인수(n);
    
    var answer = [];
    
    const keyList = map.keys();
    for(let key of keyList) {
        answer.push(key);
    }
    return answer;
}

function 소인수(n) {
    let i = 2;
    
    while(n !== 1) {
        if(n % i === 0) {
            map.set(i, (map.get(i) || 0) + 1);
            n /= i
        } else {
            i++
        } 
    }
    
}