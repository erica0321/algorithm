function solution(num, k) {
    const index = String(num).split("").findIndex((e) => e === String(k));
    return index !== -1 ? index + 1 : -1; 
}