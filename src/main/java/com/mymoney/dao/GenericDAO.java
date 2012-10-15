package com.mymoney.dao;

import java.io.Serializable;
import java.util.List;

//T is Type the DAO deals with (ID for unique identifier)
//public interface GenericDAO<T, ID extends Serializable> {
//
//    T findById(ID id, boolean lock);
//
//    List<T> findAll();
//
//    List<T> findByExample(T exampleInstance, String... excludeProperty);
//
//    T makePersistent(T entity);
//
//    void makeTransient(T entity);
//}

/**
 * An interface shared by all business data access objects.
 * <p>
 * All CRUD (create, read, update, delete) basic data access operations are
 * isolated in this interface and shared across all DAO implementations.
 * The current design is for a state-management oriented persistence layer
 * (for example, there is no UPDATE statement function) that provides
 * automatic transactional dirty checking of business objects in persistent
 * state.
 *
 * @author Christian Bauer
 */
public interface GenericDAO<T, ID extends Serializable> {

    T findById(ID id, boolean lock);
    
    T findById(ID id);

    List<T> findAll();

    List<T> findByExample(T exampleInstance, String... excludeProperty);

    T makePersistent(T entity);

    void makeTransient(T entity);

    /**
     * Affects every managed instance in the current persistence context!
     */
    void flush();

    /**
     * Affects every managed instance in the current persistence context!
     */
    void clear();

}
