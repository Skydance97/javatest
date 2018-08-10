package by.touchsoft;

import by.touchsoft.processor.Processor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class ProcessorValidTest {

    private Processor processor = new Processor();

    @Parameter()
    public String filepaths;
    @Parameter(1)
    public int maxNumbers;

    @Parameters(name = "{index}: process file '{0}'. Expected '{1}'")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[]{"D:\\TouchSoft_Test_Tasks\\javatest\\src\\test\\resources\\input.txt", 4},
                new Object[]{"D:\\TouchSoft_Test_Tasks\\javatest\\src\\test\\resources\\input_01.txt", 0});
    }

    @Test
    public void testValidFiles() {
        Assert.assertEquals(processor.process(filepaths), maxNumbers);
    }
}
