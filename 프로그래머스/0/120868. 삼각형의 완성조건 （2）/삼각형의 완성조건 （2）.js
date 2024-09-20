function solution(sides) {
    let Max = Math.max(...sides);
    let Min = Math.min(...sides);
    
    console.log(Max);
    console.log(Min);
    
    
    return 2*Min -1;
}