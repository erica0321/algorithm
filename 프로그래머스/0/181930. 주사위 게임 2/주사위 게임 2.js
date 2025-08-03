function solution(a, b, c) {
    let case1 = a + b + c;
    let case2 = a * a + b * b + c * c;
    let case3 = a ** 3 + b**3 + c**3;

    if (a === b && b === c) return case1 * case2 * case3;
    if (a === b || a === c || b === c) return case1 * case2;
    return case1;

}