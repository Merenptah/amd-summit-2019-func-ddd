package com.example.todolist;

public class Task {
  private final String id;
  private final String description;
  private final String state;

  public Task(String id, String description) {
    this(id, description, "open");
  }

  private Task(String id, String description, String state) {
    this.id = id;
    this.description = description;
    this.state = state;
  }

  public String getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public String getState() {
    return state;
  }

  public Task changeStateTo(String state) {
    return new Task(id, description, state);
  }
}
