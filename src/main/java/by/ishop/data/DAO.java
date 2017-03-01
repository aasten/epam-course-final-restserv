package by.ishop.data;

import java.io.Serializable;

public interface DAO<T, PK extends  Serializable> {
    // some methods are commented out by design
//    Long addNew(T t);
    T getById(PK id); // throws RuntimeException
//    void delete(Long id);
//    void update(Long id, T t);
}