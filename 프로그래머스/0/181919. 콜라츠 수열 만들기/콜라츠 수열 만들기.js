function solution(n) {
    var answer = [];
    var num = n;
    while (num != 1) {
        if (num % 2 === 0) num = num / 2;
        else num = num * 3 + 1;
        answer.push(num);
    }
    return [n, ...answer]; 
}
