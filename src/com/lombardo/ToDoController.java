package com.lombardo;

import com.lombardo.model.ToDo;
import com.lombardo.model.ToDoList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ToDoController {
    private ToDoList mList;
    private Map<String, String> mMenu;
    private BufferedReader mReader;

    public ToDoController(ToDoList list) {
        mList = list;
        mMenu = new HashMap<String, String>();
        mReader = new BufferedReader(new InputStreamReader(System.in));

        mMenu.put("view", "view current list");
        mMenu.put("add", "add a task");
        mMenu.put("complete", "mark a task complete");
        mMenu.put("delete", "remove a task");
        mMenu.put("quit", "quit and save the list");
    }

    public void printMenu() {
        for (Map.Entry<String, String> option : mMenu.entrySet()) {
            System.out.printf("%s - %s %n", option.getKey(), option.getValue());
        }
        System.out.printf("%n%n");
        System.out.print("Please choose an option: ");
    }

    public String getUserMenuChoice() throws IOException {
        String choice = mReader.readLine();
        return choice.trim().toLowerCase();
    }

    public void run() {
        String choice = "";
        do {
            try {
                mList.printList();
                System.out.printf("%n");
                printMenu();
                choice = getUserMenuChoice();
                switch (choice) {
                    case "view":
                        mList.printList();
                        break;
                    case "add":
                        System.out.print("Enter Task :");
                        String task = mReader.readLine();
                        mList.addTask(new ToDo(task, false));
                        System.out.printf("Task %s added %n%n%n", task);
                        break;
                    case "complete":
                        System.out.print("Enter number of task to mark complete :");
                        ToDo toDoToComplete = mList.getToDo(promptUserForMenuChoice() - 1);
                        mList.markTaskComplete(toDoToComplete);
                        System.out.printf("Task %s marked complete %n%n%n", toDoToComplete);
                        break;
                    case "delete":
                        System.out.print("Enter number of task to delete :");
                        ToDo toDoToDelete = mList.getToDo(promptUserForMenuChoice() - 1);
                        mList.removeTask(toDoToDelete);
                        System.out.printf("Task %s deleted %n%n%n", toDoToDelete);
                        break;
                    case "quit":
                        System.out.println("See you next time....");
                        System.out.println("Saving list");
                        break;
                    default:
                        System.out.println("whoops please try again");
                }
            } catch (IOException ioe) {
                System.out.println("problem with input");
                ioe.printStackTrace();
            }
        }
        while (!choice.equals("quit"));
    }

    private int promptUserForMenuChoice() throws IOException {
        String taskNumberAsString = mReader.readLine();
        int taskNumber = Integer.parseInt(taskNumberAsString);
        return taskNumber;
    }

}
