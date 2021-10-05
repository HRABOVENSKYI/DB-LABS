package ua.lviv.iot.view;

import ua.lviv.iot.annotations.Column;
import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.manager.EntityManager;

import java.lang.reflect.*;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ViewOperations<T, K> {

    private static final String KEY_EXIT = "Q";
    private static final String TEXT_ENTER_FIELD_OR_QUIT_FORMAT = "Enter %s or press '" + KEY_EXIT + "' to go back: ";
    private static final String TEXT_ENTER_FIELD_FORMAT = "Enter %s: ";
    private static final String ERROR_INVALID_VALUE = "Entered invalid value";

    private static Scanner input = new Scanner(System.in, StandardCharsets.UTF_8);

    private final AbstractController<T, K> controller;
    private final Formatter<T, K> formatter;
    private final EntityManager<T, K> entityManager;

    public ViewOperations(AbstractController<T, K> controller, Formatter<T, K> formatter, Class<T> entityClass) {
        this.controller = controller;
        this.formatter = formatter;
        this.entityManager = new EntityManager<>(entityClass);
    }

    public void findAll() {
        List<T> entities = controller.findAll();
        if (!entities.isEmpty()) {
            formatter.printFormattedTable(entities);
        } else {
            formatter.printNoMatchesFound();
        }
    }

    public void findById() {
        String keyMenu;
        do {
            System.out.println(String.format(TEXT_ENTER_FIELD_OR_QUIT_FORMAT, "id"));
            keyMenu = input.nextLine().toUpperCase();
            if (!keyMenu.equals(KEY_EXIT)) {
                @SuppressWarnings("unchecked")
                K id = (K) keyMenu;
                T foundEntity = controller.findById(id);
                if (foundEntity != null) {
                    formatter.printEntity(foundEntity);
                } else {
                    formatter.printNoMatchesFound();
                }
            }
        } while (!keyMenu.equals(KEY_EXIT));
    }

    public void create() {
        Field[] columns = entityManager.getColumns().toArray(new Field[0]);
        try {
            T entity = entityManager.getClazz().getConstructor().newInstance();
            for (Field column : columns) {
                inputValueForField(column, entity);
            }
            T newEntity = controller.create(entity);
            if (newEntity != null) {
                formatter.printEntity(newEntity);
            } else {
                formatter.printCreateOrModifyError();
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            System.out.println("Exception " + e.getClass() + " was thrown. Try again.");
        }
    }

    public void update() {

    }

    public void delete() {

    }

    private void inputValueForField(Field field, T entity) {
        Column columnAnnotation = field.getAnnotation(Column.class);
        String fieldName = columnAnnotation.name();
        Class<?> fieldType = field.getType();
        String hint = null;
        if (fieldType == Integer.class) {
            hint = "integer using [0-9] digits";
        } else if (fieldType == String.class) {
            hint = "Pass any String :)";
        } else if (fieldType == Timestamp.class) {
            hint = "Pass timestamp in format yyyy-MM-dd hh:mm:ss.SSSSSS";
        }
        while (true) {
            System.out.println(String.format(TEXT_ENTER_FIELD_FORMAT, String.format("%s (%s)", fieldName, hint)));
            String inputText = input.nextLine();
            field.setAccessible(true);
            try {
                if (fieldType == Integer.class) {
                    Integer value = Integer.parseInt(inputText);
                    field.set(entity, value);
                } else if (fieldType == String.class) {
                    field.set(entity, inputText);
                } else if (fieldType == Timestamp.class) {
                    LocalDateTime localDateTime = parseTimestamp(inputText);
                    field.set(entity, localDateTime);
                } else {
                    System.out.println(ERROR_INVALID_VALUE);
                    continue;
                }
                break;
            } catch (IllegalAccessException e) {
                System.out.println("IllegalAccessException: " + e.getMessage());
            }
        }
    }

    private LocalDateTime parseTimestamp(String inputText) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss.SSSSSS");
        LocalDateTime dateTime = LocalDateTime.parse(inputText, dateFormat);
        return dateTime;
    }
}
