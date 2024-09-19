function solution(my_str, n) {
    let i = 0;
    let answer = []
    
    while(i < my_str.length) {
        answer.push(my_str.slice(i, i+n))
        i+=n;
    }
    return answer;
}