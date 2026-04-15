/*


in this step we will learn how to share types between frontend and backend 
using turborepo .


-> first we made a new packege called types inside packages folder
-> then we ran npm init -y inside types folder to create a package.json file
-> then in package.json file we added fe things 

"name": "@repo/types",
  "version": "1.0.0",
  "description": "",
  "main": "index.ts",
  "types": "index.ts",

-> then we created a index.ts file inside types folder and added this code

export interface Todo {
  id: number;
  text: string;
}

-> now we can use this type in both frontend and backend by 
importing it from @repo/types

*/
