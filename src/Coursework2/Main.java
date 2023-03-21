package Coursework2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object

        while (true) {
            try {
                Task task = readTaskFromConsole(scanner);
                System.out.println(task.toString());
                taskService.addTask(task);
            } catch (Exception e) {
                System.out.println("Error: " + e.toString());
            }

            System.out.println("Do u want to add another task: Yes / No:");
            String add = scanner.nextLine();  // Read user input
            if (!add.equalsIgnoreCase("Yes")) {
                break;
            }
        }

        System.out.println("Do u want to update title and description: Yes / No:");
        String updateTask = scanner.nextLine();
        if (updateTask.equalsIgnoreCase("Yes")) {
            System.out.println("Enter taskID to update:");
            UUID id = readId(scanner);
            String title = readTtitle(scanner);
            String description = readDescription(scanner);
            taskService.updateDescription(id, description);
            taskService.updateTitle(id, title);
        }

        System.out.println("All tasks by dates:");
        Map<LocalDate, Collection <Task>> allTasksByDates = taskService.getAllGroupByDate();
        for (Map.Entry<LocalDate, Collection <Task>> entry : allTasksByDates.entrySet()) {
            LocalDate localDate = entry.getKey();
            Collection <Task> localDateTasks = entry.getValue();
            System.out.println("Date:" + localDate);
            for (Task t : localDateTasks) {
                System.out.println(t.toString());
            }
        }

            System.out.println("Today`s tasks:");
        Collection<Task> todayTasks = taskService.getAllByDate(LocalDate.now());
        for (Task t : todayTasks) {
            System.out.println(t.toString());
            taskService.remove(t.getId());
        }

        System.out.println("Removed tasks:");
        Collection<Task> removedTasks = taskService.getRemovedTasks();
        for (Task t : removedTasks) {
            System.out.println(t.toString());
        }


    }

    private static UUID readId (Scanner scanner) {
        System.out.println("Enter Id");

        String uuid = scanner.nextLine();  // Read user input
        return UUID.fromString(uuid);
    }

    private static LocalDate readDate(Scanner scanner) throws IllegalArgumentException {
        System.out.println("Enter date in format: yyyy-MM-dd");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(scanner.nextLine(), formatter);
        System.out.println("Date is: " + localDate);  // Output user input

        return localDate;
    }

    private static Type readType(Scanner scanner) throws IllegalArgumentException {
        System.out.println("Enter type, work or personal");

        String type = scanner.nextLine();  // Read user input
        if (!type.equalsIgnoreCase("WORK") && !type.equalsIgnoreCase("PERSONEL")) {
            throw new IllegalArgumentException(type);
        }
        System.out.println("Type is: " + type);  // Output user input
        return Type.valueOf(type.toUpperCase());
    }

    private static String readSchedule(Scanner scanner) throws IllegalArgumentException {
        System.out.println("Enter schedule: OneTime, DailyTask, WeeklyTask, MonthlyTask or YearlyTask");

        String schedule = scanner.nextLine();  // Read user input
        if (!schedule.equalsIgnoreCase("OneTime") &&
                !schedule.equalsIgnoreCase("DailyTask") &&
                !schedule.equalsIgnoreCase("WeeklyTask") &&
                !schedule.equalsIgnoreCase("MonthlyTask") &&
                !schedule.equalsIgnoreCase("YearlyTask")
        ) {
            throw new IllegalArgumentException(schedule);
        }
        System.out.println("Schedule is: " + schedule);  // Output user input
        return schedule;
    }

    private static String readTtitle(Scanner scanner) {
        System.out.println("Enter title");
        String title = scanner.nextLine();  // Read user input
        System.out.println("Title is: " + title);  // Output user input
        return title;

    }

    private static String readDescription (Scanner scanner) {
        System.out.println("Enter description");

        String description = scanner.nextLine();  // Read user input
        System.out.println("Description is: " + description);  // Output user input
        return description;
    }

    private static Task readTaskFromConsole(Scanner scanner) throws IllegalArgumentException {

        String title = readTtitle(scanner);
        String description = readDescription(scanner);

        Type type = readType(scanner);
        String schedule = readSchedule(scanner);
        LocalDate localDate = readDate(scanner);

        Task task = null;
        if (schedule.equalsIgnoreCase("OneTime")) {
            task = new OneTimeTask(title, localDate, description, type);
        } else if (schedule.equalsIgnoreCase("DailyTask")) {
            task = new DailyTask(title, localDate, description, type);
        } else if (schedule.equalsIgnoreCase("WeeklyTask")) {
            task = new WeeklyTask(title, localDate, description, type);
        } else if (schedule.equalsIgnoreCase("MontlyTask")) {
            task = new MonthlyTask(title, localDate, description, type);
        } else if (schedule.equalsIgnoreCase("YearlyTask")) {
            task = new YearlyTask(title, localDate, description, type);
        }
        return task;
    }
}
