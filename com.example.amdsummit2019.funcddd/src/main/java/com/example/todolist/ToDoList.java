package com.example.todolist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ToDoList {
  private Map<String,Task> tasks = new HashMap<>();

  private ToDoList lastToDoList = this;

  public ToDoList() {
  }

  public ToDoList(Map<String, Task> tasks, ToDoList lastToDoList) {
    this.tasks = tasks;
    this.lastToDoList = lastToDoList;
  }

  public List<Task> getTasks() {
    return new ArrayList<>(tasks.values());
  }

  public ToDoList addTask(Task task) {
    Map<String,Task> newTasks = new HashMap<>(tasks);
    newTasks.put(task.getId(), task);

    return new ToDoList(newTasks, this);
  }

  public Optional<Task> getTask(String id) {
    return Optional.ofNullable(this.tasks.get(id));
  }

  public ToDoList changeStateOfTask(String id, String state) {
    Map<String,Task> newTasks = new HashMap<>(tasks);
    Task task = tasks.get(id);
    newTasks.put(id, task.changeStateTo(state));

    return new ToDoList(newTasks, this);
  }

  public ToDoList undo() {
    return lastToDoList;
  }
}
