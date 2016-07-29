package com.lombardo;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ToDoList list = new ToDoList();
        list.populateFrom("list.txt");
        ToDoController controller = new ToDoController(list);
        controller.run();
        list.saveTo("list.txt", list);
    }
}
