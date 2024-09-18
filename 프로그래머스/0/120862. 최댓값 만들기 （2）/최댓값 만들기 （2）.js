function solution(numbers) {
    let sorted = numbers.sort((a, b) => b - a);
    let start = sorted[0] * sorted[1]
    let bottom = sorted[numbers.length - 1] * sorted[numbers.length - 2];
    
    
    return Math.max(start, bottom);
}