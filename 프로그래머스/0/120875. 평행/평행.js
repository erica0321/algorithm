function solution(dots) {
    
    const [a,b,c,d] = dots
    
    if (calc(a,b) === calc(c,d))
        return 1;
    if (calc(a,c) === calc(b,d))
        return 1;
    if (calc(a,d) === calc(b,c))
        return 1;
    return 0;
}

function calc(arr1, arr2) {
    return (arr2[1] - arr1[1]) / (arr2[0] - arr1[0])
}