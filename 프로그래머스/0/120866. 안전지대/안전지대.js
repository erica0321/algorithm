function solution(board) {
    const dx= [-1, -1, -1, 0, 0, 1, 1, 1];
    const dy = [-1, 0, 1, -1, 1, -1, 0, 1];
    
    const N = board.length;
    const danger = JSON.parse(JSON.stringify(board));
    
    for(let x = 0; x < N; x++) {
        for(let y = 0; y< N; y++) {
            if(!board[x][y]) continue;
            
            for(let i =0; i<8; i++) {
                const nx = x + dx[i];
                const ny = y + dy[i];
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                danger[nx][ny] = 1;
            }
        }
    }
    
    const count = danger.flat().filter(d => d).length;
    
    return N**2 - count;
}