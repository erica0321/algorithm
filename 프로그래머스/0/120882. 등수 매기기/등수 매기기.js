function solution(score) {
    let total = [];
    for(let sco of score) {
        total.push(sco[0] + sco[1]);
    }
    
    total.sort((a, b) => b - a)
    let map = new Map();
    
    let i = 1;
    for(let sco of total) {
        if(map.get(sco)) {
            i++;
            continue;
        }
        map.set(sco, i);
        i++;
    }
    
    let answer = []
    for(let sco of score) {
        answer.push(map.get(sco[0] + sco[1]))
    }
    
    return answer;
}