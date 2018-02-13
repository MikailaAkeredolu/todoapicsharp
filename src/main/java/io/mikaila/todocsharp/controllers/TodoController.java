package io.mikaila.todocsharp.controllers;
import io.mikaila.todocsharp.models.TodoItem;
import io.mikaila.todocsharp.services.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping("/api/todo/{id}")
    public ResponseEntity<TodoItem> getById(@PathVariable Long id){
        TodoItem item = todoItemService.getById(id);
        if(item == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(todoItemService.getById(id),HttpStatus.OK);
    }

    @RequestMapping(value = "/api/todo", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody TodoItem todoItem){
        if(todoItem == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        todoItemService.create(todoItem);
        return new ResponseEntity<>(todoItem, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/todo/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody TodoItem todoItem, @PathVariable Long id){
        if(todoItem == null || todoItem.getId() != id) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        todoItemService.update(id,todoItem);
        return new ResponseEntity<>(todoItem, HttpStatus.OK);


    }

    @RequestMapping(value = "/api/todo/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id){
        TodoItem item = todoItemService.getById(id);
        if(item == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        todoItemService.delete(id);
        return new ResponseEntity<TodoItem>(HttpStatus.OK);

    }

}
