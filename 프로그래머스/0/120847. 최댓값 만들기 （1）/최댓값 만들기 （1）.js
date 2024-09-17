function solution(numbers) {
    let numbers2 = numbers.sort((a, b) => b - a)
    
    
    return numbers2[0] * numbers2[1];
}