/*
 * 
 * 
 * in this step we only added controller , service and repository for creating a
 * new todo item
 * 
 * 
 * -> then in this step we are adding the controller to give json response
 * for the list of todos
 * -> so we have added jackson dependency in pom.xml and then we have
 * added @ResponseBody annotation to the controller method
 * 
 * List<Todo>
 * ↓
 * Spring detects return type
 * ↓
 * HttpMessageConverter kicks in
 * ↓
 * Jackson converts → JSON
 * ↓
 * Response sent to client
 * 
 * 
 * 
 * 
 * 
 */
