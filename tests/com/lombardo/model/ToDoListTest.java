package com.lombardo.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ToDoListTest {
    private ToDoList list;
    private ToDo toDo1;
    private ToDo toDo2;

    @Before
    public void setUp() throws Exception {
        list = new ToDoList();
        toDo1 = new ToDo("Walk the dog", false);
        toDo2 = new ToDo("Eat a hot dog", false);
    }

    @Test
    public void addTask() throws Exception {
        list.addTask(toDo1);

        assertEquals(1, list.getLength());
    }

    @Test
    public void markTaskComplete() throws Exception {
        list.addTask(toDo1);
        list.markTaskComplete(toDo1);

        assertEquals(true, toDo1.isComplete());
    }

    @Test
    public void getToDo() throws Exception {
        list.addTask(toDo1);

        assertEquals(toDo1, list.getToDo(0));
    }

    @Test
    public void removeTask() throws Exception {
        list.addTask(toDo1);
        list.addTask(toDo2);
        list.removeTask(toDo1);

        assertEquals(toDo2, list.getToDo(0));
    }

}