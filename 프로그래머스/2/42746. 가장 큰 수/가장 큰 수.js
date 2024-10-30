function solution(numbers) {
    const numStr = numbers.map(String);

    numStr.sort((a, b) => (b + a).localeCompare(a + b));

    if (numStr[0] === "0") {
        return "0";
    }

    return numStr.join("");
}
