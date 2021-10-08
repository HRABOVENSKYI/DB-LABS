package ua.lviv.iot.view;

import org.hibernate.TypeMismatchException;
import ua.lviv.iot.controller.AbstractController;

import java.io.Serializable;
import java.lang.reflect.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ViewOperations<T, K extends Serializable> {

    private static final String KEY_EXIT = "Q";
    private static final String TEXT_ENTER_FIELD_OR_QUIT_FORMAT = "Enter %s or press '" + KEY_EXIT + "' to go back: ";
    private static final String TEXT_ENTER_FIELD_FORMAT = "Enter %s: ";
    private static final String ERROR_INVALID_VALUE = "Entered invalid value";
    private static final String TEXT_CHOOSE_FIELD = "Choose field to update (enter name):";

    private static Scanner input = new Scanner(System.in, StandardCharsets.UTF_8);

    private final AbstractController<T, K> controller;
    private final Class<T> entityClass;
    private final Formatter<T> formatter;

    public ViewOperations(AbstractController<T, K> controller, Formatter<T> formatter, Class<T> entityClass) {
        this.controller = controller;
        this.entityClass = entityClass;
        this.formatter = formatter;
    }

    public void findAll() {
        List<T> entities = controller.findAll();
        if (!entities.isEmpty()) {
            formatter.printFormattedTable(entities);
        } else {
            formatter.printNoMatchesFound();
        }
    }

    @SuppressWarnings("unchecked")
    public void findById() {
        String keyMenu;
        do {
            System.out.printf(TEXT_ENTER_FIELD_OR_QUIT_FORMAT, "id");
            keyMenu = input.nextLine().toUpperCase();
            if (!keyMenu.equals(KEY_EXIT)) {
                T foundEntity;
                try {
                    Integer id = Integer.parseInt(keyMenu);
                    foundEntity = controller.findById((K) id);
                } catch (TypeMismatchException | NumberFormatException e) {
                    String id = keyMenu;
                    foundEntity = controller.findById((K) id);
                }
                if (foundEntity != null) {
                    formatter.printEntity(foundEntity);
                } else {
                    formatter.printNoMatchesFound();
                }

            }
        } while (!keyMenu.equals(KEY_EXIT));
    }

    public void create() {
    }

    public void update() {
    }

    public void delete() {
    }

    private void inputValueForField(Field field, T entity) {
    }

    private Field getFieldByName(Field[] fields, String fieldName) {
        return null;
    }
}
