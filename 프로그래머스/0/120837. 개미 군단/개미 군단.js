function solution(hp) {
    let answer = 0;
    let 장군 = Math.floor(hp / 5);
    let 병정 = Math.floor((hp % 5) / 3);
    let 일갬 = hp - 장군 * 5 - 병정 * 3;
    
    return 장군 + 병정 + 일갬;
}