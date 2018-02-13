package io.mikaila.todocsharp.services;
import io.mikaila.todocsharp.models.TodoItem;
import io.mikaila.todocsharp.repositories.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoItemService {

    @Autowired
    TodoItemRepository todoItemRepository;

    public List<TodoItem> getAll() {
        List<TodoItem> topics = new ArrayList<>();
        todoItemRepository.findAll().forEach(topics::add);
        return topics;
    }

    public TodoItem getById(Long id){
        return todoItemRepository.findOne(id);
    }


    public void create(TodoItem todoItem){
        todoItemRepository.save(todoItem);
    }

    public void update(Long id, TodoItem todoItem){
        todoItemRepository.save(todoItem);
    }


    public void delete(Long id) {
        todoItemRepository.delete(id);
    }
}
