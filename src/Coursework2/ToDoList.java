package Coursework2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

class TodoListApp {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> todoList = new ArrayList<>();

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        printInstructions();

        mainLoop();
    }

    private static void printInstructions() {
        System.out.println("ToDoList Creator - Create to do lists using Java.");
        System.out.println("Coursework2.Type '!view' to exit and view your list.");
        System.out.println("Enter your tasks in the line below.");
    }

    private static void mainLoop() {
        while (true) {
            printLineStart();

            String command = readCommand();

            if (isViewListCommand(command)) {
                printList();
                break;
            } else {
                addToTodoList(command);
            }
        }
    }

    private static void printLineStart() {
        System.out.print("-: ");
    }

    private static String readCommand() {
        return sc.nextLine();
    }

    private static boolean isViewListCommand(String command) {
        return command.equals("!view");
    }

    private static void printList() {
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy/MM/dd");
        Calendar currentDate = Calendar.getInstance();
        System.out.println("List's Date: " + simpleDate.format(currentDate.getTime()));

        for (int listSize = 0; listSize != todoList.size(); listSize++) {
            System.out.println(listSize + 1 + ". " + todoList.get(listSize));
        }
    }

    private static void addToTodoList(String item) {
        todoList.add(item);
    }
}