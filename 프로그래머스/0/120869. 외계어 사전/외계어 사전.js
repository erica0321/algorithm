function solution(spell, dic) {
    const spellSorted = spell.sort().join('');

    for (let word of dic) {
        if (word.split('').sort().join('') === spellSorted) {
            return 1;
        }
    }
    
    return 2;
}
