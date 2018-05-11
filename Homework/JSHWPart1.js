/* Fill in the functions below and submit them in a file called JSHWPart1.js. 
Due 5pm Friday, May 11
*/

var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function (n) {
    if (n < 2) { return n; }
    else return homework.fibonacci(n - 1) + homework.fibonacci(n - 2);
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function (array) {
    var i;
    for (i = 0; i < array.length; i++)

        if (array[i] > array[i + 1]) {
            var x = array[i];
            array.splice(i, 1);
            array.push(x);
            homework.sort(array);
        }
    return;
};

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function (n) {
    if (n < 2) { return 1; }
    return (n * homework.factorial(n - 1));
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function (array, n) {
    while (n > 0) {
        array.push(array[0]);
        array.shift();
        n--;
    }
    return array;
};

/*
 5. Balanced Brackets

 A bracket is any one of the following: (, ), {, }, [, or ]

 The following are balanced brackets:
    ()
    ()()
    (())
    ({[]})
    {}(())
    (({}[][]()))

 The following are NOT balanced brackets:
 (
 )
 (()
 ([)]

 Return true if balanced
 Return false if not balanced
*/
homework.balancedBrackets = function (bracketsString) {

    var start = { '[': ']', '{': '}', '(': ')' };
    var end = { ']': '[', '}': '{', ')': '(' };
    var i = 1;
    arr = [];
    while (bracketsString.length > 0) {
        //console.log("loop");
        if (start[bracketsString[0]]) {
            arr.push(bracketsString[0]);
            bracketsString = bracketsString.substr(1);

        } else if ((end[bracketsString[0]]) == (arr[arr.length - 1])) {
            arr.pop();
            bracketsString = bracketsString.substr(1);
            if ((bracketsString.length == 0) && (arr.length == 0)) {
                return true;
            } else if ((bracketsString.length == 0) && (arr.length != 0)) {
                return false;
            }
        } else {
            return false;
        }
        i++;
    } return false;
};

//YOUR SOLUTIONS, NOT STACKOVERFLOW’S  ;)}
