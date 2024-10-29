function solution(participant, completion) {
    let map = new Map()
    
    for(let people of participant) {
        map.set(people, (map.get(people) || 0) + 1);
    }
    
    for(let people of completion) {
        if(map.get(people)) {
            map.set(people, map.get(people) -1);
        }
    }
    
    for (let [key, value] of map) {
        if (value > 0) return key;
    }
    
}