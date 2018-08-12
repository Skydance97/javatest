package by.touchsoft;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.runners.Suite.*;

@RunWith(Suite.class)
@SuiteClasses({
        ParserTest.class,
        CalculatorTest.class
})
public class UnitTest {
}
