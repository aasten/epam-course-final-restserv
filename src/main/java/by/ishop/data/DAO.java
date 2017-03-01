package by.ishop.data;

import java.io.Serializable;

public interface DAO<T, PK extends  Serializable> {
    Long addNew(T t);
    T getById(Long id); // throws RuntimeException
    void delete(Long id);
    void update(Long id, T t);
}