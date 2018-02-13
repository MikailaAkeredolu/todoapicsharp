package io.mikaila.todocsharp.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String name;

    @JsonProperty
    private boolean isComplete;

    public TodoItem(){

    }

    public TodoItem(String name, boolean isComplete) {
        this.name = name;
        this.isComplete = isComplete;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", isComplete=" + isComplete +
                '}';
    }
}
