package by.touchsoft.processor;

import by.touchsoft.model.Worktime;
import by.touchsoft.exception.ProcessingException;
import org.apache.commons.lang3.StringUtils;

import java.io.FileReader;
import java.io.LineNumberReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Processor {

    private Parser parser;
    private Calculator calculator;

    public Processor() {
        this.parser = new Parser(line -> {
            String[] times = StringUtils.split(line);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime in = LocalTime.parse(times[0], formatter);
            LocalTime out = LocalTime.parse(times[1], formatter);
            if (!in.isAfter(out)) {
                return new Worktime(in, out);
            } else {
                return new Worktime(out, in);
            }
        });
        this.calculator = new Calculator();
    }

    public int process(String arg) {
        try (FileReader fileReader = new FileReader(arg);
             LineNumberReader lineReader = new LineNumberReader(fileReader)) {
            List<Worktime> worktimes = parser.parse(lineReader);
            return calculator.calculate(worktimes);
        } catch (Throwable e) {
            throw new ProcessingException("Can't process file", e);
        }
    }
}
