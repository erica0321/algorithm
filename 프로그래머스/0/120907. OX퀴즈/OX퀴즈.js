function solution(quizs) {
    let answer = [];
    for(let quiz of quizs) {
        const arr = quiz.split(" ");
        const left = Number(arr[0]);
        const right = Number(arr[2]);
        const result = Number(arr[4]);
        const oper = arr[1];
        
        let operResult = 0;
        if(oper === '-') {
            operResult = left - right;
        } else if(oper === '+') {
            operResult = left + right;
        }
        console.log(operResult)
        console.log(result);
        if(operResult === result) {
            answer.push("O");
        } else {
            answer.push("X")
        }
    }
    
    return answer;
}