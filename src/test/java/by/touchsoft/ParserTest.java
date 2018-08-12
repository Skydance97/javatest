package by.touchsoft;

import by.touchsoft.core.Mapper;
import by.touchsoft.core.Parser;
import by.touchsoft.exception.MappingException;
import by.touchsoft.model.Event;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ParserTest {

    private static ClassLoader classLoader = ParserTest.class.getClassLoader();

    private Mapper<Event> mapper = new Mapper<Event>() {
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
    };
    private Parser<Event> parser = new Parser<>(mapper);

    @Test(expected = MappingException.class)
    public void testNullBuffer() throws MappingException {
        mapper.map(null, 0);
    }

    @Test(expected = MappingException.class)
    public void testBlankBuffer() throws MappingException {
        mapper.map("", 0);
    }

    @Test(expected = MappingException.class)
    public void testInvalidBufferWithoutSpaces() throws MappingException {
        mapper.map("Invalid_times_without_spaces", 0);
    }

    @Test(expected = MappingException.class)
    public void testInvalidBufferWithSpaces() throws MappingException {
        mapper.map("XX:XX XX:XX XX:XX", 0);
    }

    @Test(expected = MappingException.class)
    public void testTwoWordsBuffer() throws MappingException {
        mapper.map("XX:XX XX:XX", 0);
    }

    @Test(expected = MappingException.class)
    public void testIncorrectTime() throws MappingException {
        mapper.map("00:00 25:00", 0);
    }

    @Test
    public void testCorrectData() throws MappingException {
        mapper.map("00:00 24:00", 0);
    }

    @Test(expected = NullPointerException.class)
    public void testNullReader() throws IOException {
        parser.parse(null);
    }

    @Test
    public void testParserWithValidData() throws IOException {
        try (FileReader fileReader = new FileReader(
                Objects.requireNonNull(classLoader.getResource("input_0.txt")).getPath());
             LineNumberReader lineNumberReader = new LineNumberReader(fileReader)) {
            Assert.assertEquals(12, parser.parse(lineNumberReader).size());
        }
    }

    @Test
    public void testParserWithEmptyFile() throws IOException {
        try (FileReader fileReader = new FileReader(
                Objects.requireNonNull(classLoader.getResource("input_2.txt")).getPath());
             LineNumberReader lineNumberReader = new LineNumberReader(fileReader)) {
            Assert.assertEquals(0, parser.parse(lineNumberReader).size());
        }
    }
}
