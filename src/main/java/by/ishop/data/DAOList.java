package by.ishop.data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sten on 05.03.17.
 */
public interface DAOList<T, PK extends Serializable> {

    /**
     * Retrieve N elements from storage starting from element (which is included)
     * identified by #id param
     * @param id Identifier of start element
     * @param N Count of elements lying in the storage starting from element whose identifier is #id.
     * @return List of entries total count not greater than N
     */
    List<T> getNStartFromId(PK id, Integer N);
}
