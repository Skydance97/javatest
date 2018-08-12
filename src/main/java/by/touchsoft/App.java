package by.touchsoft;

import by.touchsoft.core.TaskExecutor;

/**
 * @author Alexander Shukaylo
 * https://github.com/Skydance97/javatest
 */
public class App {

    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                throw new IllegalArgumentException("For correct execution " +
                        "of the application it's necessary to add arguments");
            }

            for (String arg : args) {
                TaskExecutor taskExecutor = new TaskExecutor();
                System.out.println("The maximum number of employees " +
                        "at the same time in 'Super Power Soft' office: " +
                        taskExecutor.execute(arg));
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
