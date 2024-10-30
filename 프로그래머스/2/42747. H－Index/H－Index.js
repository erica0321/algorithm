function solution(citations) {
    citations.sort((a, b) => a - b);
    
    for(let i =0 ;i<citations.length; i++) {
        let h = citations.length - i;
        if(citations[i] >= h) return h;
    }
    return 0;
}