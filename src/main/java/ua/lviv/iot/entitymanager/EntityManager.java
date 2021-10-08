package ua.lviv.iot.entitymanager;

import lombok.Getter;

import javax.persistence.Column;
import java.lang.reflect.*;
import java.util.*;

@Getter
public class EntityManager<T> {

    private final Class<T> clazz;
    private final Field[] fields;

    public EntityManager(Class<T> clazz) {
        this.clazz = clazz;
        this.fields = clazz.getDeclaredFields();
    }

    public Object[] getFieldsValuesArr(T entity) {
        return Arrays.stream(fields)
                .map(f -> {
                    f.setAccessible(true);
                    try {
                        return f.get(entity) == null ? "" : f.get(entity);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return "null";
                })
                .toArray();
    }

    public String[] getFieldsNamesArr() {
        return Arrays.stream(fields)
                .map(f -> f.isAnnotationPresent(Column.class) ? f.getAnnotation(Column.class).name() : f.getName())
                .toArray(String[]::new);
    }
}