package com.example.todolist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ToDoList {
  private Map<String,Task> tasks = new HashMap<>();

  public ToDoList() {
  }

  public ToDoList(Map<String,Task> tasks) {
    this.tasks = tasks;
  }

  public List<Task> getTasks() {
    return new ArrayList<>(tasks.values());
  }

  public ToDoList addTask(Task task) {
    Map<String,Task> newTasks = new HashMap<>(tasks);
    newTasks.put(task.getId(), task);

    return new ToDoList(newTasks);
  }

  public Optional<Task> getTask(String id) {
    return Optional.ofNullable(this.tasks.get(id));
  }

  public ToDoList changeStateOfTask(String id, String state) {
    Map<String,Task> newTasks = new HashMap<>(tasks);
    Task task = tasks.get(id);
    newTasks.put(id, task.changeStateTo(state));

    return new ToDoList(newTasks);
  }
}
