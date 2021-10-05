package ua.lviv.iot.view;

import ua.lviv.iot.manager.EntityManager;

import java.util.*;

public class Formatter<T, K> {

    private static final String BREAK = "-------------------------------------------------------------";
    private static final String NO_MATCHES_FOUND = "No matches found";
    private static final String ERROR_CREATE_OR_MODIFY = "Unable to create or modify this object";

    private final EntityManager<T, K> entityManager;

    public Formatter(Class<T> clazz) {
        this.entityManager = new EntityManager<>(clazz);
    }


    public void printFormattedTable(List<T> entities) {
        System.out.println(String.join("\t|\t", entityManager.getFieldsNames()));
        System.out.println(BREAK);
        for (T entity : entities) {
            System.out.println(String.join("\t|\t", entityManager.getFieldsValues(entity)));
        }
        System.out.println(BREAK + "\n");
    }

    public void printNoMatchesFound() {
        System.out.println(BREAK);
        System.out.println(NO_MATCHES_FOUND);
        System.out.println(BREAK + "\n");
    }

    public void printEntity(T entity) {
        System.out.println(String.join("\t|\t", entityManager.getFieldsNames()));
        System.out.println(BREAK);
        System.out.println(String.join("\t|\t", entityManager.getFieldsValues(entity)));
        System.out.println(BREAK + "\n");
    }

    public void printCreateOrModifyError() {
        System.out.println(BREAK);
        System.out.println(ERROR_CREATE_OR_MODIFY);
        System.out.println(BREAK + "\n");
    }
}
