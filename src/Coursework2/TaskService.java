package Coursework2;

import java.time.LocalDate;
import java.util.*;

public class TaskService {
     Map<UUID, Task> taskMap = new HashMap<>();
     Collection<Task> removedTasks = new ArrayList<>();

     public Collection<Task> getRemovedTasks() {
          return removedTasks;
     }

     public void addTask(Task task) {
          taskMap.put(task.getId(), task);
     }

     public Task remove(UUID id) {
           Task task = taskMap.remove(id);
          removedTasks.add(task);
          return task;
     }

     public Collection <Task> getAllByDate (LocalDate date) {
          List <Task> tasks = new ArrayList<>();
          for (Map.Entry<UUID, Task> entry : taskMap.entrySet()) {
               if (entry.getValue().appearsIn(date)) {
                    tasks.add(entry.getValue());
               }
          }
          return tasks;
     }
     public void updateDescription (UUID id, String description) {
          Task task = taskMap.get(id);
          task.setDescription(description);
     }

     public void updateTitle (UUID id, String title) {
          Task task = taskMap.get(id);
          task.setTitle(title);
     }

     public Map <LocalDate, Collection <Task>> getAllGroupByDate () {
          Map <LocalDate, Collection <Task>> groups = new HashMap<>();
          for (Map.Entry<UUID, Task> entry : taskMap.entrySet()) {
               Task task = entry.getValue();
               LocalDate localDate = task.getDateTime();
               Collection <Task> localDateTasks = groups.get(localDate);

               if (localDateTasks == null) {
                    localDateTasks = new ArrayList<>();
                    groups.put(localDate, localDateTasks);
               }

               localDateTasks.add(task);
          }

          return groups;
     }
}



