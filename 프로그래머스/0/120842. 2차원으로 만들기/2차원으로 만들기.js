function solution(num_list, n) {
    var answer = [];
    for(let i = 0; i <= num_list.length - n; i+= n) {
        let arr = [];
        for(let j = i; j < i + n; j++) {
            arr.push(num_list[j]);
        }
        answer.push(arr)
    }
    return answer;
}