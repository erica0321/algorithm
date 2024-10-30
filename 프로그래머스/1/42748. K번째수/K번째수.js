function solution(array, commands) {
    let answer = [];
    
    for(let command of commands) {
        let start = command[0] - 1;
        let end = command[1] - 1;
        let idx = command[2] - 1;
        
        let temp = array.slice(start, end + 1);
        temp.sort((a, b) => a - b);
        answer.push(temp[idx]);
    }
    return answer;
}
