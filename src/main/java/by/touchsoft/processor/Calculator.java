package by.touchsoft.processor;

import by.touchsoft.model.Worktime;

import java.time.LocalTime;
import java.util.*;

public class Calculator {

    private Set<LocalTime> points = new TreeSet<>();

    public int calculate(List<Worktime> worktimes) {
        initIntervals(worktimes);
        return calcMaxNumOfEmployees(worktimes);
    }

    private void initIntervals(List<Worktime> worktimes) {
        for (Worktime worktime : worktimes) {
            points.add(worktime.getIn());
            points.add(worktime.getOut());
        }
    }

    private int calcMaxNumOfEmployees(List<Worktime> worktimes) {
        int curNum, maxNum = 0;

        for (LocalTime point : points) {
            curNum = 0;
            for (Worktime worktime : worktimes) {
                if (!point.isBefore(worktime.getIn()) && !point.isAfter(worktime.getOut())) {
                    curNum++;
                }
            }
            if (curNum > maxNum) {
                maxNum = curNum;
            }
        }

        return maxNum;
    }
}
