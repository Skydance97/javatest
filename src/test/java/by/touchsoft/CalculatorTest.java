package by.touchsoft;

import by.touchsoft.core.util.Calculator;
import by.touchsoft.model.Event;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;
import java.util.Arrays;

public class CalculatorTest {

    @Test(expected = NullPointerException.class)
    public void testNull() {
        Calculator.calcMaxNumOfEmployees(null);
    }

    @Test(expected = NullPointerException.class)
    public void testIncorrectData() {
        Calculator.calcMaxNumOfEmployees(
                Arrays.asList(
                        new Event(LocalTime.parse("09:00"), Event.Type.IN),
                        null,
                        new Event(LocalTime.parse("16:00"), Event.Type.OUT)
                )
        );
    }

    @Test
    public void testCorrectData() {
        Assert.assertEquals(
                3,
                Calculator.calcMaxNumOfEmployees(
                        Arrays.asList(
                                new Event(LocalTime.parse("09:00"), Event.Type.IN),
                                new Event(LocalTime.parse("10:00"), Event.Type.IN),
                                new Event(LocalTime.parse("11:00"), Event.Type.IN),
                                new Event(LocalTime.parse("16:00"), Event.Type.OUT),
                                new Event(LocalTime.parse("17:00"), Event.Type.OUT),
                                new Event(LocalTime.parse("16:00"), Event.Type.OUT)
                        )
                )
        );
    }
}
