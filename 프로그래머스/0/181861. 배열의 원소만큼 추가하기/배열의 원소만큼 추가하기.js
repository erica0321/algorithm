function solution(arr) {
    return arr.flatMap((a) => Array(a).fill(a));
}