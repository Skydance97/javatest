package by.touchsoft.core;

import by.touchsoft.exception.MappingException;

import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class Parser<T> {

    private Mapper<T> mapper;

    public Parser(Mapper<T> mapper) {
        this.mapper = mapper;
    }

    public List<T> parse(LineNumberReader lineNumberReader) throws IOException {
        List<T> objects = new ArrayList<>();
        String line;

        while ((line = lineNumberReader.readLine()) != null) {
            try {
                List<T> mapped = mapper.map(line, lineNumberReader.getLineNumber());
                objects.addAll(mapped);
            } catch (MappingException e) {
                e.printStackTrace();
            }
        }

        return objects;
    }
}
