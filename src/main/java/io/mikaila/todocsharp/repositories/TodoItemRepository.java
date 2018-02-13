package io.mikaila.todocsharp.repositories;

import io.mikaila.todocsharp.models.TodoItem;
import org.springframework.data.repository.CrudRepository;

public interface TodoItemRepository extends CrudRepository<TodoItem, Long> {

}
