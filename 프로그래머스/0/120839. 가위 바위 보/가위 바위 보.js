function solution(rsp) {
    var answer = '';
    for(let str of rsp) {
        if(str === '2') answer += '0'
        else if(str === '0') answer += '5'
        else if(str === '5') answer += '2'
    }
    return answer;
}