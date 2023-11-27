var backspace = 8;
var shift = 16;
var aCode = 65;
var zCode = 90;
var zero = 48;
var nine = 57;

/**
 * 입력된 값이 로마자나 숫지인지 체크
 */
function onlyAlphabetAndNum(char) {
    if (char == backspace || char == shift) {
        return true;
    }
    if (e.keyCode >= aCode && e.keyCode <= zCode) {
        return true;
    }
    if (e.keyCode >= zero && e.keyCode <= nine) {
        return true;
    }
    return false;
}

/**
 * 영문 대문자, 소문자, 숫자가 전부 있는지 체크.
 */
function allLetterChecker(val) {
    let arr = [...val];
    let upper = false;
    let lower = false;
    let number = false;
    
    for (var i in arr) {
        if (arr[i] >= 'A' && arr[i] <= 'Z') {
            upper = true;
            continue;
        }
        if (arr[i] >= 'a' && arr[i] <= 'z') {
            lower = true;
            continue;
        }
        if (arr[i] >= 0 && arr[i] <= 9) {
            number = true;
        }
    }
    
    return upper && lower && number;
}