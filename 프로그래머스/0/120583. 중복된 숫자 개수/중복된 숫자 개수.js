function solution(array, n) {
    let map = new Map();
    array.forEach((e) => {
        map.set(e, (map.get(e) || 0) + 1);
    });
    
    return map.get(n) || 0;
}