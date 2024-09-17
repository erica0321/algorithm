function solution(my_string, letter) {
    return my_string.split("").filter((e) => e !== letter).join("");
}