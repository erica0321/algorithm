function solution(babbling) {
    const regex = /^(aya|ye|woo|ma)+$/;
    let answer = 0;
    
    babbling.forEach(word => {
        if (regex.test(word)) answer++;  
    })
    
    return answer;
}