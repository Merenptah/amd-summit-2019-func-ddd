package com.example.todolist;

import org.junit.Test;

import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.strings;

public class ToDoListWithGeneratorsTest {
  @Test
  public void allows_adding_tasks_where_description_contains_no_at_symbol() {
    qt().forAll(
        strings().basicLatinAlphabet().ofLengthBetween(0,100)
    ).check((String description) -> {
      ToDoList toDoList = new ToDoList();
      Task task = new Task("id", description);

      return "open".equals(toDoList.addTask(task).getTask("id").get().getState());
    });
  }
}