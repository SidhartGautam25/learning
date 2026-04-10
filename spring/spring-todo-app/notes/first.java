/*
// ABOUT App.java code 

ApplicationContext context =
    new ClassPathXmlApplicationContext("applicationContext.xml");

-> This line first read the xml file and then find all the bean defination
-> then it creates the object of all the bean and then it injects the dependencies
-> and store the reference of all the bean in the container (in memory you can say )
   and then if we ask , it will return the reference of the container to the context 
   variable

TodoService service = context.getBean("todoService", TodoService.class);

-> this line is asking the container to give the reference of the bean with name "todoService"
   and also we are telling that the type of the bean is TodoService
   so it will return the reference of the bean to the service variable


*/


/*

// about applicationContext.xml code

-> here we list all bean defination and also we tell the container about the dependencies of the bean
   so that it can inject the dependencies while creating the object of the bean

-> like 
<bean id="todoService" class="com.navneet.todo.TodoService" />



// about TodoService.java code
-> here we are creating a simple class with a method whose control we will give to spring container
-> and then we will call this method of class in app.java 









 */