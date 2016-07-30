package com.lombardo.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private List<ToDo> mList;

    public ToDoList() {
        mList = new ArrayList<ToDo>();
    }

    public int getLength() {
        return mList.size();
    }

    public void addTask(ToDo todo) {
        mList.add(todo);
    }

    public void markTaskComplete(ToDo toDo) {
        int currentToDoIndex = mList.indexOf(toDo);
        ToDo currentToDo = mList.get(currentToDoIndex);
        currentToDo.markComplete();
    }

    public ToDo getToDo(int index) {
        return mList.get(index);
    }

    public void removeTask(ToDo todo) {
        mList.remove(todo);
    }

    public void printList() {
        int counter = 1;
        for (ToDo todo : mList) {
            String status;
            if (todo.isComplete()) {
                status = "[ X ]";
            } else {
                status = "[   ]";
            }
            System.out.printf("%d - %s %s %n", counter, status, todo.getDescription());
            counter++;
        }
        System.out.printf("%n%n");
    }

    public void populateFrom(String filename) {
        try (
                FileInputStream fis = new FileInputStream(filename);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] args = line.split("\\|");
                ToDo toDo = new ToDo(args[0], convertStringToBoolean(args[1]));
                addTask(toDo);
            }
        } catch (IOException ioe) {
            System.out.printf("Problems loading %s %n", filename);
            ioe.printStackTrace();
        }
    }

    public void saveTo(String filename) {
        try (
                FileOutputStream fos = new FileOutputStream(filename);
                PrintWriter writer = new PrintWriter(fos);
        ) {
            for (ToDo todo : mList) {
                writer.printf("%s|%s%n",
                        todo.getDescription(),
                        todo.isComplete());
            }
        } catch (IOException ioe) {
            System.out.printf("Problem saving %s %n", filename);
            ioe.printStackTrace();
        }
    }

    private Boolean convertStringToBoolean(String string) {
        Boolean result;
        if (string.equals("true")) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
