function solution(num_list, n) {
    const right_arr = num_list.slice(n);
    const left_arr = num_list.slice(0, n);
    return [...right_arr, ...left_arr];
}