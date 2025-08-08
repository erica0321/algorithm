function solution(my_string, is_suffix) {
    var answer = 0;
    const n = is_suffix.length;
    if(n > my_string.length) answer = 0;
    if(my_string.slice(my_string.length - n, my_string.length) === is_suffix) answer = 1;
    return answer;
}