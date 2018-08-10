package by.touchsoft;

import by.touchsoft.processor.Processor;

import java.util.*;

/**
 * @author Alexander Shukaylo
 * https://github.com/Skydance97/javatest
 */
public class App {

    public static void main(String[] args) {
        Objects.requireNonNull(args, "Program arguments can't be null");
        for (String arg : args) {
            Processor processor = new Processor();
            System.out.println("The maximum number of employees at the same time in 'Super Power Soft' office: " +
                    processor.process(arg));
        }
    }
}
