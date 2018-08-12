package by.touchsoft.model;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

public class Event implements Serializable, Comparable<Event> {

    public enum Type {
        IN,
        OUT
    }

    private static final long serialVersionUID = 8512384017577023423L;

    private LocalTime time;
    private Type type;

    public Event(LocalTime time, Type type) {
        this.time = time;
        this.type = type;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(time, event.time) &&
                type == event.type;
    }

    @Override
    public int hashCode() {

        return Objects.hash(time, type);
    }

    @Override
    public String toString() {
        return "Event{" +
                "time=" + time +
                ", type=" + type +
                '}';
    }

    @Override
    public int compareTo(Event other) {
        int cmp = time.compareTo(other.time);
        if (cmp == 0) {
            cmp = type.compareTo(other.type);
        }
        return cmp;
    }
}
