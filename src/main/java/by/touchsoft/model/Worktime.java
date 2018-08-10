package by.touchsoft.model;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

public class Worktime implements Serializable {

    private static final long serialVersionUID = 8512384017577023423L;

    private LocalTime in;
    private LocalTime out;

    public Worktime(LocalTime in, LocalTime out) {
        this.in = in;
        this.out = out;
    }

    public LocalTime getIn() {
        return in;
    }

    public LocalTime getOut() {
        return out;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worktime worktime = (Worktime) o;
        return Objects.equals(in, worktime.in) &&
                Objects.equals(out, worktime.out);
    }

    @Override
    public int hashCode() {

        return Objects.hash(in, out);
    }

    @Override
    public String toString() {
        return "Worktime{" +
                "in=" + in +
                ", out=" + out +
                '}';
    }
}
