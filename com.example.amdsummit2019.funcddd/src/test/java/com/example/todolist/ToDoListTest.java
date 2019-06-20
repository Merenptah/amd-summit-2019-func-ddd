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

  @Test
  public void allows_changing_the_state_of_a_task() {
    ToDoList toDoList = new ToDoList();

    Task task = new Task("task1", "description");
    ToDoList newToDoList = toDoList.addTask(task).changeStateOfTask("task1", "new state");

    assertThat(newToDoList.getTask("task1").get().getState()).isEqualTo("new state");
  }

  @Test
  public void returns_a_new_list_when_changing_the_state_of_a_task() {
    ToDoList toDoList = new ToDoList();

    Task task = new Task("task1", "description");
    ToDoList newToDoList = toDoList.addTask(task).changeStateOfTask("task1", "new state");

    assertThat(newToDoList).isNotEqualTo(toDoList);
  }

  @Test
  public void the_old_list_is_not_changed_when_changing_the_state_of_a_task() {
    Task task = new Task("task1", "description");
    ToDoList toDoList = new ToDoList().addTask(task);

    toDoList.changeStateOfTask("task1", "new state");

    assertThat(toDoList.getTask("task1").get().getState()).isEqualTo("open");
  }

  @Test
  public void allows_undoing_the_last_adding_of_a_task() {
    ToDoList toDoList = new ToDoList();

    Task task = new Task("task1", "description");
    ToDoList newToDoList = toDoList.addTask(task);

    assertThat(newToDoList.undo()).isEqualTo(toDoList);
  }

  @Test
  public void allows_undoing_the_last_changing_of_a_task() {
    Task task = new Task("task1", "description");
    ToDoList toDoList = new ToDoList().addTask(task);

    ToDoList newToDoList = toDoList.changeStateOfTask("task1", "new state");

    assertThat(newToDoList.undo()).isEqualTo(toDoList);
  }
}