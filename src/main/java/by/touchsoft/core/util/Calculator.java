package by.touchsoft.core.util;

import by.touchsoft.model.Event;

import java.util.*;

public class Calculator {

    public static int calcMaxNumOfEmployees(List<Event> events) {
        Collections.sort(events);

        int curNum = 0, maxNum = 0;

        for (Event e : events) {
            if (e.getType() == Event.Type.IN) {
                curNum++;
            }
            if (e.getType() == Event.Type.OUT) {
                curNum--;
            }
            if (curNum > maxNum) {
                maxNum = curNum;
            }
        }

        return maxNum;
    }
}
