package com.example.todolist;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ToDoListTest {
  @Rule
  public MockitoRule rule = MockitoJUnit.rule();

  @Test
  public void create_empty_to_do_list() {
    ToDoList toDoList = new ToDoList();

    assertThat(toDoList.getTasks()).isEmpty();
  }
}