package org.example.repository;

import java.util.List;

public interface Repository<T> {

    T findById(Long id);

    boolean safeOrUpdate(T entity);

    boolean delete(Long id);

    List<T> getAll();

}
