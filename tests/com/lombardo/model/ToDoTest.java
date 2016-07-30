package com.lombardo.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ToDoTest {
    private ToDo toDo;

    @Before
    public void setUp() throws Exception {
        toDo = new ToDo("Walk the dog", false);
    }

    @Test
    public void getDescription() throws Exception {
        assertEquals("Walk the dog", toDo.getDescription());
    }

    @Test
    public void setDescription() throws Exception {
        toDo.setDescription("Feed the cat");

        assertEquals("Feed the cat", toDo.getDescription());
    }

    @Test
    public void isComplete() throws Exception {
        assertEquals(false, toDo.isComplete());
    }

    @Test
    public void markComplete() throws Exception {
        toDo.markComplete();

        assertEquals(true, toDo.isComplete());
    }

}