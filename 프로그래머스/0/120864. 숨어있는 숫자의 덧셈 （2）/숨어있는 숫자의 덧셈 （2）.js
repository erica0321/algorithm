function solution(my_string) {
    let answer = 0

    for(let i = 0; i < my_string.length; i++) {
        let num = '';
        while(!Number.isNaN(Number(my_string[i]))) {
            num += my_string[i];
            i++;
        }
        answer += Number(num);
    }
    
    return answer;
}