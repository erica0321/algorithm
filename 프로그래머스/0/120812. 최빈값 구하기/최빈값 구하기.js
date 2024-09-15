function solution(array) {
    let count = new Map();
    
    for (let num of array) {
        count.set(num, (count.get(num) || 0) + 1);
    }
    
    // 내림차순 정렬
    count = [...count].sort((a,b) => b[1] - a[1]);
    return (count.length === 1 || count[0][1] > count[1][1]) ? count[0][0] : -1;
}