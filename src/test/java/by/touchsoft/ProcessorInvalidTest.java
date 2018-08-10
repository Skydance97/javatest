package by.touchsoft;

import by.touchsoft.exception.ProcessingException;
import by.touchsoft.processor.Processor;
import org.junit.Test;

public class ProcessorInvalidTest {

    private Processor processor = new Processor();

    @Test(expected = ProcessingException.class)
    public void testInvalidFile() {
        processor.process("D:\\TouchSoft_Test_Tasks\\javatest\\src\\test\\resources\\input_02.txt");
    }

    @Test(expected = ProcessingException.class)
    public void testWithInvalidPath() {
        processor.process("D:\\input.txt");
    }
}
