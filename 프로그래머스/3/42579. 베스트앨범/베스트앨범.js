function solution(genres, plays) {
    let answer = [];

    let num = new Map();
    let music = new Map();
    
    for (let i = 0; i < plays.length; i++) {
        if (!num.has(genres[i])) {
            num.set(genres[i], plays[i]);
            music.set(genres[i], new Map([[i, plays[i]]]));
        } else {
            num.set(genres[i], num.get(genres[i]) + plays[i]);
            music.get(genres[i]).set(i, plays[i]);
        }
    }
    
    let keySet = Array.from(num.keys()).sort((a, b) => num.get(b) - num.get(a));
    
    for (let key of keySet) {
        let genreMap = Array.from(music.get(key).entries());
        genreMap.sort((a, b) => b[1] - a[1]);
        
        answer.push(genreMap[0][0]);
        if (genreMap.length > 1) answer.push(genreMap[1][0]);
    }
    
    return answer;
}
