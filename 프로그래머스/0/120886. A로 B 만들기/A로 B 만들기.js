function solution(before, after) {
    let map1 = new Map()
    let map2 = new Map()
    before.split("").forEach((e) => {
        map1.set(e, (map1.get(e) || 0) + 1)
    })
    
    after.split("").forEach((e) => {
        map2.set(e, (map2.get(e) || 0) + 1)
    })
    
    let isSame = true;
    let i = 0;
    while(i <= before.length) {
        if(map2.get(before[i]) !== map1.get(before[i]) ){
            isSame = false;
            break;
        } else {
            i++;
        }
    }
    
    if(isSame) return 1;
    else return 0;
    
    return answer;
}