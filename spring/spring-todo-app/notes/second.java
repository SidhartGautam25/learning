/*
-> in this step we will create repository layer of our application 
-> after that we will inject it into Service layer ( TodoService here )
-> and then we will see how spring wire everything together 



 */

/*

<bean id="todoService" class="com.navneet.todo.TodoService">
        <constructor-arg ref="todoRepository" />
</bean>

-> Hey Spring — when creating TodoService, use THIS bean (todoRepository) as the 
   constructor argument.

-> now to understand updated TodoService.java code which uses DI concept
   in short we are telling spring that when you create the object of TodoService then 
   inject the object of TodoRepository in the constructor of TodoService
   so that we can use the object of TodoRepository in the method of TodoService

-> two good questions to ask here are -> why we need to mention about the dependency in the xml
   file if we are in service class ony telling which class to use 

-> and second question is we are by ourself only attahing the object like 
    this.todoRepository = todoRepository;
    then how we are using the concept of DI 

// Answers

-> answer to first question
   this line -> public TodoService(TodoRepository todoRepository)
   only tells -> If someone creates me, they MUST give me a TodoRepository
   BUT , it does not say 
   -> where to get it
   -> how to create it
   -> which implementation to use

   then this line -> <constructor-arg ref="todoRepository" />
   says that -> Hey Spring — when creating TodoService, use THIS bean

-> also to understand how di is helping here and how we have to do if we have
   not used the concept of di , then how it looks like and how that is not good
   and how this approach is better , these things we will see later 








 */