/* This code is from https://code-maven.com/slides/javascript-programming/solution-hello-world*/

"use strict";

function helloWorldFunction() {
    document.getElementById('subPageContainer').innerHTML = 'Hello World';
    return false;
}

document.getElementById('testButton').addEventListener('click', helloWorldFunction);