function solution(A, B) {
    let count = 0;

    while (count <= A.length) {
        if (A === B) {
            return count; 
        }
        
        let last = A.slice(-1); 
        let left = A.slice(0, A.length - 1); 
        A = last + left; 
        
        count++; 
    }
    
    return -1;
}
