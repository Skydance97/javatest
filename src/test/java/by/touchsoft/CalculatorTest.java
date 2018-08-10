package by.touchsoft;

import by.touchsoft.model.Worktime;
import by.touchsoft.processor.Calculator;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void test() {
        List<Worktime> worktimes = new LinkedList<>(Arrays.asList(
                new Worktime(LocalTime.parse("08:00"), LocalTime.parse("17:00")),
                new Worktime(LocalTime.parse("10:00"), LocalTime.parse("16:00")),
                new Worktime(LocalTime.parse("09:00"), LocalTime.parse("11:00")),
                new Worktime(LocalTime.parse("11:30"), LocalTime.parse("17:00")),
                new Worktime(LocalTime.parse("11:00"), LocalTime.parse("19:00")),
                new Worktime(LocalTime.parse("11:00"), LocalTime.parse("12:00"))
        ));
        Assert.assertEquals(5, calculator.calculate(worktimes));
    }
}
