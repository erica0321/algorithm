function solution(my_string) {
    let arr = [];
    my_string.split("").map((e) => {
        if(e.match(/\d+/g)) {
            arr.push(Number(e))
        }
    })
    
    return arr.sort();
}
