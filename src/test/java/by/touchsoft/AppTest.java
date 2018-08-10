package by.touchsoft;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.runners.Suite.*;

@RunWith(Suite.class)
@SuiteClasses({
        ProcessorValidTest.class,
        ProcessorInvalidTest.class,
        CalculatorTest.class
})
public class AppTest {
}
