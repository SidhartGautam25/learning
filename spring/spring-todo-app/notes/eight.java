/*
 * in this step we will transform POST /todos?title=abc ❌
 * to this POST /todos with body { "title": "abc" } ✅
 * 
 * for this , we dont need to change anything in the service and repository
 * layer but we need to change the controller layer to accept the request body
 * instead of query param
 * 
 * -> Earlier
 * 
 * @PostMapping("/todos")
 * 
 * @ResponseBody
 * public String createTodo(@RequestParam String title) {
 * todoService.createTodo(title);
 * return "Todo created!";
 * }
 * -> Now
 * 
 * @PostMapping("/todos")
 * 
 * @ResponseBody
 * public String createTodo(@RequestBody Todo todo) {
 * todoService.createTodo(todo.getTitle());
 * return "Todo created!";
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */