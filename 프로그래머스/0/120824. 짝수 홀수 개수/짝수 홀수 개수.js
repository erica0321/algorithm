function solution(num_list) {
    let odd = 0;
    let even = 0;
    
    num_list.forEach((e) => {
        if(e % 2 === 0) {
            even += 1;
        } else {
            odd += 1;
        }
        
    })
    
    var answer = [even, odd];
    return answer;
}