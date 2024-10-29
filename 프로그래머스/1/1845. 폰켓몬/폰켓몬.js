function solution(nums) {
    var map = new Map();
    
    for(let num of nums) {
        map.set(num, map.get(num) + 1);
    }
    
    if(map.size > nums.length / 2) return nums.length /2
    else return map.size;
    
}