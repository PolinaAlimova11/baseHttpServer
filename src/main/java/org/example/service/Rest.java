package org.example.service;

import java.util.List;

public interface Rest<T> {

    List<T> getAll();

    T get(Long id);

    boolean create(T entity);
    boolean update(T entity);
    boolean delete(Long id);

}
