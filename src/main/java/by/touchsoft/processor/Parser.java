package by.touchsoft.processor;

import by.touchsoft.model.Worktime;

import java.io.IOException;
import java.io.LineNumberReader;
import java.util.LinkedList;
import java.util.List;

public class Parser {

    private LineMapper<Worktime> lineMapper;

    public Parser(LineMapper<Worktime> lineMapper) {
        this.lineMapper = lineMapper;
    }

    public List<Worktime> parse(LineNumberReader reader) throws IOException {
        List<Worktime> worktimes = new LinkedList<>();
        String line;

        while ((line = reader.readLine()) != null) {
            System.out.println("Line [" + reader.getLineNumber() + "]: " + line);
            Worktime worktime = lineMapper.map(line);
            if (worktime != null) {
                worktimes.add(worktime);
            }
        }

        return worktimes;
    }
}
