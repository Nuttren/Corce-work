package Coursework2;

import java.time.LocalDate;

public class MonthlyTask extends Task {
    public MonthlyTask(String title, LocalDate dateTime, String description, Type type) {
        super(title, dateTime, description, type);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return getDateTime().getDayOfMonth() == date.getDayOfMonth();
    }
}
