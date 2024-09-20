function solution(polynomial) {
    const arr = polynomial.split(" ");
    let polyNum = 0;
    let num = 0;
    
    for (let po of arr) {
        if (po.includes('x')) {
            if (po.length > 1) {
                polyNum += Number(po.replace('x', ''));
            } 
            else {
                polyNum += 1;
            }
        } 
        else if (!isNaN(Number(po))) {
            num += Number(po);
        }
    }
    
    let result = '';
    
    if (polyNum > 0) {
        result += (polyNum === 1 ? 'x' : `${polyNum}x`);
    }
    
    if (num > 0 && polyNum > 0) {
        result+= ` + ${num}`;
    } else if(num > 0) {
        result += num
    }
    
    return result
}
