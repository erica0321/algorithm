function solution(arr1, arr2) {
    if(arr1.length > arr2.length) return 1;
    else if(arr1.length < arr2.length) return -1;
    
    const arr1_num = arr1.reduce((acc, cur) => acc + cur);
    const arr2_num = arr2.reduce((acc, cur) => acc + cur);
    
    return arr1_num > arr2_num ? 1 : arr1_num === arr2_num ? 0 : -1;
}