package Coursework2;

import java.time.LocalDate;

public class WeeklyTask extends Task {
    public WeeklyTask(String title, LocalDate dateTime, String description, Type type) {
        super(title, dateTime, description, type);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return getDateTime().getDayOfWeek().equals(date.getDayOfWeek());
    }
}
