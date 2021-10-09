package ua.lviv.iot.dao.impl;

import org.hibernate.PropertyValueException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.lviv.iot.dao.AbstractDao;
import ua.lviv.iot.hibernate.HibernateUtil;

import java.io.Serializable;
import java.util.*;

public abstract class AbstractDaoImpl<T, K extends Serializable> implements AbstractDao<T, K> {

    private final Class<T> clazz;
    private final SessionFactory sessionFactory;

    protected AbstractDaoImpl(Class<T> clazz) {
        this.clazz = clazz;
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public List<T> findAll() {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            Query<T> query = session.createQuery("from " + clazz.getName(), clazz);
            List<T> resultList = query.getResultList();
            transaction.commit();
            return resultList;
        }
    }

    @Override
    public T findById(K id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            T entity;
            try {
                entity = session.get(clazz, id);
            } catch (IllegalArgumentException e) {
                return null;
            }
            transaction.commit();
            return entity;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public K create(T entity) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            Object id;
            try {
                id = session.save(entity);
            } catch (PropertyValueException e) {
                return null;
            }
            transaction.commit();
            return (K) id;
        }
    }

    @Override
    public int update(T entity) {
        return 0;
    }

    @Override
    public int delete(K id) {
        return 0;
    }
}
