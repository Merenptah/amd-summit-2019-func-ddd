package com.example.todolist;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ToDoListTest {
  @Test
  public void create_empty_to_do_list() {
    ToDoList toDoList = new ToDoList();

    assertThat(toDoList.getTasks()).isEmpty();
  }

  @Test
  public void allow_adding_new_tasks() {
    ToDoList toDoList = new ToDoList();

    Task task = new Task("task1", "description");
    ToDoList newToDoList = toDoList.addTask(task);

    assertThat(newToDoList.getTasks()).containsExactly(task);
  }

  @Test
  public void a_newly_added_a_task_has_state_open() {
    ToDoList toDoList = new ToDoList();

    Task task = new Task("task1", "description");
    ToDoList newToDoList = toDoList.addTask(task);

    assertThat(newToDoList.getTask("task1").get().getState()).isEqualTo("open");
  }

  @Test
  public void adding_a_task_does_not_change_original_to_do_list() {
    ToDoList toDoList = new ToDoList();

    Task task = new Task("task1", "description");
    ToDoList newToDoList = toDoList.addTask(task);

    assertThat(newToDoList).isNotEqualTo(toDoList);
  }
}