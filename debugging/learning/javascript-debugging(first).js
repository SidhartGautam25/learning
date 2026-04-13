/*
we have defined log , promiseTask and asyncTask at the top level , but still they are not global variables ,
they are only accessible within the module scope of this file, 
they are not added to the global object, 
so if we try to access them from another file or from the global scope, we will get a ReferenceError.


In Node:
Every file is wrapped inside a function


*/
