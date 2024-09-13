function solution(numer1, denom1, numer2, denom2) {
    const newDenom = denom1 * denom2;
    const sumNumer = numer1*denom2 + numer2*denom1;
    
    const newGcd = gcd(newDenom, sumNumer)
    
    const latestDenom = Math.floor(newDenom / newGcd)
    const latestNumer = Math.floor(sumNumer / newGcd)
    
    
    
    var answer = [latestNumer, latestDenom];
    return answer;
}

function gcd(a, b) {
    let gcd = 1;

    for(let i=2; i<=Math.min(a, b); i++){
        if(a % i === 0 && b % i === 0){
            gcd = i;
        }
    }
    return gcd
}