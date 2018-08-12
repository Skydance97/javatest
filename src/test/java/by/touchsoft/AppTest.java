package by.touchsoft;

import by.touchsoft.core.TaskExecutor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class AppTest {

    @Parameter()
    public String filepath;

    @Parameter(1)
    public int maxNumber;

    private TaskExecutor taskExecutor = new TaskExecutor();

    private static ClassLoader classLoader = AppTest.class.getClassLoader();

    @Parameters(name = "{index}: process file {0}. Expected max number {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[]{Objects.requireNonNull(classLoader.getResource("input_0.txt")).getPath(), 4},
                new Object[]{Objects.requireNonNull(classLoader.getResource("input_1.txt")).getPath(), 3},
                new Object[]{Objects.requireNonNull(classLoader.getResource("input_2.txt")).getPath(), 0});
    }

    @Test
    public void test() {
        Assert.assertEquals(taskExecutor.execute(filepath), maxNumber);
    }
}
