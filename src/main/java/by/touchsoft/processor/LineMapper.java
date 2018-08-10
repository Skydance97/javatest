package by.touchsoft.processor;

@FunctionalInterface
public interface LineMapper<T> {

    T map(String line);
}
