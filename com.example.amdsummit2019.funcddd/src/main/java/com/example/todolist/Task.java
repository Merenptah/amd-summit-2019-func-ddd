package com.example.todolist;

public class Task {
  private final String id;
  private final String description;
  private final String state = "open";

  public Task(String id, String description) {

    this.id = id;
    this.description = description;
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
}
