function solution(a, b) {
    const concat = Number(`${a}${b}`);
    const mul = 2 * a * b;
    
    return concat > mul ? concat : mul;
}