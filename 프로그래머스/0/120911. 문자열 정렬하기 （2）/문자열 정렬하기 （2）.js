function solution(my_string) {
    let list = my_string.toLowerCase().split("");
    return list.sort().join("");
}