package by.ishop.data;

import java.io.Serializable;

public interface DAO<T extends Serializable> {
    T getById(Long id); // throws RuntimeException
}