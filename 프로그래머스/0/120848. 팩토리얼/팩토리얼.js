let facArr = [1]

function solution(n) {
    var answer = 0;
    
    for(let i =1; i<= 10; i++) {
        if(fac(i) <=n && fac(i+1) > n) {
            return i;
        }
    }
}

function fac(n) {
    if(n === 1) return 1;
    if(n >= 2) {
        facArr[n] = fac(n-1) * n;
    }
    return facArr[n]
}
