/*

Currently we are doing constructer injection for the service layer. 
We can also do setter injection. 
In that case, we will have to add a default constructor in the service class 
and then add a setter method for the repository. 
Then we can use the setter method to inject the repository bean into the service bean 
in the applicationContext.xml file.


our current code is constructor injection which looks like this

public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
}

and in the applicationContext.xml file we have

<constructor-arg ref="todoRepository" />


now with setter injection, the code will look like this

package com.navneet.todo;

public class TodoService {

    private TodoRepository todoRepository;

    // Setter method
    public void setTodoRepository(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void printTodos() {
        System.out.println("Service layer...");
        todoRepository.fetchTodos();
    }
}

and in the applicationContext.xml file we will have

<property name="todoRepository" ref="todoRepository" />

-> now why use this approach of setter injection over constructor injection or 
   vice versa is a matter of design choice and depends on the specific use case.




 */

/*

lets understand both design better

when we write this 

public class TodoService {

    private TodoRepository repo;

    public TodoService(TodoRepository repo) {
        this.repo = repo;
    }
}

then java says -> To create this object, you MUST provide repo
-> so writing this -> new TodoService(); // ❌ compile error 
-> writing this will only work -> new TodoService(new TodoRepository()); // ✅ works fine
-> meaning that object cannot exist without the dependency
-> nodejs equivalent

class TodoService {
  constructor(repo) {
    this.repo = repo;
  }
}

-> now we will understand why setter injection makes it optional

this code 

public class TodoService {

    private TodoRepository repo;

    public void setTodoRepository(TodoRepository repo) {
        this.repo = repo;
    }
}

-> here we can think that internally java is doing things in two step

step 1 -> TodoService service = new TodoService(); // ✅ allowed
step 2 -> service.setTodoRepository(new TodoRepository()); // ✅ allowed

-> and since in first step we are able to create the object of TodoService without 
   providing the dependency so it is optional to provide the dependency in setter injection
   approach

-> now lets understand the null behaviour of both design
-> in first code -> service.setTodoRepository(new TodoRepository());
-> since we are passing repo service 
-> imediately after creation service.repo != null ✅

-> but since in setter injection we can think passing is secondary and happen
   in second step it may be possible service.repo == null ❌





 */