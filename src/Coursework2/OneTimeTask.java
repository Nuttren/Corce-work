package Coursework2;

import java.time.LocalDate;

public class OneTimeTask extends Task {
    public OneTimeTask( String title, LocalDate dateTime, String description, Type type) {
        super(title, dateTime, description, type);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return getDateTime().equals(date);
    }
}
