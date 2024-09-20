function solution(id_pw, db) {
    let map = new Map();
    for(let dbArr of db) {
        map.set(dbArr[0], dbArr[1]);
    }
    
    if(map.get(id_pw[0]) && map.get(id_pw[0]) === id_pw[1]) return 'login'
    else if(map.get(id_pw[0]) && map.get(id_pw[0]) !== id_pw[1]) return 'wrong pw'
    else return 'fail'
}