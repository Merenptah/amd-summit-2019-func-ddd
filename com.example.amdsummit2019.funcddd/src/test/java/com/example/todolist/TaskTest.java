package com.example.todolist;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TaskTest {
  @Test
  public void allows_changing_state() {
    Task task = new Task("id", "desc");

    Task newTask = task.changeStateTo("closed");

    assertThat(newTask.getState()).isEqualTo("closed");
  }

  @Test
  public void returns_new_task_when_changing_state() {
    Task task = new Task("id", "desc");

    Task newTask = task.changeStateTo("closed");

    assertThat(newTask).isNotEqualTo(task);
  }

}