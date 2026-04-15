/*

In this step we will setup our turborepo and move our frontend and backend into it .

1. First we will create a new turborepo using the command `npx create-turbo@latest`
   and follow the prompts to create a new turborepo .
2. Then we will move our frontend and backend into the `apps` folder of our turborepo .
3. After that we will update the package.json files of both frontend and backend 
   to use the new paths .
4. Finally we will run both frontend and backend using the command `npm run dev` from 
   the root of our turborepo .


command 1 -> inside turbo-todo , we are running command -> npx create-turbo@latest todo-turbo

// it create a folder structure for us , two folders are important , apps and packages

apps/web -> this is our frontend ( nextjs app)
packages/ui -> this is our shared ui components 


turbo-json -> this is the configuration file for our turborepo , 
           -> this is where we define our tasks and dependencies between them .
           -> here only we define our caching rules and how to run our tasks .


in package.json file , we can see this {
  "workspaces": ["apps/*", "packages/*"]
}

this tells the package manager ( npm or yarn ) that we have two workspaces ,
 one for our apps and one for our packages .
 and treat everything inside apps and packages as one system and install dependencies accordingly .


 now when we go inside learning/turbo-repo/todo-turbo , we can run `npm install` to install 
 all dependencies for both frontend and backend.

 -> apart from that it will links internal packages together
 -> create a single node_modules folder for both frontend and backend
 -> and also create a single lock file for both frontend and backend

 -> now to run the repo , we have this command -> npx turbo run dev

 this command will run the dev script for both frontend and backend in parallel and also 
 take care of caching and dependencies between them .

 -> internally turborepo 
 1. Scans all package.json files
 2. Finds scripts named dev
 3. Builds dependency graph
 4. Runs them in parallel


 Till now we have not added anything related to express , lets do it 
 -> first we will make a api folder inside apps
 -> then we we will move inside apps/api and run npm init -y and npm install express cors
 -> then in apps/api/index.js we will add the code for our express server
 -> then in package.json file of api we will add this line in scripts
  " dev": "node index.js"

 -> now we can run `npx turbo run dev` from the root of our turborepo ,
    it will run both frontend and backend in parallel .

 -> now if in root package.json file we add this line in scripts
  " dev": "npx turbo run dev"

 then we can run `npm run dev` from the root of our turborepo to run both frontend and backend in parallel .
 -> in next part we will see how to share types between frontend and backend using 
    turborepo and also how to use caching to speed up our development process .


*/
