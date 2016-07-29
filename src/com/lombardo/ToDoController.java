package com.lombardo;

import com.lombardo.model.ToDo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
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
                        System.out.printf("Task %s added %n", task);
                        break;
                    case "complete":

                        break;
                    case "delete":

                        break;
                    case "quit":

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

}
