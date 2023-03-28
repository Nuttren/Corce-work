package Coursework2;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public abstract class Task{
    private UUID idGenerator;
    private String title;
    private UUID id;
    private LocalDate dateTime;
    private String description;


    public Task (String title, LocalDate dateTime, String description, Type type) {
        this.idGenerator = UUID.randomUUID();
        this.title = title;
        this.id = idGenerator;
        this.dateTime = dateTime;
        this.description = description;

    }

    public abstract boolean appearsIn (LocalDate date);

    public String getTitle() {
        return title;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id &&
                Objects.equals(idGenerator, task.idGenerator) &&
                Objects.equals(title, task.title) &&
                Objects.equals(dateTime, task.dateTime) &&
                Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGenerator, title, id, dateTime, description);
    }

    @Override
    public String toString() {
        return "Coursework2.Task{" +
                "Заголовок ='" + title + '\'' +
                ", id=" + id +
                ", dateTime=" + dateTime +
                ", Описание='" + description + '\'' +
                '}';
    }

}
