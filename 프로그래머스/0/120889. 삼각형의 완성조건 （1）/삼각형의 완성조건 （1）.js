function solution(sides) {
    let MaxLine = Math.max(...sides);
    let MaxIndex = sides.findIndex((e) => e === MaxLine);
    let sum = 0;
    
    for(let i = 0; i<sides.length; i++) {
        if(i !== MaxIndex) {
            sum += sides[i]
        }
    }
    
    if(sum > MaxLine) return 1;
    else return 2;
}