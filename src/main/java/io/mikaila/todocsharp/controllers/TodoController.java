package io.mikaila.todocsharp.controllers;
import io.mikaila.todocsharp.models.TodoItem;
import io.mikaila.todocsharp.services.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    private TodoItemService todoItemService;
    TodoItem todoItem = new TodoItem();

    @Autowired
    public TodoController(TodoItemService todoItemService){
        this.todoItemService = todoItemService;
        if(todoItem.getId() == null){
            todoItemService.create(new TodoItem("Item1",false));
        }
    }



    @RequestMapping("/api/todo")
    public List<TodoItem> getAll(){
        return todoItemService.getAll();
    }


//TO do ------------------------------------------------
    @RequestMapping("/api/todo/{id}")
    public TodoItem getById(@PathVariable Long id){
        return todoItemService.getById(id);
    }
//TO do ------------------------------------------------



    @RequestMapping(value = "/api/todo", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody TodoItem todoItem){
        if(todoItem == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        todoItemService.create(todoItem);
        return new ResponseEntity<>(todoItem, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/api/todo/{id}", method = RequestMethod.PUT)
    public void update(@RequestBody TodoItem todoItem, @PathVariable Long id){
        todoItemService.update(id,todoItem);
    }



    @RequestMapping(value = "/api/todo/{id}", method = RequestMethod.DELETE)
    public void  delete(@PathVariable Long id){
        todoItemService.delete(id);
    }












    // public ResponseEntity<TodoItem> getById(@PathVariable Long id){
//    List<TodoItem> todoItems = new ArrayList<>();
//        for (TodoItem t: todoItems) {
//        if(t.getId() ==){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//    }
//        return new ResponseEntity<>(todoItemService.getById(id),HttpStatus.OK);



//    @Autowired
//    private TodoItemService todoItemService;

// if(this.todoItemService.equals(null)){
//            this.todoItemService.create(new TodoItem("Item1",true));
//        }

//        List<TodoItem> todoItems = new LinkedList<>();
//        for(int x = 0; x < todoItems.size(); x++){
//            if(todoItems.get(x) == null ){
//                return HttpStatus.NOT_FOUND;
//            }
//            return new TodoItem(id);
//        }



//    private TodoItemService _context;
//
//    public TodoController(TodoItemService  _context) {
//        this._context = _context;
//        if(_context.equals(0)){
//            _context.
//        }
//    }







}
