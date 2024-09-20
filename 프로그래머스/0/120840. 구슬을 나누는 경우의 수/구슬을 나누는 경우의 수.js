function solution(balls, share) {
    let top = BigInt(1);
    let bottom = BigInt(1);
    
    for (let i = 0; i < share; i++) {
        top *= BigInt(balls - i);
    }
    
    for (let i = 1; i <= share; i++) {
        bottom *= BigInt(i);
    }
    
    return top / bottom;
}
