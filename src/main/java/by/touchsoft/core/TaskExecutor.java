package by.touchsoft.core;

import by.touchsoft.core.util.Calculator;
import by.touchsoft.exception.MappingException;
import by.touchsoft.exception.ProcessingException;
import by.touchsoft.model.Event;

import java.io.FileReader;
import java.io.LineNumberReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TaskExecutor {

    private Parser<Event> parser;

    public TaskExecutor() {
        this.parser = new Parser<>(new Mapper<Event>() {

            protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

            @Override
            public List<Event> map(String buffer, int num) throws MappingException {
                try {
                    if (buffer.isEmpty()) {
                        throw new MappingException("Line is blank", num);
                    }

                    String[] times = buffer.split("\\s+");

                    if (times.length != 2) {
                        throw new MappingException("Check number of times", num);
                    }

                    LocalTime entry = LocalTime.parse(times[0], formatter);
                    LocalTime leave = LocalTime.parse(times[1], formatter);

                    if (entry.isAfter(leave)) {
                        throw new MappingException("Check entry and leave time", num);
                    }

                    Event e1 = new Event(entry, Event.Type.IN);
                    Event e2 = new Event(leave, Event.Type.OUT);

                    return Arrays.asList(e1, e2);
                } catch (MappingException e) {
                    throw e;
                } catch (Exception e) {
                    throw new MappingException(num, e);
                }
            }
        });
    }

    public int execute(String arg) {
        try (FileReader fileReader = new FileReader(arg);
             LineNumberReader lineNumberReader = new LineNumberReader(fileReader)) {

            System.out.println("File: " + arg + " processing started");

            List<Event> events = parser.parse(lineNumberReader);
            int maxNumber = Calculator.calcMaxNumOfEmployees(events);

            System.out.println("File: " + arg + " processing finished");

            return maxNumber;
        } catch (Throwable e) {
            throw new ProcessingException(arg, e);
        }
    }
}
