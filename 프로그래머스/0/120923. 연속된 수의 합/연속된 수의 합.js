function solution(num, total) {
    var answer = [];
    
    const start = total / num - (num - 1) / 2;
    return Array.from({ length: num }, (_, i) => start + i);


}