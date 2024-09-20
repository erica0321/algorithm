function solution(lines) {
    var answer = 0;
    
    let check = new Array(200).fill(0);
    
    for(let i =0; i<3; i++) {
        let left = lines[i][0];
        let right = lines[i][1];
        
        for(let j = left; j<right; j++) {
            check[j + 100]++;
        }
    }
    
    for(let index in check) {
        if(check[index] > 1) {
            answer++;
        }
    }
    
    
    return answer;
}