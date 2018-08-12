package by.touchsoft.core;

import by.touchsoft.exception.MappingException;

import java.util.List;

@FunctionalInterface
public interface Mapper<T> {

    /**
     * This method describes formation rule
     * of objects list from a line (buffer) of file.
     *
     * At an error of a mapping throws {@link MappingException}
     *
     * @param buffer line for mapping in objects
     * @param num number of line in file
     * @return a list of mapped objects
     */
    List<T> map(String buffer, int num) throws MappingException;
}
