package Coursework2;

import java.time.LocalDate;

public class DailyTask extends Task {
    public DailyTask(String title, LocalDate dateTime, String description, Type type) {
        super(title, dateTime, description, type);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return true;
    }
}
