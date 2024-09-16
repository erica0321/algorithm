function solution(money) {
    const num = Math.floor(money/5500);
    var answer = [num, money - num * 5500 ];
    return answer;
}